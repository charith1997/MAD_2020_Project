package com.example.mad_2020_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddSeller extends AppCompatActivity {

    private EditText Name,Email,PhoneNo,Location,Workers,FromDate,ToDate,Password;
    private Button AddSeller;
    private SellerDbHandler sellerDbHandler;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_seller);

        Name = findViewById(R.id.auUsernametxt);
        Email = findViewById(R.id.auEmailtxt);
        PhoneNo = findViewById(R.id.auMobiletxt);
        Location = findViewById(R.id.auLocationtxt);
        Workers = findViewById(R.id.auWorkerstxt);
        FromDate = findViewById(R.id.auDateFrom);
        ToDate = findViewById(R.id.auDateTo);
        Password = findViewById(R.id.auPwdtxt);
        AddSeller = findViewById(R.id.auRegisterButton);

        context = this;
        sellerDbHandler = new SellerDbHandler(context);

        AddSeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = Name.getText().toString();
                String email = Email.getText().toString();
                String phoneNo = PhoneNo.getText().toString();
                String location = Location.getText().toString();
                String workers = Workers.getText().toString();
                String fromDate = FromDate.getText().toString();
                String toDate = ToDate.getText().toString();
                String password = Password.getText().toString();

                Seller seller = new Seller(name,email,phoneNo,location,workers,fromDate,toDate,password);
                sellerDbHandler.addSeller(seller);

                startActivity(new Intent(context,AdminHome.class));
            }
        });
    }
}
