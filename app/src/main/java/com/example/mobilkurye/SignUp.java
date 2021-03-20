package com.example.mobilkurye;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SignUp extends AppCompatActivity {

    TextInputLayout regName, regEmail, regPhoneNo, regPassword;
    Button regBtn, regToLoginBtn;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        myRef.setValue("Hello, World!");

        regName = findViewById(R.id.name);
        regEmail = findViewById(R.id.email);
        regPhoneNo = findViewById(R.id.phoneNo);
        regPassword = findViewById(R.id.password);
        regBtn = findViewById(R.id.reg_btn);
        regToLoginBtn = findViewById(R.id.login);

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                //reference = rootNode.getReference("user");

                String name = regName.getEditText().getText().toString();
                String mail = regEmail.getEditText().getText().toString();
                String phoneno = regPhoneNo.getEditText().getText().toString();
                String password = regPassword.getEditText().getText().toString();

                Users user = new Users(name, mail, phoneno, password);
                rootNode.getReference().child("users").child(phoneno).setValue(user);
                //reference.child(phoneno).setValue(user);
            }
        });
    }
}