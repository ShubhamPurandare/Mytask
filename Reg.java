package com.example.root.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Reg extends AppCompatActivity {

    private static  String name1= null;

    private static  String user1= null;

    private static  String pass1= null ;
    public boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        Button submit = (Button) findViewById(R.id.submit);
        final EditText name = (EditText) findViewById(R.id.editText1);
        final EditText user = (EditText) findViewById(R.id.editText2);
        final EditText pass = (EditText) findViewById(R.id.editText3);
        final SqlHelper dbHandler =new SqlHelper(this);

        Intent i = new Intent(this,MyService.class);
        startService(i);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Reg.this , NewIntent.class);
                startService(intent);

                try {
                    name1 = name.getText().toString();
                    user1 = user.getText().toString();
                    pass1 = pass.getText().toString();

                    if (name1 == null || user == null || pass1 == null){
                        Toast toast2 = Toast.makeText(getApplicationContext(), " Cannot proceed .... Some fields are empty !", Toast.LENGTH_SHORT);
                        toast2.setGravity(Gravity.CENTER, 0, 0);
                        toast2.show();

                    }else {
                        if (pass1.length() < 8) {
                            Toast toast3 = Toast.makeText(getApplicationContext(), " Password Length insufficient", Toast.LENGTH_SHORT);
                            toast3.setGravity(Gravity.CENTER, 0, 0);
                            toast3.show();

                        } else {
                            Toast toast1 = Toast.makeText(getApplicationContext(), "Saving data on database ....", Toast.LENGTH_SHORT);
                            toast1.setGravity(Gravity.CENTER, 0, 0);
                            toast1.show();
                            Reg reg1 = new Reg();
                            Log.v("TEST", "Object created successfully !");
                            Log.v("TEST", "Inserting in database");
                            try {
                                dbHandler.addProducts(reg1);
                            } catch (Exception e1) {
                                Log.v("Fucked up !!!", " add products not executing !!!!");
                            }
                            Log.v("TEST", "Inserted in database");
                            Intent transfer = new Intent(Reg.this, Login.class);
                            transfer.putExtra("key", name1);
                            startActivity(transfer);
                        }
                    }

                } catch (Exception e) {

                }
            }
        });

    }

    public String getName1(){
        return name1;
    }

    public String getUser1(){
        return user1;
    }
    public String getPass1(){
        return pass1;
    }

    public void setname1(String name1){
        this.name1=name1;
    }

    public void setUser1(String user1){
        this.user1=user1;
    }
    public void setpass1(String pass1){
        this.pass1=pass1;
    }


}
