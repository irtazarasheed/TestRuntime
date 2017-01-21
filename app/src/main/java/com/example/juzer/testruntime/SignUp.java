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

public class SignUp extends Activity{

    EditText editUserName, editEmail, editPassword,editConfirmPassword;
    Button btnSignUp;

    DatabaseAdapter loginDatabaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        // get Instance  of Database Adapter
        loginDatabaseAdapter=new DatabaseAdapter(this);
        loginDatabaseAdapter=loginDatabaseAdapter.open();

        // Get Refferences of Views
        editUserName=(EditText)findViewById(R.id.usernametextbox2);
        editEmail=(EditText)findViewById(R.id.emailtextbox1);
        editPassword=(EditText)findViewById(R.id.passwordtextbox2);
        editConfirmPassword=(EditText)findViewById(R.id.cpasswordtextbox1);

        btnSignUp=(Button)findViewById(R.id.signup2);
        btnSignUp.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                String userName=editUserName.getText().toString();
                String email = editEmail.getText().toString();
                String password=editPassword.getText().toString();
                String confirmPassword=editConfirmPassword.getText().toString();

                // check if any of the fields are vaccant
                if(userName.equals("")||password.equals("")||confirmPassword.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
                    return;
                }
                // check if both password matches
                if(!password.equals(confirmPassword))
                {
                    Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
                    return;
                }
                else
                {
                    // Save the Data in Database
                    loginDatabaseAdapter.insertEntry(userName,email, password);
                    Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
                    Intent intentWelcome=new Intent(getApplicationContext(),Welcome.class);
                    startActivity(intentWelcome);
                }
            }
        });
    }
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        loginDatabaseAdapter.close();
    }
}
