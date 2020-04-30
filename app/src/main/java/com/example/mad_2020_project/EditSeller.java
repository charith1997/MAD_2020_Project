package com.example.mad_2020_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditSeller extends AppCompatActivity {

    private EditText name,email,phoneNo,location,workers,dateFrom,dateTo,password;
    private Button update;
    private SellerDbHandler sellerDbHandler;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_seller);

        context = this;
        sellerDbHandler = new SellerDbHandler(context);

        name = findViewById(R.id.EditSeller1);
        email = findViewById(R.id.EditSeller2);
        phoneNo = findViewById(R.id.EditSeller3);
        location = findViewById(R.id.EditSeller4);
        workers = findViewById(R.id.EditSeller5);
        dateFrom = findViewById(R.id.EditSeller6);
        dateTo = findViewById(R.id.EditSeller7);
        password = findViewById(R.id.EditSeller8);
        update = findViewById(R.id.EditSellerButton);

        final  String id = getIntent().getStringExtra("id");
        Seller seller1 = sellerDbHandler.getSingleSeller(Integer.parseInt(id));

        name.setText(seller1.getName());
        email.setText(seller1.getEmail());
        phoneNo.setText(seller1.getPhoneNo());
        location.setText(seller1.getLocation());
        workers.setText(seller1.getWorkers());
        dateFrom.setText(seller1.getFromDate());
        dateTo.setText(seller1.getToDate());
        password.setText(seller1.getPassword());

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = name.getText().toString();
                String Email = email.getText().toString();
                String PhoneNo = phoneNo.getText().toString();
                String Location = location.getText().toString();
                String Workers = workers.getText().toString();
                String DateFrom = dateFrom.getText().toString();
                String DateTo = dateTo.getText().toString();
                String Password = password.getText().toString();

                Seller seller  = new Seller(Integer.parseInt(id),Name,Email,PhoneNo,Location,Workers,DateFrom,DateTo,Password);
                int state = sellerDbHandler.updateSingleSeller(seller);
                System.out.println(state);
                startActivity(new Intent(context,AdminHome.class));
            }
        });
    }
}
