package com.example.mad_2020_project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AdminHome extends AppCompatActivity {

    private ListView listView;
    private Button addUser;
    Context context;
    private DbHandler dbHandler;
    private List<Seller> sellers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        context = this;

        dbHandler = new DbHandler(context);
        listView = findViewById(R.id.ahlistHome);
        addUser = findViewById(R.id.ahButton);


        sellers = new ArrayList<>();
        sellers = dbHandler.getAllSellers();

        SellerAdapter adapter = new SellerAdapter(context,R.layout.single_view,sellers);

        listView.setAdapter(adapter);

        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,AddUser.class));
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final Seller seller = sellers.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(seller.getUsername());
                builder.setMessage(seller.getVenue());


                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dbHandler.deleteUser(seller.getId());
                        startActivity(new Intent(context,AdminHome.class ));
                    }
                });


                builder.setNeutralButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context,EditUser.class);
                        intent.putExtra("id",String.valueOf(seller.getId()));
                        startActivity(intent);
                    }
                });

                builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(context,AdminHome.class));
                    }
                });

                builder.show();
            }
        });

    }
}
