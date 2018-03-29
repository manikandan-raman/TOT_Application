package com.example.maniy.tot_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.nio.file.attribute.DosFileAttributes;
import java.util.IdentityHashMap;

public class FoodConfirmActivity extends AppCompatActivity {

    TextView food1,food2,food3,price1,price2,price3,amount1,amount2,amount3,total;
    String Food1,Food2,Food3,Price1,Price2,Price3,passingTotal;
    Button makeChanges,orderConfirm;
    private FirebaseDatabase mFirebaseDatabse;
    private DatabaseReference mDatabaseReference;
    private int Mutton_Biryani=245,Chicken_Biryani=170,Idly=30,Dosa=35,Idiyappam=40,Aapam=40,Poori=45,Fish_Biryani=120,Pran_Biryani=110,Noodles=90;
    private int price_of_each,price_of_each2,price_of_each3,price_of_total;
    private int quantity1,quantity2,quantity3;

    final static String mutton_biryani="Mutton Biryani",chicken_biryani="Chicken Biryani",fish_biryani="Fish Biryani",pran_biryani="Pran Biryani",noodles="Noodles",
            idly="Idly",dosa="Dosa",idiyappam="Idiyappam",poori="Poori",aapam="Aapam";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_confirm);

        amount1 = findViewById(R.id.Amount1);
        amount2 = findViewById(R.id.Amount2);
        amount3 = findViewById(R.id.Amount3);
        total = findViewById(R.id.total);
        food1 = findViewById(R.id.food1);
        food2 = findViewById(R.id.food2);
        food3 = findViewById(R.id.food3);
        price1 = findViewById(R.id.spin1);
        price2 = findViewById(R.id.spin2);
        price3 = findViewById(R.id.spin3);


        makeChanges = findViewById(R.id.make_changes);
        makeChanges.setText("<<Make Changes");
        orderConfirm = findViewById(R.id.confirm_food);
        orderConfirm.setText("Confirm Order>>");
        mFirebaseDatabse = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabse.getReference().child("FoodInfo");


        makeChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FoodConfirmActivity.this, FoodEnterActivity.class));
            }
        });

        Bundle bundle = getIntent().getExtras();


        Food1 = bundle.getString("food1");
        Food2 = bundle.getString("food2");
        Food3 = bundle.getString("food3");

        Price1 = bundle.getString("spin1");
        Price2 = bundle.getString("spin2");
        Price3 = bundle.getString("spin3");

        quantity1 = Integer.parseInt(Price1);
        quantity2 = Integer.parseInt(Price2);
        quantity3 = Integer.parseInt(Price3);




        switch (Food1){

            case mutton_biryani:
                price_of_each = Mutton_Biryani * quantity1;
                amount1.setText("₹ "+String.valueOf(price_of_each));
                break;

            case  chicken_biryani:
                price_of_each = Chicken_Biryani * quantity1;
                amount1.setText("₹ "+String.valueOf(price_of_each));
                break;

            case fish_biryani:
                price_of_each = Fish_Biryani * quantity1;
                amount1.setText("₹ "+String.valueOf(price_of_each));
                break;

            case pran_biryani:
                price_of_each = Pran_Biryani * quantity1;
                amount1.setText("₹ "+String.valueOf(price_of_each));
                break;

            case noodles:
                price_of_each = Noodles * quantity1;
                amount1.setText("₹ "+String.valueOf(price_of_each));
                break;

            case idiyappam:
                price_of_each = Idiyappam * quantity1;
                amount1.setText("₹ "+String.valueOf(price_of_each));
                break;

            case idly:
                price_of_each = Idly * quantity1;
                amount1.setText("₹ "+String.valueOf(price_of_each));
                break;

            case dosa:
                price_of_each = Dosa * quantity1;
                amount1.setText("₹ "+String.valueOf(price_of_each));
                break;

            case poori:
                price_of_each = Poori * quantity1;
                amount1.setText("₹ "+String.valueOf(price_of_each));
                break;

            case aapam:
                price_of_each = Aapam * quantity1;
                amount1.setText("₹ "+String.valueOf(price_of_each));
                break;
        }

        switch (Food2){

            case mutton_biryani:
                price_of_each2 = Mutton_Biryani * quantity2;
                amount2.setText("₹ "+String.valueOf(price_of_each2));
                break;

            case  chicken_biryani:
                price_of_each2 = Chicken_Biryani * quantity2;
                amount2.setText("₹ "+String.valueOf(price_of_each2));
                break;

            case fish_biryani:
                price_of_each2 = Fish_Biryani * quantity2;
                amount2.setText("₹ "+String.valueOf(price_of_each2));
                break;

            case pran_biryani:
                price_of_each2 = Pran_Biryani * quantity2;
                amount2.setText("₹ "+String.valueOf(price_of_each2));
                break;

            case noodles:
                price_of_each2 = Noodles * quantity2;
                amount2.setText("₹ "+String.valueOf(price_of_each2));
                break;

            case idiyappam:
                price_of_each2 = Idiyappam * quantity2;
                amount2.setText("₹ "+String.valueOf(price_of_each2));
                break;

            case idly:
                price_of_each = Idly * quantity2;
                amount2.setText("₹ "+String.valueOf(price_of_each2));
                break;

            case dosa:
                price_of_each2 = Dosa * quantity2;
                amount2.setText("₹ "+String.valueOf(price_of_each2));
                break;

            case poori:
                price_of_each2 = Poori * quantity2;
                amount2.setText("₹ "+String.valueOf(price_of_each2));
                break;

            case aapam:
                price_of_each2 = Aapam * quantity2;
                amount2.setText("₹ "+String.valueOf(price_of_each2));
                break;
        }

        switch (Food3){

            case mutton_biryani:
                price_of_each3 = Mutton_Biryani * quantity3;
                amount3.setText("₹ "+String.valueOf(price_of_each3));
                break;

            case  chicken_biryani:
                price_of_each3 = Chicken_Biryani * quantity3;
                amount3.setText("₹ "+String.valueOf(price_of_each3));
                break;

            case fish_biryani:
                price_of_each3 = Fish_Biryani * quantity3;
                amount3.setText("₹ "+String.valueOf(price_of_each3));
                break;

            case pran_biryani:
                price_of_each3 = Pran_Biryani * quantity3;
                amount3.setText("₹ "+String.valueOf(price_of_each3));
                break;

            case noodles:
                price_of_each3 = Noodles * quantity3;
                amount3.setText("₹ "+String.valueOf(price_of_each3));
                break;

            case idiyappam:
                price_of_each3 = Idiyappam * quantity3;
                amount3.setText("₹ "+String.valueOf(price_of_each3));
                break;

            case idly:
                price_of_each3 = Idly * quantity3;
                amount3.setText("₹ "+String.valueOf(price_of_each3));
                break;

            case dosa:
                price_of_each3 = Dosa * quantity3;
                amount3.setText("₹ "+String.valueOf(price_of_each3));
                break;

            case poori:
                price_of_each3 = Poori * quantity3;
                amount3.setText("₹ "+String.valueOf(price_of_each3));
                break;

            case aapam:
                price_of_each3 = Aapam * quantity3;
                amount3.setText("₹ "+String.valueOf(price_of_each3));
                break;
        }





        price_of_total = price_of_each + price_of_each2 + price_of_each3;
        passingTotal = String.valueOf(price_of_total);
        food1.setText(Food1);
        food2.setText(Food2);
        food3.setText(Food3);
        price1.setText(Price1);
        price2.setText(Price2);
        price3.setText(Price3);
        total.setText("Total: ₹ "+String.valueOf(price_of_total));


        orderConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                   addFood();
                   Intent i = new Intent(FoodConfirmActivity.this,PaymentActivity.class);
                   i.putExtra("Total_Price",passingTotal);
                   startActivity(i);
            }
        });

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
                startActivity(new Intent(FoodConfirmActivity.this,LocationActivity.class));
                break;



            case R.id.Chat_menu:
                startActivity(new Intent(FoodConfirmActivity.this,ChatActivity.class));
                break;

            case R.id.sign_out_menu:
                //Sign_out Operation
                AuthUI.getInstance().signOut(this);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }




            public void addFood() {


                String id = mDatabaseReference.push().getKey();

                FoodInfo foodInfo = new FoodInfo(id, Food1, Food2, Food3, Price1, Price2, Price3);

                mDatabaseReference.child(id).setValue(foodInfo);


            }





}
