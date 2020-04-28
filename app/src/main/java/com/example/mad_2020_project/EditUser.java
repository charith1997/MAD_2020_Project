package com.example.mad_2020_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditUser extends AppCompatActivity {

    private EditText username,email,mobileNo,location,workers,dateFrom,dateTo,password,retypePassword;
    private Button update;
    private DbHandler dbHandler;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        context = this;

        username = findViewById(R.id.EdUsernametxt);
        email = findViewById(R.id.EdEmailtxt);
        mobileNo = findViewById(R.id.EdMobiletxt);
        location = findViewById(R.id.EdLocationtxt);
        workers = findViewById(R.id.EdWorkerstxt);
        dateFrom = findViewById(R.id.EdDateFrom);
        dateTo = findViewById(R.id.EdDateTo);
        password = findViewById(R.id.EdPwdtxt);
        retypePassword = findViewById(R.id.EdRePwtxt);
        update = findViewById(R.id.EditButton);

        dbHandler = new DbHandler(context);


        final String id = getIntent().getStringExtra("id");
        final Seller seller = dbHandler.getSingleUser(Integer.parseInt(id));

        username.setText(seller.getUsername());
        email.setText(seller.getEmail());
        mobileNo.setText(seller.getMobileNo());
        location.setText(seller.getVenue());
        workers.setText(seller.getWorkers());
        dateFrom.setText(seller.getDateFrom());
        dateTo.setText(seller.getDateTo());
        password.setText(seller.getPswd());
        retypePassword.setText(seller.getRePswd());

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Userame = username.getText().toString();
                String Email = email.getText().toString();
                String MobileNo = mobileNo.getText().toString();
                String Venue = location.getText().toString();
                Integer Workers = Integer.valueOf(workers.getText().toString());
                String DateFrom = dateFrom.getText().toString();
                String DateTo = dateTo.getText().toString();
                String Password =  password.getText().toString();
                String RetypePassword = retypePassword.getText().toString();

                Seller seller1 = new Seller(Integer.parseInt(id),Userame,Email,MobileNo,Venue,Workers,DateFrom,DateTo,Password,RetypePassword);
                int state = dbHandler.updateSingleView(seller1);

                startActivity(new Intent(context,AdminHome.class));
            }
        });
    }
}
