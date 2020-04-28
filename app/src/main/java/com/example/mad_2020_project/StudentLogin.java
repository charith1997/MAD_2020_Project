package com.example.mad_2020_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StudentLogin extends AppCompatActivity {

    Context context;
    private EditText Username,Password;
    private Button LoginButton,Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        context = this;
        Username = findViewById(R.id.studentLoginUsername);
        Password = findViewById(R.id.studentLoginPassword);
        LoginButton = findViewById(R.id.studentLoginButton);
        Register = findViewById(R.id.studentRegisterButton);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,StudentHome.class));
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,RegisterStudent.class));
            }
        });
    }
}
