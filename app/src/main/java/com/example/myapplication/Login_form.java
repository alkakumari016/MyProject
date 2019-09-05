package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.lang.String;

public class Login_form extends AppCompatActivity {

    private String[] country={"India","Japan","Australia","Brazil"};
    private Button mBtnsignup;

    private SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private EditText mEtname;
    private EditText mEtpwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_form);

        Spinner spinner=findViewById(R.id.spinner_country);

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,country);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Login_form.this,country[i],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        mBtnsignup=findViewById(R.id.btn_signup);
        mBtnsignup.setEnabled(false);
        final CheckBox mChk=findViewById(R.id.chk_agree);
        mChk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()==true) {
                    mBtnsignup.setEnabled(true);
                }
                else {
                    mBtnsignup.setEnabled(false);
                }
            }
        });


        mEtname=findViewById(R.id.et_uname);
        mEtpwd=findViewById(R.id.et_pwd);

        preferences=getSharedPreferences("User",MODE_PRIVATE);
        editor=preferences.edit();

        mBtnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=mEtname.getText().toString().trim();
                String password=mEtpwd.getText().toString().trim();
                editor.putString("Name",name);
                editor.putString("Password",password);
                editor.putBoolean("logedin",false);
                editor.apply();
                Intent intent1=new Intent(Login_form.this,Signin.class);
                startActivity(intent1);
            }
        });

    }
}
