package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    private Button mBtnSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mBtnSum=findViewById(R.id.btn_sum);

        final EditText mEtFno=findViewById(R.id.et_num1);
        final EditText mEtSno=findViewById(R.id.et_num2);

        mBtnSum.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View v) {

                int fno=Integer.parseInt(mEtFno.getText().toString().trim());
                int sno=Integer.parseInt(mEtSno.getText().toString().trim());

                Intent intent=new Intent(SecondActivity.this,MainActivity.class);
                intent.putExtra("fno",fno);
                intent.putExtra("sno",sno);
                startActivity(intent);
            }
        });
    }
}
