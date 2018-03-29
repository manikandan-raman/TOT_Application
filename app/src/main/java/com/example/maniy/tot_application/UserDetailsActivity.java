package com.example.maniy.tot_application;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.CpuUsageInfo;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.data.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDetailsActivity extends AppCompatActivity {

    //Declared the necessary widgets
    TextInputLayout customerNameTIP,customerPhoneTIP,trainNameTIP,trainNumberTip,coachNameTIP,seatNumberTIP;
    EditText customerNameEdit,customerPhone,trainNameEdit,trainNumberEdit,coachNameEdit,seatNumberEdit;
    Spinner destinationStation;
    Button submit;
    ProgressDialog progressDialog;
    List<CustomerInfo> customerInfos;

    //Firebase Initialization
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private FirebaseDatabase mFirebaseDatabse;
    private DatabaseReference mDatabaseReference;

    //RequestCode
    private static final int RC_SIGN_IN = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);



        //setting ID to the views
        customerNameTIP = findViewById(R.id.nameTIP);
        customerPhoneTIP = findViewById(R.id.phoneTIP);
        trainNameTIP = findViewById(R.id.tnameTIP);
        trainNumberTip = findViewById(R.id.tnoTIP);
        coachNameTIP = findViewById(R.id.coachTIP);
        seatNumberTIP = findViewById(R.id.seatTIP);
        customerNameEdit = findViewById(R.id.CustomerNameEditText);
        customerPhone = findViewById(R.id.CustomerPhoneEditText);
        trainNameEdit = findViewById(R.id.TrainNameEditText);
        trainNumberEdit = findViewById(R.id.Train_No_EditText);
        coachNameEdit = findViewById(R.id.CoachNameEditText);
        seatNumberEdit = findViewById(R.id.SeatNumbersEditText);
        destinationStation = findViewById(R.id.spinner);
        submit = findViewById(R.id.submit);

        //list to store CustomerInfos
        customerInfos = new ArrayList<>();

        //Firebase Instance
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseDatabse = FirebaseDatabase.getInstance();


        //Getting reference to the root of the database
        mDatabaseReference = mFirebaseDatabse.getReference().child("CustomerInfo");


        //When button clicked
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog = new ProgressDialog(UserDetailsActivity.this);
                progressDialog.setMessage("Processing...");
                progressDialog.setProgressStyle(progressDialog.STYLE_SPINNER);
                progressDialog.show();

                addCustomer();
                progressDialog.dismiss();

                startActivity(new Intent(UserDetailsActivity.this,FoodOrderActivity.class));
            }
        });


        //AuthStateListener to listen whether the user is signed in or out
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                // to get the current signed in user
                FirebaseUser user = mFirebaseAuth.getCurrentUser();
                if (user != null){
                    // signed in
                    Toast.makeText(getApplicationContext(),"Signed in ",Toast.LENGTH_SHORT).show();
                }else{
                    // signed out, so need to display Sign in options
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)
                                    .setAvailableProviders(Arrays.asList(
                                            new AuthUI.IdpConfig.EmailBuilder().build(),
                                            new AuthUI.IdpConfig.PhoneBuilder().build(),
                                            new AuthUI.IdpConfig.GoogleBuilder().build()))
                                    .build(),
                            RC_SIGN_IN);
                }
            }
        };

    }


    public void addCustomer(){

        String CustomerName = customerNameEdit.getText().toString().trim();
        String CustomerPhone = customerPhone.getText().toString().trim();
        String TrainName = trainNameEdit.getText().toString().trim();
        String TrainNumber = trainNumberEdit.getText().toString().trim();
        String CoachName = coachNameEdit.getText().toString().trim();
        String SeatNumber = seatNumberEdit.getText().toString().trim();
        String DestinationLocation = destinationStation.getSelectedItem().toString().trim();




        if (!TextUtils.isEmpty(CustomerName) && !TextUtils.isEmpty(CustomerPhone) && !TextUtils.isEmpty(TrainName) && !TextUtils.isEmpty(TrainNumber)
                && !TextUtils.isEmpty(CoachName)  ){

            //Getting separate key to store each data
            String id = mDatabaseReference.push().getKey();

            //Creating a CustomerInfo Object
            CustomerInfo customerInfo = new CustomerInfo(id,CustomerName,CustomerPhone,TrainName,TrainNumber,CoachName,SeatNumber,DestinationLocation);

            //saving data to the database
            mDatabaseReference.child(id).setValue(customerInfo);

            //setting all edit_text to blank
            customerNameEdit.setText("");
            customerPhone.setText("");
            trainNameEdit.setText("");
            trainNumberEdit.setText("");
            coachNameEdit.setText("");
            seatNumberEdit.setText("");


            //Toast to show the status
            Toast.makeText(getApplicationContext(),"Done!!!",Toast.LENGTH_SHORT).show();


        } else {
            Toast.makeText(getApplicationContext(),"Please enter all the details ",Toast.LENGTH_SHORT).show();
        }


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
                startActivity(new Intent(UserDetailsActivity.this,LocationActivity.class));
                break;



            case R.id.Chat_menu:
                startActivity(new Intent(UserDetailsActivity.this,ChatActivity.class));
                break;

            case R.id.sign_out_menu:
                //Sign_out Operation
                AuthUI.getInstance().signOut(this);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN){
            if (resultCode == RESULT_OK){
                Toast.makeText(getApplicationContext(),"Signed in",Toast.LENGTH_SHORT).show();
            }else if (resultCode == RESULT_CANCELED){
                Toast.makeText(getApplicationContext(),"Signed in",Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Removing AuthStateListener, since this is in Pause State.
        mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Adding AuthStateListener, since this is in Resume State
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
}
