package com.example.mad_2020_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterStudent extends AppCompatActivity {

    private EditText studentID,studentName,email,mobileNo,password,retypePassword;
    private Button register;
    private StudentDbHandler studentDbHandler;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student);


        context = this;
        studentID = findViewById(R.id.StudentIDtxt);
        studentName = findViewById(R.id.StudentNametxt);
        email = findViewById(R.id.Emailtxt);
        mobileNo = findViewById(R.id.PhoneNotxt);
        password = findViewById(R.id.Passwordtxt);
        retypePassword = findViewById(R.id.ReTypePasswordtxt);
        register = findViewById(R.id.StudentRegister);

        studentDbHandler = new StudentDbHandler(context);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String StudentName = studentName.getText().toString();
                String Email = email.getText().toString();
                String MobileNo = mobileNo.getText().toString();
                String Password = password.getText().toString();
                String ConfirmPassword = retypePassword.getText().toString();

                Student student = new Student(StudentName,Email,MobileNo,Password,ConfirmPassword);

                studentDbHandler.addStudent(student);

                Intent intent = new Intent(context,StudentHome.class);
                startActivity(intent);
            }
        });
    }
}
