package com.vanard.tutorial.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txV;
    Button bn_Input, buttonView;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        txV = (TextView)findViewById(R.id.welcome_txt);
        String message = getIntent().getStringExtra("message");
        txV.setText(message);

        bn_Input = (Button)findViewById(R.id.bnInput);
        buttonView = (Button)findViewById(R.id.buttonView);

        bn_Input.setOnClickListener(this);
        buttonView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == bn_Input){
            startActivity(new Intent(this, Input.class));
        }
        if(v == buttonView){
            startActivity(new Intent(this,ViewAllData.class));
        }
    }
}
