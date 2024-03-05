package com.lsk.testapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {
    TextView tvOrigin;
    TextView tvEncry;
    TextView tvDecsy;
    Button btnEncry;
    Button btnDecry;

    String mSeed="lvshikai123";
    String mEncryStr = "" ;
    String originText = "lvshikai,吕石凯,中国,共产党,习近平";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvEncry =  findViewById(R.id.tv_main_encryption);
        tvDecsy =  findViewById(R.id.tv_main_decryption);
        btnEncry = findViewById(R.id.btn_encry);
        btnDecry = findViewById(R.id.btn_decry);
        btnEncry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                encryptStr();
            }
        });
 btnDecry.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
         decryptStr();
     }
 });
    }

    private void decryptStr() {
        try {
            String decrypt = AESUtils.decrypt(mSeed, mEncryStr);
            tvDecsy.setText(decrypt);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private void encryptStr() {
        try {
            mEncryStr = AESUtils.encrypt(mSeed, originText);
            tvEncry.setText(mEncryStr);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
