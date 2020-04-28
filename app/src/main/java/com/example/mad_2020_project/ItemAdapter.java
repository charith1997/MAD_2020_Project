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

public class ItemAdapter extends ArrayAdapter<Item> {

    private Context context;
    private int resource;
    private List<Item> items;

    ItemAdapter(Context context, int resource, List<Item> items){
        super(context,resource,items);
        this.context = context;
        this.resource = resource;
        this.items = items;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView foodName = row.findViewById(R.id.singleViewNameTxt);
        TextView price = row.findViewById(R.id.singleViewPriceTxt);
        TextView quantity = row.findViewById(R.id.singleViewQuantityTxt);
        TextView location = row.findViewById(R.id.singleViewLocationTxt);

        Item item = items.get(position);
        foodName.setText(item.getName());
        price.setText(item.getPrice());
        quantity.setText(item.getQuantity());
        location.setText(item.getLocation());

        return row;
    }
}
