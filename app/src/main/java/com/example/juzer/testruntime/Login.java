package com.example.juzer.testruntime;

/**
 * Created by Juzer on 12/24/2016.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity{
    EditText editUserName, editPassword;
    Button btnLogin;
    DatabaseAdapter loginDatabaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        loginDatabaseAdapter=new DatabaseAdapter(this);
        loginDatabaseAdapter=loginDatabaseAdapter.open();

        editUserName=(EditText) findViewById(R.id.usernametextbox1);
        editPassword=(EditText) findViewById(R.id.passwordtextbox1);
        btnLogin=(Button) findViewById(R.id.login2);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // get The User name and Password
                String userName=editUserName.getText().toString();
                String password=editPassword.getText().toString();

                // fetch the Password form database for respective user name
                String storedPassword=loginDatabaseAdapter.getSinlgeEntry(userName);

                // check if the Stored password matches with  Password entered by user
                if(password.equals(storedPassword))
                {
                    Toast.makeText(Login.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
                    Intent intentWelcome=new Intent(getApplicationContext(),Welcome.class);
                    startActivity(intentWelcome);
                  //  dialog.dismiss();
                }
                else
                {
                    Toast.makeText(Login.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
                }
            }
        });

     //   dialog.show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close The Database
        loginDatabaseAdapter.close();
    }
}