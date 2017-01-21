package com.example.juzer.testruntime;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
  //  private static final int REQUEST_PERMISSION = 10;
    Button btnLogin, btnSignUp;
    DatabaseAdapter loginDatabaseAdapter;
  //  private static final int PERMISSION_REQUEST_CODE = 200;
  //  private int requestCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        if(checkPermission())
//        {
//            Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_LONG).show();
//        }
//        else{
//            requestPermission();
//        }



//        requestAppPermissions(new String[]{
//                        Manifest.permission.READ_EXTERNAL_STORAGE,
//                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                        Manifest.permission.MEDIA_CONTENT_CONTROL,
//                        Manifest.permission.READ_CONTACTS},
//                R.string.msg, REQUEST_PERMISSION);
        loginDatabaseAdapter = new DatabaseAdapter(this);
        loginDatabaseAdapter = loginDatabaseAdapter.open();
        btnLogin = (Button) findViewById(R.id.login1);
        btnSignUp = (Button) findViewById(R.id.signup1);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intentLogin = new Intent(getApplicationContext(), Login.class);
                startActivity(intentLogin);
            }
        });

        // Set OnClick Listener on SignUp button
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intentSignUP = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intentSignUP);
            }
        });
    }
//    private boolean checkPermission() {
//        int result = ContextCompat.checkSelfPermission(getApplicationContext(), READ_EXTERNAL_STORAGE);
//        Log.i("Permissions", "Requesting permissions: " + result);
//        return result == PackageManager.PERMISSION_GRANTED;
//    }
//    private void requestPermission() {
//        Log.v("Permission", "In request permission");
//        ActivityCompat.requestPermissions(this, new String[]{READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
//    }
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
//        Log.v("Permission","In request permission result");
//        switch (requestCode) {
//            case PERMISSION_REQUEST_CODE:
//                if (grantResults.length > 0) {
//                    Log.v("Result", grantResults.toString());
//                    boolean locationAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
//
//                    if (locationAccepted)
//                        Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_LONG).show();
//                    else {
//
//                        Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_LONG).show();
//
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,READ_EXTERNAL_STORAGE)) {
//                                showMessageOKCancel("You need to allow access to the permission.",
//                                        new DialogInterface.OnClickListener() {
//                                            @Override
//                                            public void onClick(DialogInterface dialog, int which) {
//                                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                                                    requestPermissions(new String[]{READ_EXTERNAL_STORAGE},
//                                                            PERMISSION_REQUEST_CODE);
//                                                }
//                                            }
//                                        });
//                                return;
//                            }
//                        }
//
//                    }
//                }
//
//
//                break;
//        }
//    }
//
//
//    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
//        new AlertDialog.Builder(MainActivity.this)
//                .setMessage(message)
//                .setPositiveButton("OK", okListener)
//                .setNegativeButton("Cancel", null)
//                .create()
//                .show();
//    }

//    @Override
//    public void onPermissionsGranted(int requestCode) {
//
//        //Do anything when permisson granted
//
//
//
//    }
}