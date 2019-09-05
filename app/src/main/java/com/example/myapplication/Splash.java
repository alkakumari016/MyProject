package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences preferences=getSharedPreferences("User",MODE_PRIVATE);
                boolean b=preferences.getBoolean("logedin",false);
                if(b) {
                    Intent intent = new Intent(Splash.this, Scroll.class);
                    Splash.this.startActivity(intent);
                    Splash.this.finish();
                }
                else
                {
                    Intent intent=new Intent(Splash.this, Signin.class);
                    Splash.this.startActivity(intent);
                    Splash.this.finish();
                }

            }
        },3000);
    }
}
