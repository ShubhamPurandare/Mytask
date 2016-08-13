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


public class Login extends AppCompatActivity {




    public  String TableName = "First";
    public String Username = "Username";
     private EditText username,password;

    private   static  String User = null;

    private   static  String Pass = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         username = (EditText)findViewById(R.id.editText1);

             password = (EditText)findViewById(R.id.editText2);

        Button Login = (Button)findViewById(R.id.button1);


        Login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = getIntent();
                String name1 = i.getStringExtra("key");
                Log.v("1: ", "Intent recieved sucess!!");


                 User = username.getText().toString();
                Pass = password.getText().toString();


                Log.v("1: ", "username n password saved success!!! ");
                Login login = new Login();

                Log.v("1: ", "Login obj success");
                SqlHelper sqlHelper = new SqlHelper(login);

                Log.v("1: ", "Sql obj success");
                Boolean ifUserExits = sqlHelper.ifExists(TableName ,Username , User);

                Log.v("1: ", "ifExists method called Success");

                if (ifUserExits == true){

                    Log.v("1: ", "Username exists");
                    Toast toast3 = Toast.makeText(getApplicationContext(), " Login Successfull.....", Toast.LENGTH_SHORT);
                    toast3.setGravity(Gravity.CENTER, 0, 0);
                    toast3.show();

                    Intent transfer = new Intent(Login.this, Reg_final.class);
                    transfer.putExtra("key", name1);
                    startActivity(transfer);
                    Log.v("1: ", "  Username verified !! Correct");


                }else {
                    Toast toast4 = Toast.makeText(getApplicationContext(), " Login unsucessfull.....", Toast.LENGTH_SHORT);
                    toast4.setGravity(Gravity.CENTER, 0, 0);
                    toast4.show();

                    Log.v("1: ", "  Username not correct");

                }


            }



        });

    }


}
