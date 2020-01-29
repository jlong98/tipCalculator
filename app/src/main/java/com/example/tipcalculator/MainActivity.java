package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText totalbill;
    private EditText tipamount;
    private TextView groupsize;
    private EditText grouptext;
    private RadioButton twobutton;
    private RadioButton singlebutton;
    private EditText tiptotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        totalbill = findViewById(R.id.totalBill);
        tipamount = findViewById(R.id.tipAmount);
        groupsize = findViewById(R.id.groupSize);
        grouptext = findViewById(R.id.groupText);
        twobutton = findViewById(R.id.twoButton);
        singlebutton = findViewById(R.id.singleButton);
        tiptotal = findViewById(R.id.tipTotal);
        grouptext.setText("1");
    }
    public void convert(View view){
        double tipT;
        String input = totalbill.getText().toString();
        String inputTip = tipamount.getText().toString();
        String inputGroup;
        if(singlebutton.isChecked()){
            grouptext.setText("1");
        }
        if(grouptext.getText().toString().trim().length()==0){
            Toast.makeText(this, "There was no value for group size entered", Toast.LENGTH_LONG).show();
        }else if(input.isEmpty()) {
            Toast.makeText(this, "There was no total entered", Toast.LENGTH_LONG).show();
        }else if(inputTip.isEmpty()) {
            Toast.makeText(this, "There was no tip entered", Toast.LENGTH_LONG).show();
        }else {
            inputGroup = grouptext.getText().toString();
            double bill = Double.parseDouble(input);
            double tip = Double.parseDouble(inputTip);
            tip = tip / 100;
            double group = Double.parseDouble(inputGroup);
            tipT = (bill * tip) / group;
            tiptotal.setText(String.format("%1f", tipT + (bill / group)));
        }
    }
}
