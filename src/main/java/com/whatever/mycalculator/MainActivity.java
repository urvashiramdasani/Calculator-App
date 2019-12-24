package com.whatever.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    private enum OPERATOR {
        PLUS, SUBTRACT, MULTIPLY, DIVIDE, EQUAL
    }

    TextView txtCalculations;
    TextView txtResults;

    //Instance Variables
    private String currentNumber;
    private String stringNumberAtLeft;
    private String stringNumberAtRight;
    private OPERATOR currentOperator;
    private int calculationsResult;
    private String calculationsString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentNumber = "";
        calculationsResult = 0;
        calculationsString = "";

        txtCalculations = findViewById(R.id.txtCalculations);
        txtResults = findViewById(R.id.txtResults);

        findViewById(R.id.BtnEqual).setOnClickListener(MainActivity.this);
        findViewById(R.id.Btn7).setOnClickListener(MainActivity.this);
        findViewById(R.id.Btn8).setOnClickListener(MainActivity.this);
        findViewById(R.id.Btn9).setOnClickListener(MainActivity.this);
        findViewById(R.id.BtnPlus).setOnClickListener(MainActivity.this);
        findViewById(R.id.Btn4).setOnClickListener(MainActivity.this);
        findViewById(R.id.Btn5).setOnClickListener(MainActivity.this);
        findViewById(R.id.Btn6).setOnClickListener(MainActivity.this);
        findViewById(R.id.BtnMinus).setOnClickListener(MainActivity.this);
        findViewById(R.id.Btn1).setOnClickListener(MainActivity.this);
        findViewById(R.id.Btn2).setOnClickListener(MainActivity.this);
        findViewById(R.id.Btn3).setOnClickListener(MainActivity.this);
        findViewById(R.id.BtnMultiply).setOnClickListener(MainActivity.this);
        findViewById(R.id.BtnClear).setOnClickListener(MainActivity.this);
        findViewById(R.id.Btn0).setOnClickListener(MainActivity.this);
        findViewById(R.id.BtnDivide).setOnClickListener(MainActivity.this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.BtnEqual : operatorIsTapped(OPERATOR.EQUAL);
                                break;
            case R.id.Btn7 : numberIsTapped(7);
                                break;
            case R.id.Btn8 : numberIsTapped(8);
                                break;
            case R.id.Btn9 : numberIsTapped(9);
                                break;
            case R.id.BtnPlus : operatorIsTapped(OPERATOR.PLUS);
                                calculationsString += " + ";
                                break;
            case R.id.Btn4 : numberIsTapped(4);
                                break;
            case R.id.Btn5 : numberIsTapped(5);
                                break;
            case R.id.Btn6 : numberIsTapped(6);
                                break;
            case R.id.BtnMinus : operatorIsTapped(OPERATOR.SUBTRACT);
                                    calculationsString += " - ";
                                    break;
            case R.id.Btn1 : numberIsTapped(1);
                                break;
            case R.id.Btn2 : numberIsTapped(2);
                                break;
            case R.id.Btn3 : numberIsTapped(3);
                            break;
            case R.id.BtnMultiply : operatorIsTapped(OPERATOR.MULTIPLY);
                                    calculationsString += " * ";
                                    break;
            case R.id.BtnClear : clearTapped();
                                    break;
            case R.id.Btn0 : numberIsTapped(0);
                                break;
            case R.id.BtnDivide : operatorIsTapped(OPERATOR.DIVIDE);
                                    calculationsString += " / ";
                                    break;
        }
        txtCalculations.setText(calculationsString);
    }

    private void numberIsTapped(int tappedNumber) {
        currentNumber = currentNumber + String.valueOf(tappedNumber);
        txtResults.setText(currentNumber);
        calculationsString = currentNumber;
        txtCalculations.setText(calculationsString);
    }

    private void operatorIsTapped(OPERATOR tappedOperator) {
        if(currentOperator!=null) {
            if(!currentNumber.equals("")) {
                stringNumberAtRight = currentNumber;
                currentNumber = "";
                switch (currentOperator) {
                    case PLUS: calculationsResult = Integer.parseInt(stringNumberAtLeft) + Integer.parseInt(stringNumberAtRight);
                        break;
                    case SUBTRACT: calculationsResult = Integer.parseInt(stringNumberAtLeft) - Integer.parseInt(stringNumberAtRight);
                        break;
                    case MULTIPLY: calculationsResult = Integer.parseInt(stringNumberAtLeft) * Integer.parseInt(stringNumberAtRight);
                        break;
                    case DIVIDE: calculationsResult = Integer.parseInt(stringNumberAtLeft) /Integer.parseInt(stringNumberAtRight);
                        break;
                }
                stringNumberAtLeft = String.valueOf(calculationsResult);
                txtResults.setText(stringNumberAtLeft);
                calculationsString = stringNumberAtLeft;
            }
        }
        else {
            stringNumberAtLeft = currentNumber;
            currentNumber = "";
        }
        currentOperator = tappedOperator;
    }

    private void clearTapped() {
        stringNumberAtLeft = "";
        stringNumberAtRight = "";
        calculationsResult = 0;
        currentNumber = "";
        currentOperator = null;
        txtResults.setText("0");
        calculationsString = "0";
        //txtCalculations.setText("");
    }
}
