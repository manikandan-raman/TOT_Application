package com.example.maniy.tot_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.firebase.ui.auth.AuthUI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FoodOrderActivity extends AppCompatActivity {



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_food_order);


            ExpandableListView expandableListView;
            ExpandableListAdapter expandableListAdapter;
            List<String> expandableListTitle;
            HashMap<String, List<String>> expandableListDetail;


                expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
                expandableListDetail = ExpandableListDataPump.getData();
                expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
                expandableListAdapter = new CustomExpandableListAdapter(this, expandableListTitle, expandableListDetail);
                expandableListView.setAdapter(expandableListAdapter);

        }

        public void FoodChoose(View view){

            Intent i = new Intent(FoodOrderActivity.this,FoodEnterActivity.class);
            startActivity(i);
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
                startActivity(new Intent(FoodOrderActivity.this,LocationActivity.class));
                break;



            case R.id.Chat_menu:
                startActivity(new Intent(FoodOrderActivity.this,ChatActivity.class));
                break;

            case R.id.sign_out_menu:
                //Sign_out Operation
                AuthUI.getInstance().signOut(this);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

}
