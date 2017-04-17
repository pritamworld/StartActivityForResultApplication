package com.modxroidlabs.startactivityforresultapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    public static int CODE_GET_MESSAGE = 100; //Request Code to identify return intent
    public static String MESSAGE = "message"; //String key constant to identify bundle value
    TextView txtDefaultMessage;
    Button btnGetMessage;
    FloatingActionButton myFab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        txtDefaultMessage=(TextView)findViewById(R.id.txtDefaultMessage);
        myFab = (FloatingActionButton)findViewById(R.id.fab);
        btnGetMessage=(Button)findViewById(R.id.btnGetMessage);
        btnGetMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                // Activity is started with requestCode
                startActivityForResult(intent, CODE_GET_MESSAGE);
            }
        });

        myFab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Snackbar.make(findViewById(R.id.myCoordinatorLayout), "You Click FAB",
                        Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        //Check if the request code is same as what is passed  i.e. CODE_GET_MESSAGE = 100
        if(requestCode == CODE_GET_MESSAGE)
        {
            String message=data.getStringExtra(MESSAGE);//Read value from bundle
            txtDefaultMessage.setText(message);
            showPopupMessage(message);
        }
    }

    private void showPopupMessage(String msg)
    {
        //https://developer.android.com/training/snackbar/index.html
        Snackbar snackbar = Snackbar.make(findViewById(R.id.myCoordinatorLayout), msg,
                Snackbar.LENGTH_SHORT);

        snackbar.setAction("OK", new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(),"OK",Toast.LENGTH_SHORT).show();
            }
        });
        snackbar.show();
    }
}
