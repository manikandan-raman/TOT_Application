package com.example.maniy.tot_application;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

    public void chat(View view){

        startActivity(new Intent(LastActivity.this,ChatActivity.class));
    }
}
