package com.example.mad_2020_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditFeedback extends AppCompatActivity {

    private EditText name,email,comment;
    private Button update;
    private FeedbackHandler feedbackHandler;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_feedback);

        context = this;
        feedbackHandler = new FeedbackHandler(context);

        name = findViewById(R.id.editfeebackNameTxt);
        email = findViewById(R.id.editfeebackEmailTxt);
        comment = findViewById(R.id.editfeebackCommentTxt);
        update = findViewById(R.id.EditFeedback);

        final  String id = getIntent().getStringExtra("id");
        Feedback feedback1 = feedbackHandler.getSingleFeedback(Integer.parseInt(id));

        name.setText(feedback1.getName());
        email.setText(feedback1.getEmail());
        comment.setText(feedback1.getComment());

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = name.getText().toString();
                String Email = email.getText().toString();
                String Comment = comment.getText().toString();

                Feedback feedback  = new Feedback(Integer.parseInt(id),Name,Email,Comment);
                int state = feedbackHandler.updateSingleFeedback(feedback);
                System.out.println(state);
                startActivity(new Intent(context,ViewFeedback.class));
            }
        });
    }
}
