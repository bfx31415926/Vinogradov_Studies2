package com.example.study26;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button btnTime = (Button) findViewById(R.id.btnTime);
        Button btnDate = (Button) findViewById(R.id.btnDate);

        btnTime.setOnClickListener(this);
        btnDate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        if(v.getId() == R.id.btnTime) {
            intent = new Intent("ru.startandroid.intent.action.showtime");
            startActivity(intent);
        } else{ //v.getId() == R.id.btnDate
                intent = new Intent("ru.startandroid.intent.action.showdate");
                startActivity(intent);
        }
    }
}