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

public class SellerAdapter extends ArrayAdapter<Seller> {

    private Context context;
    private int resource;
    private List<Seller> sellers;

    SellerAdapter(Context context, int resource, List<Seller> sellers){
        super(context,resource,sellers);
        this.context = context;
        this.resource = resource;
        this.sellers = sellers;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView name = row.findViewById(R.id.single1);
        TextView email = row.findViewById(R.id.single2);
        TextView phoneNo = row.findViewById(R.id.single3);
        TextView location = row.findViewById(R.id.single4);
        TextView workers = row.findViewById(R.id.single5);
        TextView fromDate = row.findViewById(R.id.single6);
        TextView toDate = row.findViewById(R.id.single7);
        TextView password = row.findViewById(R.id.single8);

        Seller seller = sellers.get(position);
        name.setText(seller.getName());
        email.setText(seller.getEmail());
        phoneNo.setText(seller.getPhoneNo());
        location.setText(seller.getLocation());
        workers.setText(seller.getWorkers());
        fromDate.setText(seller.getFromDate());
        toDate.setText(seller.getToDate());
        password.setText(seller.getPassword());

        return row;
    }
}
