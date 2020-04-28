package com.example.mad_2020_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Context context;
    private TextView AdminLoginTxt,StaffLoginTxt,StudentLoginTxt;
    private ImageView AdminLoginImage,StaffLoginImage,StudentLoginImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        AdminLoginImage = findViewById(R.id.loginasAdmin);
        AdminLoginTxt = findViewById(R.id.loginasAdmintxt);
        StaffLoginImage = findViewById(R.id.loginasStaff);
        StaffLoginTxt = findViewById(R.id.loginasStafftxt);
        StudentLoginImage = findViewById(R.id.loginasStudent);
        StudentLoginTxt = findViewById(R.id.loginasStudenttxt);

        AdminLoginImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,AdminLogin.class));
            }
        });

        AdminLoginTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,AdminLogin.class));
            }
        });

        StaffLoginImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,StaffLogin.class));
            }
        });

        StaffLoginTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,StaffLogin.class));
            }
        });


    }
}
