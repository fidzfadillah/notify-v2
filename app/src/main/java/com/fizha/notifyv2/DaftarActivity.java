package com.fizha.notifyv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class DaftarActivity extends AppCompatActivity {
    private static final String TAG = "DaftarActivity";

    private TextInputEditText txtName, txtUsername, txtEmail, txtPass, txtPass2;
    private Spinner kelas;
    private RadioGroup jenkel;
    private RadioButton male;
    private RadioButton female;
    private MaterialButton btnRegis;

    private RadioButton radioButton;

    ImageView imgLogo;

    //toolbar
    ImageView btnBack;
    TextView toolbarTitle;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        initView();

        if (jenkel.getCheckedRadioButtonId() == R.id.male){
            female.setChecked(false);
        } else{
            male.setChecked(false);
        }

        btnBack.setImageResource(R.drawable.ic_baseline_arrow_back_24);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        toolbarTitle.setText("");

        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, MainActivity.class);
                startActivity(i);
            }
        });
    }

    private void initView() {
        btnBack = findViewById(R.id.toolbar_nav_icon);
        toolbarTitle = findViewById(R.id.toolbar_title);

        txtName = findViewById(R.id.txt_fullname);
        txtUsername = findViewById(R.id.txt_username);
        txtEmail = findViewById(R.id.txt_email);
        txtPass = findViewById(R.id.txt_password);
        txtPass2 = findViewById(R.id.txt_confirm_password);
        imgLogo = findViewById(R.id.logo);
        btnRegis = findViewById(R.id.btn_regis);

        jenkel = findViewById(R.id.jenkel);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);

        context = getBaseContext();
    }
}