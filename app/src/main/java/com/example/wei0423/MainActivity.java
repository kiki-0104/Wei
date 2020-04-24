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

    private EditText name;
    private EditText height;
    private EditText weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();
    }

    private void findView() {
        name = findViewById(R.id.ed_name);
        height = findViewById(R.id.ed_height);
        weight = findViewById(R.id.ed_weight);
    }

    public void show(View view) {
        TextView b = findViewById(R.id.tv_showname);
        b.setText( name.getText().toString());
        TextView d = findViewById(R.id.tv_showheight);
        TextView f = findViewById(R.id.tv_showweight);
        f.setText( weight.getText().toString());
        ImageView view1 = (ImageView) findViewById(R.id.iv_pic);
        double c_value = Double.parseDouble(height.getText().toString());
        double e_value = Double.parseDouble(weight.getText().toString());
        double bmi = e_value / (c_value/100.0 * c_value/100.0);
        DecimalFormat df = new DecimalFormat("#.#");


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
            rem="體重正常";
//            Toast.makeText(this, "正常體重", Toast.LENGTH_LONG).show();
            view1.setImageResource(R.drawable.bmi2);
        }
        Toast.makeText(this,rem, Toast.LENGTH_LONG).show();
        g.setText("BMI:" + df.format(bmi) + rem);
    }

    public void nextPage(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("height",height.getText().toString());
        bundle.putString("weight",weight.getText().toString());
        bundle.putString("name",name.getText().toString());

        Intent intent = new Intent(this,showBMIActivity2.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
