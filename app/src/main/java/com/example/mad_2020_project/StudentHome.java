package com.example.mad_2020_project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class StudentHome extends AppCompatActivity {

    private ListView listView;
    private Button feedback;

    String foodName[] = {"Chicken Rice & Curry","Fish Rice & Curry","Prawn Rice & Curry","Chicken Kottu","Biriyani"};
    String price[] = {"Rs 200.00","Rs 150.00","Rs 220.00","Rs 200.00","Rs 300.00"};
    String location[] = {"Basement","Engineering","1st Flow","New Building","Basement"};
    int img[] = {R.drawable.chicken,R.drawable.fish,R.drawable.prawn,R.drawable.kottu,R.drawable.biriyani};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);

        listView = findViewById(R.id.studentHomeListview);
        feedback = findViewById(R.id.viewfeedbackButton);
        CustomAdapter adapter = new CustomAdapter(this,foodName,img,price,location);
        listView.setAdapter(adapter);

        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentHome.this,ViewFeedback.class));
            }
        });
    }
}

class CustomAdapter extends ArrayAdapter<String>{
    Context context;
    int[] images;
    String[] foodName;
    String[] price;
    String [] location;

    CustomAdapter(Context context,String[] foodName,int images[],String[] price,String[] location){
        super(context,R.layout.singlefooditem,R.id.foodItemName,foodName);
        this.context = context;
        this.images = images;
        this.foodName = foodName;
        this.price = price;
        this.location = location;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.singlefooditem,parent,false);

        ImageView imageView = row.findViewById(R.id.foodItemImage);
        TextView FoodName = row.findViewById(R.id.foodItemName);
        TextView Price = row.findViewById(R.id.foodItemPrice);
        TextView Location = row.findViewById(R.id.foodItemLocation);

        imageView.setImageResource(images[position]);
        FoodName.setText(foodName[position]);
        Price.setText(price[position]);
        Location.setText(location[position]);

        return row;
    }
}
