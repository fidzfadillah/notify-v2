package com.fizha.notifyv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
    private TextInputEditText mEmail, mPassword;
    private MaterialButton btnLogin;
    private TextView txtRegis;
    ImageView imgLogo;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, MainActivity.class);
                startActivity(i);
            }
        });

        txtRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DaftarActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void initView(){
        mEmail = findViewById(R.id.txt_email);
        mPassword = findViewById(R.id.txt_password);
        btnLogin = findViewById(R.id.btn_login);
        txtRegis = findViewById(R.id.daftar);
        imgLogo = findViewById(R.id.logo);

        context = getBaseContext();
    }
}