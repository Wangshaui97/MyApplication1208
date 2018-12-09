package com.bawei.www.zhou2dome.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.www.zhou2dome.R;
import com.bawei.www.zhou2dome.bean.LoginBean;
import com.bawei.www.zhou2dome.personter.IPersonter;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements IVew{

    private EditText putinname,putinpwd;
    private Button login,otherlogin,threelogin;
    private IPersonter iPersonter;
    private IVew iVew;
    private String str="http://120.27.23.105/user/login?mobile=%s&password=%s";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        putinname = findViewById(R.id.putinname);
        putinpwd = findViewById(R.id.putinpwd);
        threelogin = findViewById(R.id.threelogin);

        login = findViewById(R.id.login);
        otherlogin = findViewById(R.id.otherlogin);

        iPersonter = new IPersonter(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = putinname.getText().toString();
                String p = putinpwd.getText().toString();

                iPersonter.setresponse(String.format(str,n,p));

            }
        });

        otherlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SignActivity.class));
            }
        });


        initThree();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    private void initThree() {

        threelogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UMShareAPI umShareAPI =  UMShareAPI.get(MainActivity.this);
                umShareAPI.getPlatformInfo(MainActivity.this, SHARE_MEDIA.QQ, new UMAuthListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {

                    }



                    @Override
                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {


                        String screen_name = map.get("screen_name");
                        String image_url = map.get("profile_image_url");

                        Intent intent =new Intent(MainActivity.this,HomeActivity.class);

                        intent.putExtra("screen_name",screen_name);
                        intent.putExtra("image_url",image_url);

                        startActivity(intent);
                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media, int i) {

                    }
                });
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        iPersonter.onDetouch();
    }

    @Override
    public void setsuccess(Object data) {
        LoginBean loginBean = (LoginBean) data;
        Toast.makeText(MainActivity.this,""+loginBean.getMsg(),Toast.LENGTH_SHORT).show();
        if(loginBean.getMsg().equals("登录成功")){
            startActivity(new Intent(MainActivity.this,HomeActivity.class));
        }
    }

    @Override
    public void setlistsuccess(Object data) {

    }

    @Override
    public void setQRcode(Object n, Object i) {

    }
}
