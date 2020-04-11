package com.edu.qc.seclass.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalculatorActivity extends AppCompatActivity {

    private EditText billAmountEditText;
    private EditText partySizeEditText;
    private Button computeButton;
    private TextView tipTextView_15;
    private TextView tipTextView_20;
    private TextView tipTextView_25;
    private TextView tipTotalTextview_15;
    private TextView tipTotalTextview_20;
    private TextView tipTotalTextview_25;
    private Float billAmount;
    private Float partySize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        billAmountEditText = findViewById(R.id.checkAmountValue);
        partySizeEditText = findViewById(R.id.partySizeValue);
        computeButton = findViewById(R.id.buttonCompute);
        tipTotalTextview_15 = findViewById(R.id.fifteenPercentTotalValue);
        tipTotalTextview_20 = findViewById(R.id.twentyPercentTotalValue);
        tipTotalTextview_25 = findViewById(R.id.twentyfivePercentTotalValue);
        tipTextView_15 = findViewById(R.id.fifteenPercentTipValue);
        tipTextView_20 = findViewById(R.id.twentyPercentTipValue);
        tipTextView_25 = findViewById(R.id.twentyfivePercentTipValue);


        computeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }

    public void calculate(){
        Float result_15 = 0.0f;
        Float result_20 = 0.0f;
        Float result_25 = 0.0f;

        if(!billAmountEditText.getText().toString().equals("")){
            billAmount = Float.parseFloat(billAmountEditText.getText().toString());
            partySize = Float.parseFloat(partySizeEditText.getText().toString());

            result_15 = billAmount * 15/100;
            result_20 = billAmount * 20/100;
            result_25 = billAmount * 25/100;

            tipTextView_15.setText("Tip:  15% " + (result_15/partySize));
            tipTextView_20.setText("20% " + (result_20/partySize));
            tipTextView_25.setText("25% " + (result_25/partySize));

            tipTotalTextview_15.setText("Total:  15% " + result_15);
            tipTotalTextview_20.setText("20% " + result_20);
            tipTotalTextview_25.setText("25% " + result_25);
        }
        else {
            Toast.makeText(this, "Please enter the bill amount", Toast.LENGTH_SHORT).show();
        }
    }
}