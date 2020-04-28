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

        TextView username = row.findViewById(R.id.svUsernametxt);
        TextView email = row.findViewById(R.id.svEmailtxt);
        TextView phoneNo = row.findViewById(R.id.svPhoneNotxt);
        TextView location = row.findViewById(R.id.svLocationtxt);
        TextView noWorkers = row.findViewById(R.id.svNoWorkerstxt);
        TextView dateFrom = row.findViewById(R.id.svDateFromtxt);
        TextView dateTo = row.findViewById(R.id.svDateTotxt);
        TextView password = row.findViewById(R.id.svPasswordtxt);

        Seller seller = sellers.get(position);
        username.setText(seller.getUsername());
        email.setText(seller.getEmail());
        phoneNo.setText(seller.getMobileNo());
        location.setText(seller.getVenue());
        noWorkers.setText(seller.getMobileNo());
        dateFrom.setText(seller.getDateFrom());
        dateTo.setText(seller.getDateTo());
        password.setText(seller.getPswd());


        return row;
    }
}
