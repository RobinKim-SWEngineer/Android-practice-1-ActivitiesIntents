package com.example.scrollingtext;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String COMMENT_MESSAGE = "com.example.scrollingtext.commentMessage";

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private String textViewFeedbackHeadingVisibilityState;
    private String textViewFeedbackMessageState;

    private EditText editTextComment;
    private TextView textViewFeedbackHeading;
    private TextView textViewFeedback;

    private final int FEEDBACK_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(LOG_TAG, "------");
        Log.d(LOG_TAG, "onCreate");

        textViewFeedback = findViewById(R.id.textView_feedback_message);
        textViewFeedbackHeading = findViewById(R.id.textView_reply_heading);
        editTextComment = findViewById(R.id.editText_comment);

        /* Restoring saved state from last destroyed ( itself ) activity */
        if (savedInstanceState != null) {

            int previousVisibilityState = savedInstanceState.getInt(textViewFeedbackHeadingVisibilityState);
            String previousFeedbackMessageState = savedInstanceState.getString(textViewFeedbackMessageState);

            textViewFeedback.setVisibility(previousVisibilityState);
            textViewFeedback.setText(previousFeedbackMessageState);

            textViewFeedbackHeading.setVisibility(previousVisibilityState);
        }
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

    /**
     *  System calls this method between onPause() and onStop().
     *  Use this method in case you need to save data when Activity is destroyed and recreated.
     */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        if (textViewFeedbackHeading.getVisibility() == View.VISIBLE) {
            /**
             *  Saving Activity instance states to restore them upon recreation.
             *  Their instance state is available in "savedInstanceState" as a Bundle object.
             */
            outState.putInt(textViewFeedbackHeadingVisibilityState, View.VISIBLE);
            outState.putString(textViewFeedbackMessageState, textViewFeedback.getText().toString());
        }
    }
}