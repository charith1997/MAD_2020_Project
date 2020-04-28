package com.example.mad_2020_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StaffLogin extends AppCompatActivity {

    Context context;
    private EditText username,password;
    private Button loginButton,loginButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_login);

        context = this;

        username = findViewById(R.id.staffLoginUsername);
        password = findViewById(R.id.staffLoginPassword);
        loginButton = findViewById(R.id.staffLoginButton);
        loginButton2 = findViewById(R.id.staffLoginButton2);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,StaffHome.class));
            }
        });

    }
}
