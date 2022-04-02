package com.example.kalkulator_new;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main_Math extends AppCompatActivity implements View.OnClickListener{
    TextView firstNumber;
    TextView secondNumber;
    TextView result;

    Button zero;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button stepen;
    Button koren;
    Button clear;
    Button sinus;
    Button cosinus;
    Button equals;
    Button page;
    String act;
    String chose;
    boolean fnum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_math);
        page = findViewById(R.id.page1);
        act = "";
        chose = "";
        fnum = true;
        firstNumber = findViewById(R.id.firstNumber);
        secondNumber = findViewById(R.id.secondNumber);
        result = findViewById(R.id.result);

        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        koren = findViewById(R.id.koren);
        stepen = findViewById(R.id.stepen);
        clear = findViewById(R.id.clear);
        cosinus = findViewById(R.id.cosinus);
        sinus = findViewById(R.id.sinus);
        equals = findViewById(R.id.equals);


        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        koren.setOnClickListener(this);
        stepen.setOnClickListener(this);
        cosinus.setOnClickListener(this);
        clear.setOnClickListener(this);
        sinus.setOnClickListener(this);
        equals.setOnClickListener(this);
        page.setOnClickListener(this);
    }
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.zero:
            case R.id.one:
            case R.id.two:
            case R.id.three:
            case R.id.four:
            case R.id.five:
            case R.id.six:
            case R.id.seven:
            case R.id.eight:
            case R.id.nine:
                Button button = (Button) view;
                String numText;
                if (fnum) {
                    numText = firstNumber.getText().toString();
                    numText += button.getText().toString();
                    firstNumber.setText(numText);
                } else {
                    numText = secondNumber.getText().toString();
                    numText += button.getText().toString();
                    secondNumber.setText(numText);
                }
                break;
            case R.id.koren:
            case R.id.stepen:
            case R.id.sinus:
            case R.id.cosinus:
                Button button1 = (Button) view;
                chose = button1.getText().toString();
                if (act == button1.getText().toString()) {
                    act = button1.getText().toString();
                    if (!fnum) {
                        fnum = !fnum;
                    }
                } else {
                    fnum = !fnum;
                }
                break;
            case R.id.equals:
                float num1;
                if (firstNumber.getText().toString() == "") num1 = 0;
                else num1 = Float.valueOf(firstNumber.getText().toString());
                float num2;
                if (secondNumber.getText().toString() == "") num2 = 0;
                else num2 = Float.valueOf(secondNumber.getText().toString());
                switch (chose) {
                    case ("√"):
                        double rezKor = Math.sqrt(num1);
                        result.setText(String.valueOf(rezKor));
                        break;
                    case ("sin"):
                        double rezSin = Math.sin(num1);
                        result.setText(String.valueOf(rezSin));
                        break;
                    case ("cos"):
                        double rezCos = Math.cos(num1);
                        result.setText(String.valueOf(rezCos));
                        break;
                    case ("^"):
                        double rezStep = Math.pow(num1,num2);
                        result.setText(String.valueOf(rezStep));
                        break;
                }
                break;
            case R.id.clear:
                firstNumber.setText("");
                secondNumber.setText("");
                result.setText("");
                fnum = true;
                break;
            case R.id.page1:
                Intent intent = new Intent(Main_Math.this, MainActivity.class);
                startActivity(intent);
                break;

        }
    }
}