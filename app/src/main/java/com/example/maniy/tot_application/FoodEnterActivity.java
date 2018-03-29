package com.example.maniy.tot_application;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class FoodEnterActivity extends AppCompatActivity  {


    TextInputLayout ACT1,ACT2,ACT3;
    AutoCompleteTextView act1,act2,act3;
    Spinner s1,s2,s3;
    String food1,food2,food3,spin1,spin2,spin3;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_enter);


        submit = findViewById(R.id.food_submit);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                addFood();
                Intent i = new Intent(FoodEnterActivity.this,FoodConfirmActivity.class);
                i.putExtra("food1",food1);
                i.putExtra("food2",food2);
                i.putExtra("food3",food3);
                i.putExtra("spin1",spin1);
                i.putExtra("spin2",spin2);
                i.putExtra("spin3",spin3);
                startActivity(i);
            }
        });
        String[] foods = {"Idly","Dosa","Idiyappam","Aapam","Poori","Chicken Biryani","Mutton Biryani","Fish Biryani","Pran Biryani","Noodles"};

        ArrayList<String> quantity = new ArrayList<>();
        quantity.add("1");
        quantity.add("2");
        quantity.add("3");



        s1 = findViewById(R.id.s1);
        s2=findViewById(R.id.s2);
        s3=findViewById(R.id.s3);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, foods);

        act1 = findViewById(R.id.act1);
        act1.setThreshold(1);
        act1.setAdapter(adapter);

        act2 = findViewById(R.id.act2);
        act2.setThreshold(1);
        act2.setAdapter(adapter);

        act3 = findViewById(R.id.act3);
        act3.setThreshold(1);
        act3.setAdapter(adapter);


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, quantity);


        // attaching data adapter to spinner
        s1.setAdapter(dataAdapter);
        s2.setAdapter(dataAdapter);
        s3.setAdapter(dataAdapter);



    }

    //menu options
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    //menu option executions using switch
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.location_share_menu:
                startActivity(new Intent(FoodEnterActivity.this,LocationActivity.class));
                break;



            case R.id.Chat_menu:
                startActivity(new Intent(FoodEnterActivity.this,ChatActivity.class));
                break;

            case R.id.sign_out_menu:
                //Sign_out Operation
                AuthUI.getInstance().signOut(this);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }


    public void addFood(){





             food1 = act1.getText().toString();
             food2 = act2.getText().toString();
            food3 = act3.getText().toString();

             spin1 = s1.getSelectedItem().toString().trim();
             spin2 = s2.getSelectedItem().toString().trim();
             spin3 = s3.getSelectedItem().toString().trim();



        }
    }


