package com.example.maniy.tot_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        Thread splash=new Thread(){
            public void run(){

                try{
                    sleep(3*1000);
                    Intent splash_intent=new Intent(getApplicationContext(),UserDetailsActivity.class);
                    startActivity(splash_intent);
                    finish();
                }catch (Exception e){

                }
            }


        };
        splash.start();

    }
}
