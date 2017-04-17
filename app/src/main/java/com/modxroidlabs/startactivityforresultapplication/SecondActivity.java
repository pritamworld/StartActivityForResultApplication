package com.modxroidlabs.startactivityforresultapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity
{
    EditText edtName;
    Button btnSendMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Get a support ActionBar corresponding to this toolbar
        //https://developer.android.com/training/appbar/index.html
        ActionBar ab = getSupportActionBar();
        if(ab!=null)
        {
            // Enable the Up button
            ab.setDisplayHomeAsUpEnabled(true);
        }

        edtName=(EditText)findViewById(R.id.edtName);
        btnSendMessage=(Button)findViewById(R.id.btnSubmit);
        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String message=edtName.getText().toString();
                Intent intent=new Intent();
                //Set Bundle value
                intent.putExtra(FirstActivity.MESSAGE,message);
                //Set result for calling activity
                setResult(FirstActivity.CODE_GET_MESSAGE,intent);
                //Explicitly Finish activity and return
                finish();
            }
        });
    }
}
