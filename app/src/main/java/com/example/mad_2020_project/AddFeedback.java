package com.example.mad_2020_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddFeedback extends AppCompatActivity {

    private EditText Name,Email,Comment;
    private Button AddFeedback;
    private FeedbackHandler feedbackHandler;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_feedback);

        Name = findViewById(R.id.fedback2);
        Email = findViewById(R.id.fedback4);
        Comment = findViewById(R.id.fedback6);
        AddFeedback = findViewById(R.id.AddFeedbackButton);

        context = this;
        feedbackHandler = new FeedbackHandler(context);

        AddFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = Name.getText().toString();
                String email = Email.getText().toString();
                String comment = Comment.getText().toString();

                Feedback feedback = new Feedback(name,email,comment);
                feedbackHandler.addFeedback(feedback);

                startActivity(new Intent(context,ViewFeedback.class));
            }
        });
    }
}
