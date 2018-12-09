package com.bawei.www.zhou2dome.adpter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.www.zhou2dome.R;
import com.bawei.www.zhou2dome.bean.NewsBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private List<NewsBean.ResultBean.DataBean> mlist;

    public MyAdapter(Context context) {
        this.context = context;
        mlist = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public NewsBean.ResultBean.DataBean getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if(convertView==null){
            vh = new ViewHolder();
            convertView = View.inflate(context, R.layout.listitem, null);
            vh.ttitle = convertView.findViewById(R.id.ttitle);
            vh.tags = convertView.findViewById(R.id.tags);
            vh.item_img = convertView.findViewById(R.id.item_img);
            convertView.setTag(vh);
        }else {
            vh = (ViewHolder) convertView.getTag();
        }
        vh.ttitle.setText(mlist.get(position).getTitle());

        vh.tags.setText(mlist.get(position).getTags());

        ImageLoader.getInstance().displayImage(mlist.get(position).getSteps().get(0).getImg(),vh.item_img);

        return convertView;
    }

    public void setData(List<NewsBean.ResultBean.DataBean> dataBeans) {
        this.mlist =dataBeans;
        notifyDataSetChanged();
    }

    class ViewHolder{
        TextView ttitle,tags;
        ImageView item_img;
    }

}
