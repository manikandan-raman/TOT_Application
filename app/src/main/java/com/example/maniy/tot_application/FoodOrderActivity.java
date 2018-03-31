package com.example.maniy.tot_application;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.firebase.ui.auth.AuthUI;
import com.huxq17.swipecardsview.SwipeCardsView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class FoodOrderActivity extends AppCompatActivity {


    private ViewPager mViewPager;
    private CustomPagerAdapter mCustomPagerAdapter;
    private SwipeCardsView swipeCardsView;
    private List<Model> modelList = new ArrayList<>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_food_order);


            swipeCardsView = findViewById(R.id.SwipeCardsView);
            swipeCardsView.retainLastCard(true);
            swipeCardsView.enableSwipe(true);
            getData();

            mCustomPagerAdapter = new CustomPagerAdapter(this);

            mViewPager = (ViewPager) findViewById(R.id.pager);
            mViewPager.setAdapter(mCustomPagerAdapter);

            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new MyTimerTask(),2000,4000);



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

    public void getData() {
        modelList.add(new Model("Chicken Biryani",R.drawable.six));
        modelList.add(new Model("Mutton Biryani",R.drawable.seven));
        modelList.add(new Model("Fish Biryani",R.drawable.ten));
        modelList.add(new Model("Noodles",R.drawable.nine));
        modelList.add(new Model("Dosa",R.drawable.one));
        modelList.add(new Model("Idly",R.drawable.two));
        modelList.add(new Model("Pran Biryani",R.drawable.eight));
        modelList.add(new Model("Aapam",R.drawable.three));
        modelList.add(new Model("Poori",R.drawable.four_));
        modelList.add(new Model("Idiyappam",R.drawable.five_));

        CardAdapter cardAdapter = new CardAdapter(modelList,this);
        swipeCardsView.setAdapter(cardAdapter);
    }

    class CustomPagerAdapter extends PagerAdapter {

        Context mContext;
        LayoutInflater mLayoutInflater;

        int[] mResources = {
                R.drawable.first,
                R.drawable.second,
                R.drawable.third,
                R.drawable.four,
                R.drawable.five,

        };

        public CustomPagerAdapter(Context context) {
            mContext = context;
            mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return mResources.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((LinearLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);

            ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
            imageView.setImageResource(mResources[position]);

            container.addView(itemView);

            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout) object);
        }
    }

    class MyTimerTask extends TimerTask{


        @Override
        public void run() {
              FoodOrderActivity.this.runOnUiThread(new Runnable() {
                  @Override
                  public void run() {
                      if (mViewPager.getCurrentItem() == 0){
                          mViewPager.setCurrentItem(1);
                      } else if (mViewPager.getCurrentItem() == 1){
                          mViewPager.setCurrentItem(2);
                      } else if (mViewPager.getCurrentItem() == 2){
                          mViewPager.setCurrentItem(3);
                      } else if (mViewPager.getCurrentItem() == 3){
                          mViewPager.setCurrentItem(4);
                      } else if (mViewPager.getCurrentItem() == 4){
                          mViewPager.setCurrentItem(5);
                      } else if (mViewPager.getCurrentItem() == 5){
                          mViewPager.setCurrentItem(0);
                      }
                  }
              });
        }
    }

}
