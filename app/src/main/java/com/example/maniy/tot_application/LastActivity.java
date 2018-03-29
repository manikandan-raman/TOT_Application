package com.example.maniy.tot_application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LastActivity extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);

        text = findViewById(R.id.tq);
        text.setText("Thank Your for placing the Order, You will receive your foods very shorlty");
    }
}
