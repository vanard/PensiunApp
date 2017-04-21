package com.vanard.tutorial.loginapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    EditText name, email, pass, conPass;
    Button reg_btn;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = (EditText)findViewById(R.id.reg_name);
        email = (EditText)findViewById(R.id.reg_email);
        pass = (EditText)findViewById(R.id.reg_password);
        conPass = (EditText)findViewById(R.id.reg_con_password);
        reg_btn = (Button)findViewById(R.id.reg_btn);

        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().equals("")||email.getText().toString().equals("")||pass.getText().toString().equals("")){
                    builder = new AlertDialog.Builder(RegisterActivity.this);
                    builder.setTitle("Something went wrong . . . ");
                    builder.setMessage("Please fill all the fields");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }else if(!(pass.getText().toString().equals(conPass.getText().toString()))){
                    builder = new AlertDialog.Builder(RegisterActivity.this);
                    builder.setTitle("Something went wrong . . . ");
                    builder.setMessage("Your password are not matching");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            pass.setText("");
                            conPass.setText("");
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }else{
                    BackgroundTask backgroundTask = new BackgroundTask(RegisterActivity.this);
                    backgroundTask.execute("register", name.getText().toString(), email.getText().toString(), pass.getText().toString());

                }
            }
        });
    }
}
