package com.example.mad_2020_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ToDoAdapter<row> extends ArrayAdapter<ToDo> {
    private Context context;
    private int resources;
    List<ToDo> todos;

    ToDoAdapter(Context context, int resource, List<ToDo> toDos){
        super(context,resource,toDos);
        this.context = context;
        this.resources = resource;
        this.todos = toDos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resources,parent,false);

        TextView name = row.findViewById(R.id.name);
        TextView price = row.findViewById(R.id.price);

        ToDo todo = todos.get(position);
        name.setText(todo.getName());
        price.setText(todo.getPrice());
        return row;
  }
}
