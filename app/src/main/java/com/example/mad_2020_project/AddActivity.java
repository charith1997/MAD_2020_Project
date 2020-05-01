package com.example.mad_2020_project;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {
    private Button save;
    private EditText name,price;
    private DbHandler dbhandler;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        save=(Button) findViewById(R.id.btn1_madu);

        name=(EditText) findViewById(R.id.edtxt1_madu);
        price=(EditText) findViewById(R.id.edtxt2_madu);
        context=this;

        dbhandler=new DbHandler(context);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = name.getText().toString();
                String Price = price.getText().toString();
                long Started = System.currentTimeMillis();

                ToDo todo = new ToDo(Name,Price,Started,0);
                dbhandler.additems(todo);

                startActivity(new Intent(context,Foods.class));

            }
        });
    }
}
