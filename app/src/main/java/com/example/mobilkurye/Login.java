package com.example.mobilkurye;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    Button callSignUp,login_button;
    ImageView image;
    TextView logo,slogan;
    TextInputLayout username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);

        callSignUp = findViewById(R.id.sign_up);

        image = findViewById(R.id.logoImage);
        logo = findViewById(R.id.logoName);
        slogan = findViewById(R.id.slogan_name);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login_button = findViewById(R.id.login);

        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,SignUp.class);
                Pair[] pairs = new Pair[7];

                pairs[0] = new Pair<View,String>(image,"logoImage");
                pairs[1] = new Pair<View,String>(logo,"logoText");
                pairs[2] = new Pair<View,String>(slogan,"logo_desc");
                pairs[3] = new Pair<View,String>(username,"username_tran");
                pairs[4] = new Pair<View,String>(password,"password_tran");
                pairs[5] = new Pair<View,String>(login_button,"signin_tran");
                pairs[6] = new Pair<View,String>(callSignUp,"signup_tran");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this,pairs);
                    startActivity(intent,options.toBundle());
                }
            }
        });

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Dispatch.class);
                startActivity(intent);
            }
        });


    }
}