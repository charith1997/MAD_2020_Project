package com.example.mad_2020_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class AddUser extends AppCompatActivity {

    private EditText username,email,mobileNo,venue,workers,dateFrom,dateTo,password,retypePassword;
    private Button register;
    private DbHandler dbHandler;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        context = this;
        username = findViewById(R.id.auUsernametxt);
        email = findViewById(R.id.auEmailtxt);
        mobileNo = findViewById(R.id.auMobiletxt);
        venue = findViewById(R.id.auLocationtxt);
        workers = findViewById(R.id.auWorkerstxt);
        dateFrom = findViewById(R.id.auDateFrom);
        dateTo = findViewById(R.id.auDateTo);
        password = findViewById(R.id.auPwdtxt);
        retypePassword = findViewById(R.id.auRePwtxt);

        register = findViewById(R.id.auRegisterButton);

        dbHandler = new DbHandler(context);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username = username.getText().toString();
                String Email = email.getText().toString();
                String MobileNo = mobileNo.getText().toString();
                String Venue = venue.getText().toString();
                Integer Workers = Integer.valueOf(workers.getText().toString());
                String DateFrom = dateFrom.getText().toString();
                String DateTo = dateTo.getText().toString();
                String Password =  password.getText().toString();
                String RetypePassword = retypePassword.getText().toString();

                Seller seller = new Seller(Username,Email,MobileNo,Venue,Workers,DateFrom,DateTo,Password,RetypePassword);

                dbHandler.addSeller(seller);

                Intent intent = new Intent(context,AdminHome.class);
                startActivity(intent);
            }
        });
    }
}
