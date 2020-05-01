package com.example.mad_2020_project;

<<<<<<< Updated upstream
import androidx.appcompat.app.AppCompatActivity;

=======
>>>>>>> Stashed changes
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

<<<<<<< Updated upstream
public class EditItem extends AppCompatActivity {

    private EditText foodName,price,quantity,location;
    private Button update;
    private ItemDbHandler itemDbHandler;
    Context context;

=======
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class EditItem extends AppCompatActivity {

    private Button button;
    private EditText name, price;
    private DbHandler dbhandler;
    Context context;


>>>>>>> Stashed changes
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

<<<<<<< Updated upstream
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
=======
        button=(Button) findViewById(R.id.btn5_madu);
        name=(EditText) findViewById(R.id.edtxt3_madu);
        price=(EditText) findViewById(R.id.edtxt4_madu);
        context=this;

        final ArrayList id=getIntent().getStringArrayListExtra("id");
        System.out.println(id);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Foods.class);
                startActivity(intent);

>>>>>>> Stashed changes
            }
        });
    }
}
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
