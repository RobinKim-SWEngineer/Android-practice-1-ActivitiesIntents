package com.example.scrollingtext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String FEEDBACK_MESSAGE = "com.example.scrollingtext.feedbackMessage";
    private static final String LOG_TAG = SecondActivity.class.getSimpleName();
    public EditText editTextReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.d("LOG_TAG", "------");
        Log.d(LOG_TAG, "onCreate");

        TextView textViewComment = findViewById(R.id.textView_received_comment);
        editTextReply = findViewById(R.id.editText_reply_upon_comment);

        Intent intent = getIntent();

        String comment = intent.getStringExtra(MainActivity.COMMENT_MESSAGE);
        textViewComment.setText(comment);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    public void sendFeedback(View view) {

        Intent replyIntent = new Intent();
        String feedback = editTextReply.getText().toString();

        replyIntent.putExtra(FEEDBACK_MESSAGE, feedback);

        setResult(RESULT_OK, replyIntent);

        Log.d(LOG_TAG, "End SecondActivity");
        finish();
    }
}