package com.example.mad_2020_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditItem extends AppCompatActivity {

    private EditText foodName,price,quantity,location;
    private Button update;
    private ItemDbHandler itemDbHandler;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        context = this;
        itemDbHandler = new ItemDbHandler(context);

        foodName = findViewById(R.id.EditItem2);
        price = findViewById(R.id.EditItem4);
        quantity = findViewById(R.id.EditItem6);
        location = findViewById(R.id.EditItem8);
        update = findViewById(R.id.EditItemButton);

        final  String id = getIntent().getStringExtra("id");
        Item item1 = itemDbHandler.getSingleItem(Integer.parseInt(id));

        foodName.setText(item1.getName());
        price.setText(item1.getPrice());
        quantity.setText(item1.getQuantity());
        location.setText(item1.getLocation());

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FoodName = foodName.getText().toString();
                String Price = price.getText().toString();
                String Quantity = quantity.getText().toString();
                String Location = location.getText().toString();

                Item item  = new Item(Integer.parseInt(id),FoodName,Price,Quantity,Location);
                int state = itemDbHandler.updateSingleItem(item);
                System.out.println(state);
                startActivity(new Intent(context,StaffHome.class));
            }
        });
    }
}
