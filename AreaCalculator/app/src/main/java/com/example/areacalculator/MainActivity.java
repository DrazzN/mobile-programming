package com.example.areacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        RadioGroup radioGroupShapes = findViewById(R.id.areaT);
        radioGroupShapes.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.circle:
                        findViewById(R.id.Length).setVisibility(View.GONE);
                        findViewById(R.id.Width).setVisibility(View.GONE);
                        findViewById(R.id.Radius).setVisibility(View.VISIBLE);
                        findViewById(R.id.Height).setVisibility(View.GONE);
                        break;
                    case R.id.rectangle:
                        findViewById(R.id.Length).setVisibility(View.VISIBLE);
                        findViewById(R.id.Width).setVisibility(View.VISIBLE);
                        EditText width = findViewById(R.id.Width);
                        width.setHint("Width");
                        findViewById(R.id.Radius).setVisibility(View.GONE);
                        findViewById(R.id.Height).setVisibility(View.GONE);
                        break;
                    case R.id.triangle:
                        findViewById(R.id.Length).setVisibility(View.GONE);
                        findViewById(R.id.Width).setVisibility(View.VISIBLE);
                        EditText base = findViewById(R.id.Width);
                        base.setHint("Base");
                        findViewById(R.id.Radius).setVisibility(View.GONE);
                        findViewById(R.id.Height).setVisibility(View.VISIBLE);
                        break;
                }

                Button calc = findViewById(R.id.Calc);
                calc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view){
                        RadioGroup radioGroupShapes = findViewById(R.id.areaT);
                        int selectedAreaId = radioGroupShapes.getCheckedRadioButtonId();
                        RadioButton selectedShape = findViewById(selectedAreaId);
                        String shape = (String) selectedShape.getText();

                        RadioGroup units = findViewById(R.id.unit);
                        int selectedUnitsId = units.getCheckedRadioButtonId();
                        RadioButton selectedUnit = findViewById(selectedUnitsId);
                        String unit = (String) selectedUnit.getText();

                        EditText Length = findViewById(R.id.Length);
                        EditText Width = findViewById(R.id.Width);
                        EditText Radius = findViewById(R.id.Radius);
                        EditText Height = findViewById(R.id.Height);
                        TextView Result;
                        Result = findViewById(R.id.Result);
                        double length = 0;
                        double width = 0;
                        double radius = 0;
                        double height = 0;

                        switch (shape) {
                            case "Rectangle":
                                length = Double.parseDouble(Length.getText().toString());
                                width = Double.parseDouble(Width.getText().toString());
                                double rectangleArea = length * width;
                                Result.setText("Area of Rectangle: " + rectangleArea + " sq." + unit);
                                break;
                            case "Circle":
                                radius = Double.parseDouble(Radius.getText().toString());
                                double circleArea = Math.PI * radius * radius;
                                Result.setText("Area of Circle: " + circleArea + " sq." + unit);
                                break;
                            case "Triangle":
                                height = Double.parseDouble(Height.getText().toString());
                                double base = Double.parseDouble(Width.getText().toString());
                                double triangleArea = 0.5 * base * height;
                                Result.setText("Area of Triangle: " + triangleArea + " sq." + unit);
                                break;
                        }
                    }
                });
            }
        });
    }
}
