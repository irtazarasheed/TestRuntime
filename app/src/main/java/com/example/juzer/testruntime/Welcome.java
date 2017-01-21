package com.example.juzer.testruntime;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Welcome extends AppCompatActivity {

    Button btnPartyOrganizer,btnPartyMember;
//    DatabaseAdapter loginDatabaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

  //      loginDatabaseAdapter=new DatabaseAdapter(this);
  //      loginDatabaseAdapter=loginDatabaseAdapter.open();

        // Get The Refference Of Buttons
        btnPartyOrganizer=(Button)findViewById(R.id.btnorganizer1);
        btnPartyMember=(Button)findViewById(R.id.btnmember1);

        btnPartyOrganizer.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intentLogin= new Intent(getApplicationContext(),Organizer.class);
                startActivity(intentLogin);
            }
        });

        // Set OnClick Listener on SignUp button
        btnPartyMember.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intentSignUP=new Intent(getApplicationContext(),SignUp.class);
                startActivity(intentSignUP);
            }
        });

    }
}
