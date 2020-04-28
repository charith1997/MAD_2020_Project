package com.example.mad_2020_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdminLogin extends AppCompatActivity {

    Context context;
    private EditText Username,Password;
    private Button LoginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        context = this;
        Username = findViewById(R.id.adminLoginUsername);
        Password = findViewById(R.id.adminLoginPassword);
        LoginButton = findViewById(R.id.adminLoginButton);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,AdminHome.class));
            }
        });
    }
}
