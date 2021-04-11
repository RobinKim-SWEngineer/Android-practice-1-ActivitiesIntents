package com.example.scrollingtext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String FEEDBACK_MESSAGE = "com.example.scrollingtext.feedbackMessage";
    public EditText editTextReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textViewComment = findViewById(R.id.textView_received_comment);
        editTextReply = findViewById(R.id.editText_reply_upon_comment);

        Intent intent = getIntent();

        String comment = intent.getStringExtra(MainActivity.COMMENT_MESSAGE);
        textViewComment.setText(comment);
    }

    public void sendFeedback(View view) {

        Intent replyIntent = new Intent();
        String feedback = editTextReply.getText().toString();

        replyIntent.putExtra(FEEDBACK_MESSAGE, feedback);

        setResult(RESULT_OK, replyIntent);

        finish();
    }
}