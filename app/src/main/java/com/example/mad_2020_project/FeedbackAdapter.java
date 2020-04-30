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

public class FeedbackAdapter extends ArrayAdapter<Feedback> {

    private Context context;
    private int resource;
    private List<Feedback> feedbacks;

    FeedbackAdapter(Context context, int resource, List<Feedback> feedbacks){
        super(context,resource,feedbacks);
        this.context = context;
        this.resource = resource;
        this.feedbacks = feedbacks;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView name = row.findViewById(R.id.feedback2);
        TextView email = row.findViewById(R.id.feedback4);
        TextView comment = row.findViewById(R.id.feedback6);


        Feedback feedback = feedbacks.get(position);
        name.setText(feedback.getName());
        email.setText(feedback.getEmail());
        comment.setText(feedback.getComment());

        return row;
    }
}
