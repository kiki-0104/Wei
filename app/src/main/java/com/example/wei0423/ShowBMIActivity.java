package com.example.wei0423;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.wei0423.ui.showbmi.ShowBmiFragment;

public class ShowBMIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_bmi_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ShowBmiFragment.newInstance())
                    .commitNow();
        }
        TextView show = (TextView) findViewById(R.id.tv_showbmi);
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        String h = bundle.getString("height");
        String w = bundle.getString("weight");

        show.setText(name+h+w);
    }
}
