package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import java.util.Calendar;

public class Date_time extends AppCompatActivity {

    private Button mBtndate;
    private Button mBtntime;
    Calendar calendar=Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_time);

        mBtndate=findViewById(R.id.et_date);
        mBtntime=findViewById(R.id.et_time);

        mBtndate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        mBtntime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int hour=calendar.get(Calendar.HOUR_OF_DAY);
                int minute=calendar.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker = new TimePickerDialog(Date_time.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        mBtntime.setText(i+":"+i1);
                    }
                },hour,minute,false);
                mTimePicker.setTitle("Selected Time");
                mTimePicker.show();

            }
        });
    }
}
