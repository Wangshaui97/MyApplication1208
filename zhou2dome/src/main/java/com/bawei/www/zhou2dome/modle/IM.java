package com.bawei.www.zhou2dome.modle;

import com.bawei.www.zhou2dome.myCallback.MyCallback;

public interface IM {
    void setrequset(String url, MyCallback callback);
    void setsignrequset(String url, MyCallback callback);
    void setbanner(String url, MyCallback callback);
    void setlist(String url, MyCallback callback);
}
