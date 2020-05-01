package com.example.mad_2020_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class OwnerHome extends AppCompatActivity {
   FloatingActionButton flbtn1_madu;
    FloatingActionButton flbtn3_madu;
    FloatingActionButton flbtn4_madu;
    FloatingActionButton flbtn5_madu;
    FloatingActionButton flbtn6_madu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_home);

        flbtn1_madu = findViewById(R.id.flbtn1_madu);
        flbtn3_madu = findViewById(R.id.flbtn3_madu);
        flbtn4_madu = findViewById(R.id.flbtn4_madu);
        flbtn5_madu = findViewById(R.id.flbtn5_madu);
        flbtn6_madu = findViewById(R.id.flbtn6_madu);

        flbtn1_madu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),AddActivity.class);
                startActivity(intent1);

            }
        });

        flbtn3_madu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(),EditItem.class);
                startActivity(intent3);

            }
        });
        flbtn4_madu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(getApplicationContext(),DeleteItem.class);
                startActivity(intent4);

            }
        });
        flbtn5_madu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Foods.class);
                startActivity(intent);

            }
        });
        flbtn6_madu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent6);
            }
        });

    }
}


