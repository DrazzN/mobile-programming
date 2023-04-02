package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        EditText enum1, enum2;
        RadioGroup operators;
        Button calc;
        TextView resultView;
        
        enum1 = findViewById(R.id.num1);
        enum2 = findViewById(R.id.num2);
        operators = findViewById(R.id.operators);
        resultView = findViewById(R.id.result);

        calc = findViewById(R.id.calc);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num1 = Double.parseDouble(enum1.getText().toString());
                double num2 = Double.parseDouble(enum2.getText().toString());
                int selectedOperatorId = operators.getCheckedRadioButtonId();
                RadioButton selectOperator = findViewById(selectedOperatorId);
                String operator = selectOperator.getText().toString();
                double result = 0;
                
                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;
                        
                }
                resultView.setText(String.valueOf(result));
            }
        });
    }
}