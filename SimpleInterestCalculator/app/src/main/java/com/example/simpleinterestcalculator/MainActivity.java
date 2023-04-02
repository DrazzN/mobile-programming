package com.example.simpleinterestcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText principle, time, rate;
TextView result;
Button calc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        principle = findViewById(R.id.principle);
        time = findViewById(R.id.time);
        rate = findViewById(R.id.rate);
        result = findViewById(R.id.result);
        calc = findViewById(R.id.calc);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int p, t, r, si;
                p = Integer.parseInt(principle.getText().toString());
                t = Integer.parseInt(time.getText().toString());
                r = Integer.parseInt(rate.getText().toString());
                si = (p*t*r)/100;
                result.setText("Simple Interest is : "+ si);
            }
        });

    }
}
