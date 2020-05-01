package com.example.mad_2020_project;
<<<<<<< Updated upstream:app/src/main/java/com/example/mad_2020_project/AdminHome.java

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

=======
>>>>>>> Stashed changes:app/src/main/java/com/example/mad_2020_project/Foods.java
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


<<<<<<< Updated upstream:app/src/main/java/com/example/mad_2020_project/AdminHome.java
    private Button add;
    private ListView listView;
    Context context;
    private SellerDbHandler sellerDbHandler;
    private List<Seller> sellers;
=======
public class Foods extends AppCompatActivity {
    private ListView listViwe;
    private TextView count;
    Context context;
    private List<ToDo> toDos;
    private DbHandler dbHandler;
>>>>>>> Stashed changes:app/src/main/java/com/example/mad_2020_project/Foods.java

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods);
        context = this;

<<<<<<< Updated upstream:app/src/main/java/com/example/mad_2020_project/AdminHome.java
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
=======
        dbHandler = new DbHandler(context);
        listViwe = findViewById(R.id.madulist);
        count = findViewById(R.id.count);
        toDos = new ArrayList<>();

        toDos = dbHandler.getAllToDos();

        ToDoAdapter adapter = new ToDoAdapter(context,R.layout.singletodo,toDos);
        listViwe.setAdapter(adapter);


        int countTodo = dbHandler.count();
        count.setText("You have "+count+" toDos");

        listViwe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
>>>>>>> Stashed changes:app/src/main/java/com/example/mad_2020_project/Foods.java
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final ToDo todo =toDos.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
<<<<<<< Updated upstream:app/src/main/java/com/example/mad_2020_project/AdminHome.java
                builder.setTitle(seller.getName());
                builder.setMessage(seller.getLocation());


                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sellerDbHandler.deleteSeller(seller.getId());
                        startActivity(new Intent(context,AdminHome.class ));
=======
                builder.setTitle(todo.getName());
                builder.setMessage( todo.getPrice());
                builder.setPositiveButton("Finished", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivities(new Intent[]{new Intent(context, Foods.class)});

>>>>>>> Stashed changes:app/src/main/java/com/example/mad_2020_project/Foods.java
                    }
                });
                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dbHandler.deleteitem(todo.getId());
                        startActivities(new Intent[]{new Intent(context,DeleteItem.class)});


                    }
                });
                builder.setNeutralButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
<<<<<<< Updated upstream:app/src/main/java/com/example/mad_2020_project/AdminHome.java
                        Intent intent = new Intent(context,EditSeller.class);
                        intent.putExtra("id",String.valueOf(seller.getId()));
=======
                        Intent intent = new Intent(context,EditItem.class);
                        intent.putExtra("id",String.valueOf(todo.getId()));
>>>>>>> Stashed changes:app/src/main/java/com/example/mad_2020_project/Foods.java
                        startActivity(intent);

                    }
                });
                builder.show();
            }
        });
    }
}
