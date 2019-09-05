package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private Button mBtn;
    private Button mBtnWEB;
    private EditText mEtCall;

    private String name;

    private String[] country=new String[]{"India","Japan","Aus"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mBtn = findViewById(R.id.bt_call);
        mEtCall=findViewById(R.id.et_call);
        final EditText mEtname=findViewById(R.id.et_name);
        final Button mBtnsubmit=findViewById(R.id.btn_submit);

        Spinner spinner=findViewById(R.id.spinner);

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,country);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Main2Activity.this,""+country[i],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mBtnWEB = findViewById(R.id.btn_web);
        mBtnWEB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent webIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.com"));
                startActivity(webIntent);
            }
        });

         mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 7381928854"));
                startActivity(callIntent);
            }
        });

         Button mBtnMail = findViewById(R.id.btn_email);
         mBtnMail.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent mailIntent = new Intent(Intent.ACTION_SENDTO,Uri.parse("mailto: "));
                 mailIntent.putExtra(Intent.EXTRA_EMAIL,new String[]{"pratikhyadas02@gmail.com"});
                 mailIntent.putExtra(Intent.EXTRA_SUBJECT,"Andrid subect");
                 mailIntent.putExtra(Intent.EXTRA_TEXT,"Android text");
                 startActivity(Intent.createChooser(mailIntent,"Send Mail"));

             }
         });

         mBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String number=mEtCall.getText().toString();
                 Intent callIntent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+number));
                 startActivity(callIntent);
             }
         });

        CheckBox checkBox=findViewById(R.id.chk_box);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(Main2Activity.this,""+b,Toast.LENGTH_SHORT).show();
            }
        });

        RadioGroup rg=findViewById(R.id.rd_grp);
        RadioButton rm=findViewById(R.id.rd_m);
        RadioButton rf=findViewById(R.id.rd_f);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.rd_m) {
                    Toast.makeText(Main2Activity.this,"Male",Toast.LENGTH_SHORT).show();
                }else if(i==R.id.rd_f){
                    Toast.makeText(Main2Activity.this,"Female",Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBtnsubmit.setEnabled(false);
        mEtname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(charSequence.toString().length()>0) {
                    mBtnsubmit.setEnabled(true);
                }
                else {
                    mBtnsubmit.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }

    public static final String TAG =Main2Activity.class.getSimpleName();
}
