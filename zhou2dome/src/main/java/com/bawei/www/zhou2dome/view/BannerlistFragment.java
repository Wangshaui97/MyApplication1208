package com.bawei.www.zhou2dome.view;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.bawei.www.zhou2dome.R;
import com.bawei.www.zhou2dome.adpter.MyAdapter;
import com.bawei.www.zhou2dome.bean.BannerBena;
import com.bawei.www.zhou2dome.bean.NewsBean;
import com.bawei.www.zhou2dome.personter.IPersonter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoaderInterface;

import java.util.List;


public class BannerlistFragment extends Fragment implements IVew {

    private Banner banner_w;
    private String url = "https://api.tianapi.com/wxnew/?key=c4aa776e0a51d57d6750511e2baa46b6&num=6&page=1";
    private String path="http://apis.juhe.cn/cook/query?key=9dc74007e90b957d8c63f0a44445b0e4&menu=%E8%A5%BF%E7%BA%A2%E6%9F%BF&rn=10&pn=3";
    private IPersonter iPersonter;
    private ListView listitem;
    private MyAdapter md;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = View.inflate(getActivity(), R.layout.fragment_bannerlist, null);

        banner_w = view.findViewById(R.id.banner_w);
        listitem = view.findViewById(R.id.listitem);

        md = new MyAdapter(getActivity());
        listitem.setAdapter(md);


        iPersonter = new IPersonter(this);

        iPersonter.setbannerresponse(url);

        iPersonter.setlistresponse(path);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        iPersonter.onDetouch();
    }

    @Override
    public void setsuccess(Object data) {
        initbanner(data);

    }

    @Override
    public void setlistsuccess(Object data) {
        initlist(data);
    }

    @Override
    public void setQRcode(Object n, Object i) {

    }

    private void initlist(Object data) {
        NewsBean newsBean = (NewsBean) data;

        List<NewsBean.ResultBean.DataBean> dataBeans = newsBean.getResult().getData();

        md.setData(dataBeans);

    }

    private void initbanner(Object data) {
        final BannerBena bannerBena = (BannerBena) data;
        banner_w.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);

        banner_w.setImageLoader(new ImageLoaderInterface<ImageView>() {

            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {

                List<BannerBena.NewslistBean> newslist = bannerBena.getNewslist();
                for (int i = 0; i < 6; i++) {
                    com.nostra13.universalimageloader.core.ImageLoader.getInstance().displayImage(newslist.get(i).getPicUrl(), imageView);
                }

            }

            @Override
            public ImageView createImageView(Context context) {
                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                return imageView;
            }

        });
        banner_w.setImages(bannerBena.getNewslist());
        banner_w.start();
    }
}
