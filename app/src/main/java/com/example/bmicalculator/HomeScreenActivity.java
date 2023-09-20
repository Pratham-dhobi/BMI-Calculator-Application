package com.example.bmicalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

public class HomeScreenActivity extends AppCompatActivity {
    NumberPicker feet_val,inch_val;
    EditText age_val,weight_val;
    Button BMI_val;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        feet_val = findViewById(R.id.feet_numpick);
        inch_val = findViewById(R.id.Inch_numpick);
        age_val = findViewById(R.id.age_edt);
        weight_val = findViewById(R.id.weight_edt);
        BMI_val = findViewById(R.id.BMI_btn);

        // set max and min value for number picker
        feet_val.setMaxValue(10);
        feet_val.setMinValue(0);
        inch_val.setMaxValue(11);
        inch_val.setMinValue(0);

        BMI_val.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int age = Integer.parseInt(age_val.getText().toString());
                int weight = Integer.parseInt(weight_val.getText().toString());
                String msg;
                int ft=feet_val.getValue();
                int ich=inch_val.getValue();
                float Total_feet = (float) (ft + (ich / 12.0f));
                float meter = Total_feet * 0.304f;
                float BMI = weight / (meter * meter);
                if(BMI<19.0f){
                    msg="Under Weight";
                }else if(BMI>=19.0f && BMI<=25.0f){
                    msg="Normal";
                }else{
                    msg="Over Weight";
                }
                AlertDialog.Builder builder=new AlertDialog.Builder(HomeScreenActivity.this);
                builder.setTitle("Result");
                builder.setMessage("Your BMI number is "+ BMI +"\n"+msg);
                builder.setCancelable(true);
                builder.setPositiveButton("OK", (DialogInterface.OnClickListener) (dialog, which)->{
                    finish();
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }
}
