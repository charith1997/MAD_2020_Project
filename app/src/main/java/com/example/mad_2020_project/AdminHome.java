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

    private Button add;
    private ListView listView;
    Context context;
    private SellerDbHandler sellerDbHandler;
    private List<Seller> sellers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        context = this;

        sellerDbHandler = new SellerDbHandler(context);
        add = findViewById(R.id.AddSeller);
        listView = findViewById(R.id.sellerList);

        sellers = new ArrayList<>();

        sellers = sellerDbHandler.getAllSellers();

        SellerAdapter sellerAdapter = new SellerAdapter(context,R.layout.single_seller_view,sellers);

        listView.setAdapter(sellerAdapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,AddSeller.class));
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final Seller seller = sellers.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(seller.getName());
                builder.setMessage(seller.getLocation());


                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sellerDbHandler.deleteSeller(seller.getId());
                        startActivity(new Intent(context,AdminHome.class ));
                    }
                });


                builder.setNeutralButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context,EditSeller.class);
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
