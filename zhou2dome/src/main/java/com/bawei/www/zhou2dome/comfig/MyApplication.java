package com.bawei.www.zhou2dome.comfig;

import android.app.Application;
import android.graphics.Bitmap;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;
//import com.umeng.commonsdk.UMConfigure;
//import com.umeng.socialize.PlatformConfig;

/**
 * 第一步：导入jar包和res文件，将jar包add as lib..
 * 第二步：自定义Application 在onCreate中完成以下两行代码（所有参数没有自己注册过不要改）
 * 第三步：在Manifests中添加配置，详见Manifests注释（不要随意修改）
 * 第四步：在需要调用的地方写调用，详见MainActivity中
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ImageLoader.getInstance().init(
                new ImageLoaderConfiguration.Builder(this)
                        .memoryCacheSizePercentage(10)
                        .diskCacheSize(50*1024*1024)
                        .defaultDisplayImageOptions(new DisplayImageOptions.Builder()
                                .cacheInMemory(true)
                                .cacheOnDisk(true)
                                .bitmapConfig(Bitmap.Config.RGB_565)
                                .build())
                        .build()

        );

        UMConfigure.init(this,"5a12384aa40fa3551f0001d1","umeng",UMConfigure.DEVICE_TYPE_PHONE,"");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
    }
}
