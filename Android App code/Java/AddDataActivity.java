package com.solutions.canopy.bttrial;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
#### Used for the round buttons
import android.support.design.widget.Snackbar;
### Similar to Toast
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
### Generalisation of Action Buttons in the Android Layout
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddDataActivity extends AppCompatActivity {

    EditText hrate, cond;
    Button send;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
         myRef = database.getReference("heart_rate");




        hrate = (EditText) findViewById(R.id.hrate_et_id);
        cond = (EditText) findViewById(R.id.cond_et_id);
        send = (Button) findViewById(R.id.send_btn);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myRef.setValue(hrate.getText().toString());

            }
        });


    }

}

