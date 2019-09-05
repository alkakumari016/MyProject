package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mTvSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvSum=findViewById(R.id.tv_sum);

        int fnoFromSecondActivity=getIntent().getIntExtra("fno",1);
        int snoFromSecondActivity=getIntent().getIntExtra("sno",1);

        int sum=fnoFromSecondActivity+snoFromSecondActivity;
        mTvSum.setText(sum+"");
    }
}
