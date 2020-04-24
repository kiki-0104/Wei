package com.example.wei0423;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class showBMIActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bmi2);


        TextView show_name= (TextView) findViewById(R.id.tv_name);
        ImageView view1 = (ImageView) findViewById(R.id.iv_pic);



        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        String h = bundle.getString("height");
        String w = bundle.getString("weight");

        double bmi = Double.parseDouble(w)/ (Double.parseDouble(h)/100.0 * Double.parseDouble(h)/100.0);
        DecimalFormat df = new DecimalFormat("#.##");


        TextView g = findViewById(R.id.tv_bmi);
        String rem;
        if (bmi<18.5){
            rem="體重過輕";
           Toast.makeText(this, "體重過輕", Toast.LENGTH_LONG).show();
            view1.setImageResource(R.drawable.bmi1);
        }else if(bmi>24){
            rem="體重過重";
          Toast.makeText(this, "體重過重", Toast.LENGTH_LONG).show();
            view1.setImageResource(R.drawable.bmi3);
        }else{
            rem="正常體重";
          Toast.makeText(this, "正常體重", Toast.LENGTH_LONG).show();
            view1.setImageResource(R.drawable.bmi2);
        }
     Toast.makeText(this,rem, Toast.LENGTH_LONG).show();
        show_name.setText(name);
        g.setText("您的'BMI'是"+bmi);
    }
}
