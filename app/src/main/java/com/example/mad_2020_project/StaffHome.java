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

public class StaffHome extends AppCompatActivity {

    private ListView listView;
    private Button addItem;
    Context context;
    private ItemDbHandler itemDbHandler;
    private List<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_home);
        itemDbHandler = new ItemDbHandler(context);
        addItem = findViewById(R.id.staffHomeAddButton);
        listView = findViewById(R.id.staffHomeListView);

        items = new ArrayList<>();

        items = itemDbHandler.getAllItems();

        ItemAdapter itemAdapter = new ItemAdapter(context,R.layout.single_item_view,items);

        listView.setAdapter(itemAdapter);

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,AddItem.class));
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final Item item = items.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(item.getName());
                builder.setMessage(item.getPrice());


                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        itemDbHandler.deleteItem(item.getId());
                        startActivity(new Intent(context,StaffHome.class ));
                    }
                });


                builder.setNeutralButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context,EditItem.class);
                        intent.putExtra("id",String.valueOf(item.getId()));
                        startActivity(intent);
                    }
                });

                builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(context,StaffHome.class));
                    }
                });

                builder.show();
            }
        });
    }
}
