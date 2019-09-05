package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signin extends AppCompatActivity {


    private EditText mEtname;
    private EditText mEtpwd;
    private SharedPreferences preferences;
    SharedPreferences.Editor editor;
    String username,pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        preferences=getSharedPreferences("User",MODE_PRIVATE);
        editor=preferences.edit();

        final Button Btnloginvalidate=findViewById(R.id.btn_loginvalidate);
        Btnloginvalidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String name=preferences.getString("Name","");
                final String password=preferences.getString("Password","");
                final boolean b=preferences.getBoolean("logedin",false);


                mEtname=findViewById(R.id.et_name);
                mEtpwd=findViewById(R.id.et_pass);

                username= mEtname.getText().toString().trim();
                pwd= mEtpwd.getText().toString().trim();

                if(username.equals(name) && pwd.equals(password)) {
                    editor.putBoolean("logedin",true);
                    editor.apply();
                    Intent intent = new Intent(Signin.this,Scroll.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(Signin.this,"Incorrect Details",Toast.LENGTH_SHORT).show();
                    Intent intent1=new Intent(Signin.this,Login_form.class);
                    startActivity(intent1);
                }
            }
        });

        final Button Btnsignin=findViewById(R.id.btn_signin);
        Btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Signin.this,Login_form.class);
                startActivity(intent);
            }
        });
    }
}

