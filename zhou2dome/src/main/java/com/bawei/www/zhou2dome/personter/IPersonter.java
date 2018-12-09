package com.bawei.www.zhou2dome.personter;

import com.bawei.www.zhou2dome.modle.IModle;
import com.bawei.www.zhou2dome.myCallback.MyCallback;
import com.bawei.www.zhou2dome.view.IVew;

public class IPersonter implements IP {

    private IModle iModle;
    private IVew iVew;

    public IPersonter(IVew iVew) {
        this.iVew = iVew;
        iModle = new IModle();
    }

    @Override
    public void setresponse(String url) {
        iModle.setrequset(url, new MyCallback() {
            @Override
            public void setdata(Object data) {
                iVew.setsuccess(data);
            }
        });
    }

    @Override
    public void setsignresponse(String url) {
        iModle.setsignrequset(url, new MyCallback() {
            @Override
            public void setdata(Object data) {
                iVew.setsuccess(data);
            }
        });
    }

    @Override
    public void setbannerresponse(String url) {
        iModle.setbanner(url, new MyCallback() {
            @Override
            public void setdata(Object data) {
                iVew.setsuccess(data);
            }
        });
    }

    @Override
    public void setlistresponse(String url) {
        iModle.setlist(url, new MyCallback() {
            @Override
            public void setdata(Object data) {
                iVew.setlistsuccess(data);
            }
        });
    }



    public void onDetouch(){
        if(iVew!=null){
            iVew=null;
        }
        if(iModle!=null){
            iModle=null;
        }
    }
}
