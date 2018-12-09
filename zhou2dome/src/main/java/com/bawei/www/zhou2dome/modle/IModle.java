package com.bawei.www.zhou2dome.modle;

import com.bawei.www.zhou2dome.bean.BannerBena;
import com.bawei.www.zhou2dome.bean.LoginBean;
import com.bawei.www.zhou2dome.bean.NewsBean;
import com.bawei.www.zhou2dome.bean.OtherLoginbean;
import com.bawei.www.zhou2dome.httputils.HttpUtil;
import com.bawei.www.zhou2dome.myCallback.MyCallback;
import com.youth.banner.Banner;

public class IModle implements IM {

    @Override
    public void setrequset(String url, final MyCallback callback) {
        HttpUtil.getRequest(url, LoginBean.class, new HttpUtil.CallBack<LoginBean>() {
            @Override
            public void getdata(LoginBean loginBean) {
                callback.setdata(loginBean);
            }
        });
    }

    @Override
    public void setsignrequset(String url, final MyCallback callback) {
        HttpUtil.getRequest(url, OtherLoginbean.class, new HttpUtil.CallBack<OtherLoginbean>() {
            @Override
            public void getdata(OtherLoginbean loginBean) {
                callback.setdata(loginBean);
            }
        });
    }

    @Override
    public void setbanner(String url,final MyCallback callback) {
        HttpUtil.getRequest(url, BannerBena.class, new HttpUtil.CallBack<BannerBena>() {
            @Override
            public void getdata(BannerBena loginBean) {
                callback.setdata(loginBean);
            }
        });
    }

    @Override
    public void setlist(String url, final MyCallback callback) {
        HttpUtil.getRequest(url, NewsBean.class, new HttpUtil.CallBack<NewsBean>() {
            @Override
            public void getdata(NewsBean loginBean) {
                callback.setdata(loginBean);
            }
        });
    }

}
