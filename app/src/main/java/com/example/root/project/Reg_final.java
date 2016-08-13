package com.example.root.project;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;




public class Reg_final extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_final);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final TextView output = (TextView)findViewById(R.id.textView7);

        /*Bundle b= new Bundle();
        String name1= (String) b.get("key");
        */
        final SqlHelper dbHandler =new SqlHelper(this);

        Button database = (Button)findViewById(R.id.database);

        database.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

             String dbstring = dbHandler.toDatabase();
                output.setText(dbstring);



            }
        });



        Intent i = getIntent();
        String name1 = i.getStringExtra("key");

        TextView name = (TextView) findViewById(R.id.textView6);

        name.setText(name1);


    }






}
