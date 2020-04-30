package com.example.mad_2020_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddItem extends AppCompatActivity {

    private EditText foodName,price,quantity,location;
    private Button addItem;
    private ItemDbHandler itemDbHandler;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        foodName = findViewById(R.id.addItemNameTxt);
        price = findViewById(R.id.addItemPriceTxt);
        quantity = findViewById(R.id.addItemQuantityTxt);
        location = findViewById(R.id.addItemLocationTxt);
        addItem = findViewById(R.id.addItemButton);
        context = this;

        itemDbHandler = new ItemDbHandler(context);

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FoodName = foodName.getText().toString();
                String Price = price.getText().toString();
                String Quantity = price.getText().toString();
                String Location = location.getText().toString();

                Item item = new Item(FoodName,Price,Quantity,Location);

                itemDbHandler.addFoodItem(item);

                Intent intent = new Intent(context,StaffHome.class);
                startActivity(intent);
            }
        });
    }
}
