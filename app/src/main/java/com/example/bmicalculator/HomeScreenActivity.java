package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.NumberPicker;

public class HomeScreenActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        NumberPicker feet_numpick,inch_numpick;
        feet_numpick = findViewById(R.id.feet_numpick);
        inch_numpick = findViewById(R.id.Inch_numpick);
        feet_numpick.setMaxValue(10);
        feet_numpick.setMinValue(2);
        inch_numpick.setMaxValue(4);
        inch_numpick.setMinValue(0);
    }
}