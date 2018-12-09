package com.bawei.www.zhou2dome.view;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.bawei.www.zhou2dome.R;

public class QRcodeFragment extends Fragment{


    private Button qrcode;
    private String name;
    private String img;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = View.inflate(getActivity(), R.layout.fragment_qrcode, null);
        qrcode = view.findViewById(R.id.QRcode);

        qrcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                    ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CAMERA},100);
                    startActivity(new Intent(getActivity(),SAOActivity.class));
                }else {
                    startActivity(new Intent(getActivity(),SAOActivity.class));
                }
            }
        });

        name = ((HomeActivity) getActivity()).setName();
        img = ((HomeActivity) getActivity()).setImg();

        return view;
    }

}
