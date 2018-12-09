package com.bawei.www.zhou2dome.view;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bawei.www.zhou2dome.R;
import com.bawei.www.zhou2dome.adpter.MyFragmentAdapter;
import com.bawei.www.zhou2dome.personter.IPersonter;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements IVew {


    private ViewPager vp;
    private List<Fragment> list;
    private MyFragmentAdapter md;
    private TabLayout tabs;
    private String screen_name;
    private String image_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        vp = findViewById(R.id.vp);
        tabs = findViewById(R.id.tabs);


        list = new ArrayList<>();
        list.add(new BannerlistFragment());
        list.add(new QRcodeFragment());
        md = new MyFragmentAdapter(getSupportFragmentManager(), this, list);
        vp.setAdapter(md);
        tabs.setupWithViewPager(vp);

        Intent intent  = getIntent();

        screen_name = intent.getStringExtra("screen_name");
        image_url = intent.getStringExtra("image_url");


    }

    public String setName(){
        return screen_name;
    }


    public String setImg(){
        return image_url;
    }


    @Override
    public void setsuccess(Object data) {

    }

    @Override
    public void setlistsuccess(Object data) {

    }

    @Override
    public void setQRcode(Object n, Object i) {

    }
}
