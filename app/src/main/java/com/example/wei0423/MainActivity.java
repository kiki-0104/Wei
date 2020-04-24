package com.example.wei0423;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText a;
    private EditText c;
    private EditText e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();
    }

    private void findView() {
        a = findViewById(R.id.ed_name);
        c = findViewById(R.id.ed_height);
        e = findViewById(R.id.ed_weight);
    }

    public void show(View view) {
        TextView b = findViewById(R.id.tv_showname);
        b.setText("歡迎" + a.getText().toString());
        TextView d = findViewById(R.id.tv_showheight);
        TextView f = findViewById(R.id.tv_showweight);
        f.setText("體重:" + e.getText().toString()+"kg");
        ImageView view1 = (ImageView) findViewById(R.id.iv_pic);
        double c_value = Double.parseDouble(c.getText().toString());
        double e_value = Double.parseDouble(e.getText().toString());
        double bmi = e_value / (c_value/100.0 * c_value/100.0);
        DecimalFormat df = new DecimalFormat("#.##");


        TextView g = findViewById(R.id.tv_showbmi);
        String rem;
        if (bmi<18.5){
            rem=getString(R.string.strtoolight);
//            Toast.makeText(this, "體重過輕", Toast.LENGTH_LONG).show();
            view1.setImageResource(R.drawable.bmi1);
        }else if(bmi>24){
            rem=getString(R.string.strheavy);
//            Toast.makeText(this, "體重過重", Toast.LENGTH_LONG).show();
            view1.setImageResource(R.drawable.bmi3);
        }else{
            rem="strnormal";
//            Toast.makeText(this, "正常體重", Toast.LENGTH_LONG).show();
            view1.setImageResource(R.drawable.bmi2);
        }
        Toast.makeText(this,rem, Toast.LENGTH_LONG).show();
        g.setText("BMI:" + df.format(bmi) + rem);
    }

    public void nextPage(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("height",c.getText().toString());
        bundle.putString("weight",e.getText().toString());
        bundle.putString("name",a.getText().toString());

        Intent intent = new Intent(this,showBMIActivity2.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
