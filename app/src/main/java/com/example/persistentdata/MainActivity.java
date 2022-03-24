package com.example.persistentdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getSimpleName();
    private int mCounter = 0;
    private TextView textView;
    private final String KEY = "key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);
        mCounter = getPreferences(MODE_PRIVATE).getInt(KEY, 0);
        updateDate();


        findViewById(R.id.button).setOnClickListener(view->{
            mCounter++;
            updateDate();
        });
    }

    private void updateDate() {
        textView.setText(String.valueOf(mCounter));
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences settings = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(KEY, mCounter);
        editor.apply();
    }
}