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
import com.bawei.www.zhou2dome.bean.OtherLoginbean;
import com.bawei.www.zhou2dome.personter.IPersonter;

public class SignActivity extends AppCompatActivity implements IVew {

    private EditText putinname, putinpwd;
    private Button login;
    private IPersonter iPersonter;
    private String str = "http://120.27.23.105/user/reg?mobile=%s&password=%s";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);


        putinname = findViewById(R.id.putinname);
        putinpwd = findViewById(R.id.putinpwd);

        login = findViewById(R.id.login);
        iPersonter = new IPersonter(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = putinname.getText().toString();
                String p = putinpwd.getText().toString();

                iPersonter.setsignresponse(String.format(str, n, p));
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
        OtherLoginbean otherLoginbean = (OtherLoginbean) data;
        Toast.makeText(SignActivity.this, "" + otherLoginbean.getMsg(), Toast.LENGTH_SHORT).show();
        if (otherLoginbean.getMsg().equals("注册成功")) {
            startActivity(new Intent(SignActivity.this, MainActivity.class));
        }

    }

    @Override
    public void setlistsuccess(Object data) {

    }

    @Override
    public void setQRcode(Object n, Object i) {

    }
}
