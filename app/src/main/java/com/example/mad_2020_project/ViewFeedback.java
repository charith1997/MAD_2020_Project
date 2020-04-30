package com.example.mad_2020_project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ViewFeedback extends AppCompatActivity {

    private Button add;
    private ListView listView;
    Context context;
    private FeedbackHandler feedbackHandler;
    private List<Feedback> feedbacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_feedback);
        context = this;

        feedbackHandler = new FeedbackHandler(context);
        add = findViewById(R.id.FeedbackAdd);
        listView = findViewById(R.id.feedbackList);

        feedbacks = new ArrayList<>();

        feedbacks = feedbackHandler.getAllFeedbacks();

        FeedbackAdapter feedbackAdapter = new FeedbackAdapter(context,R.layout.single_feedback,feedbacks);

        listView.setAdapter(feedbackAdapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,AddFeedback.class));
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final Feedback feedback = feedbacks.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(feedback.getName());
                builder.setMessage(feedback.getComment());


                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        feedbackHandler.deleteFeedback(feedback.getId());
                        startActivity(new Intent(context,ViewFeedback.class ));
                    }
                });


                builder.setNeutralButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context,EditFeedback.class);
                        intent.putExtra("id",String.valueOf(feedback.getId()));
                        startActivity(intent);
                    }
                });

                builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(context,ViewFeedback.class));
                    }
                });

                builder.show();
            }
        });
    }
}
