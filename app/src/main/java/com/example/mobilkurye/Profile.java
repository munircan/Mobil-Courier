package com.example.mobilkurye;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Profile extends AppCompatActivity {

    TextInputLayout fullName, mail, phoneNo, password;
    TextView fullNameLabel, usernameLabel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        fullName = findViewById(R.id.name);
        mail = findViewById(R.id.email);
        phoneNo = findViewById(R.id.phoneNo);
        password = findViewById(R.id.password);
        fullNameLabel = findViewById(R.id.fullname);
        usernameLabel = findViewById(R.id.username);

        showAllDataUser();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.profile);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.n_dispatch:
                        startActivity(new Intent(getApplicationContext(), New_Dispatch.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.dispatch:
                        startActivity(new Intent(getApplicationContext(), Dispatch.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.profile:
                        return true;
                }
                return false;
            }
        });



    }
    private void showAllDataUser(){
        Intent intent = getIntent();
        String user_username = intent.getStringExtra("username");
        String user_name = intent.getStringExtra("name");
        String user_mail = intent.getStringExtra("mail");
        String user_phoneNo = intent.getStringExtra("phoneNo");
        String user_password = intent.getStringExtra("password");


        fullNameLabel.setText(user_name);
        usernameLabel.setText(user_username);
        fullNameLabel.setText(user_name);
        fullName.getEditText().setText(user_name);
        mail.getEditText().setText(user_mail);
        phoneNo.getEditText().setText(user_phoneNo);
        password.getEditText().setText(user_password);




    }
}