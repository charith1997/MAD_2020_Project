package com.example.mad_2020_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
        context = this;

        itemDbHandler = new ItemDbHandler(context);
        listView = findViewById(R.id.staffHomeListView);
        addItem = findViewById(R.id.staffHomeAddButton);

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
    }
}
