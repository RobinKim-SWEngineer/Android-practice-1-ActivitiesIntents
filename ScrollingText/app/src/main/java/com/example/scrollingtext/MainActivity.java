package com.example.scrollingtext;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String COMMENT_MESSAGE = "com.example.scrollingtext.commentMessage";
    private EditText editTextComment;
    private TextView textViewFeedbackHeading;
    private TextView textViewFeedback;
    private final int FEEDBACK_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewFeedback = findViewById(R.id.textView_feedback_message);
        textViewFeedbackHeading = findViewById(R.id.textView_reply_heading);
        editTextComment = findViewById(R.id.editText_comment);
    }

    public void sendComment(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        String commentMessage = editTextComment.getText().toString();

        intent.putExtra(COMMENT_MESSAGE, commentMessage);
        editTextComment.getText().clear();

        startActivityForResult(intent, FEEDBACK_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == FEEDBACK_REQUEST)

            if (resultCode == RESULT_OK) {

                textViewFeedback.setVisibility(View.VISIBLE);

                String feedback = data.getStringExtra(SecondActivity.FEEDBACK_MESSAGE);

                textViewFeedback.setText(feedback);
                textViewFeedbackHeading.setVisibility(View.VISIBLE);

            }
    }
}