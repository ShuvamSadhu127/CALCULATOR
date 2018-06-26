package com.example.shuvam.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv;
    EditText ed;
    Button add,sub,mul,div,one,two,three,four,five,six,seven,eight,nine,zero,deci,equals,clear;
    double valueOne;
    double valueTwo;

    DecimalFormat decimalFormat;

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char CURRENT_ACTION;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        decimalFormat = new DecimalFormat("#.##########");


        tv=findViewById(R.id.textView);
        ed=findViewById(R.id.editText);
        add=findViewById(R.id.buttonPlus);
        sub=findViewById(R.id.buttonSub);
        mul=findViewById(R.id.buttonMul);
        div=findViewById(R.id.buttonDiv);
        one=findViewById(R.id.buttonOne);
        two=findViewById(R.id.buttonTwo);
        three=findViewById(R.id.buttonThree);
        four=findViewById(R.id.buttonFour);
        five=findViewById(R.id.buttonFive);
        six=findViewById(R.id.buttonSix);
        seven=findViewById(R.id.buttonSeven);
        eight=findViewById(R.id.buttonEight);
        nine=findViewById(R.id.buttonNine);
        zero=findViewById(R.id.buttonZero);
        deci=findViewById(R.id.buttonDeci);
        equals=findViewById(R.id.buttonEquals);
        clear=findViewById(R.id.buttonClear);

        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        deci.setOnClickListener(this);
        equals.setOnClickListener(this);

    }
    public void allClear(View view){
        int id=view.getId();
            tv.setText("");
            ed.setText("");
            deci.setEnabled(true);


    }
    @Override
    public void onClick(View view) {
        int id = view.getId();
        int num1,num2;
        String input;
        input="7";
        String getEd;
        getEd=ed.getText().toString();
        if (id == R.id.buttonSeven) {
            //input.concat("8");
            ed.setText(ed.getText() + "7");

        }
        if (id == R.id.buttonEight) {
            //input.concat("8");
            ed.setText(ed.getText() + "8");

        }
        if (id == R.id.buttonNine) {
            //input.concat("8");
            ed.setText(ed.getText() + "9");

        }
        if (id == R.id.buttonFour) {
            //input.concat("8");
            ed.setText(ed.getText() + "4");

        }
        if (id == R.id.buttonFive) {
            //input.concat("8");
            ed.setText(ed.getText() + "5");

        }
        if (id == R.id.buttonSix) {
            //input.concat("8");
            ed.setText(ed.getText() + "6");

        }
        if (id == R.id.buttonOne) {
            //input.concat("8");
            ed.setText(ed.getText() + "1");

        }
        if (id == R.id.buttonTwo) {
            //input.concat("8");
            ed.setText(ed.getText() + "2");

        }
        if (id == R.id.buttonThree) {
            //input.concat("8");
            ed.setText(ed.getText() + "3");

        }
        if (id == R.id.buttonZero) {
            //input.concat("8");
            ed.setText(ed.getText() + "0");

        }
        if (id == R.id.buttonDeci) {
            //input.concat("8");
            if(TextUtils.isEmpty(getEd)){
                ed.setText("0" + ".");
                deci.setEnabled(false);
            }else {
                ed.setText(ed.getText() + ".");
                deci.setEnabled(false);
            }


        }
        if (id == R.id.buttonMul) {
            //input.concat("8");
            if(!(TextUtils.isEmpty(getEd))) {
                ed.setText(ed.getText());
                deci.setEnabled(true);
                valueOne = Double.parseDouble(ed.getText().toString());

                //num1=Float.parseFloat(ed.getText());
                //computeAns();
                CURRENT_ACTION = MULTIPLICATION;
                ed.setText("");

            }
        }
        if (id == R.id.buttonDiv) {
            //input.concat("8");
            if(!(TextUtils.isEmpty(getEd))) {
                ed.setText(ed.getText());
                deci.setEnabled(true);
                valueOne = Double.parseDouble(ed.getText().toString());
                //computeAns();
                CURRENT_ACTION = DIVISION;
                ed.setText("");
            }

        }
        if (id == R.id.buttonPlus) {
            //input.concat("8");
            ed.setText(ed.getText());
            deci.setEnabled(true);
            valueOne = Double.parseDouble(ed.getText().toString());
            //computeAns();
            CURRENT_ACTION = ADDITION;
            ed.setText("");


        }
        if (id==R.id.buttonSub){
            ed.setText(ed.getText());
            if(TextUtils.isEmpty(ed.getText()))
                ed.setText("-");
           // deci.setEnabled(true);
            else {
                deci.setEnabled(true);
                valueOne = Double.parseDouble(ed.getText().toString());
                //computeAns();
                CURRENT_ACTION = SUBTRACTION;
                ed.setText("");
            }

        }
        if(id==R.id.buttonEquals){
            computeAns();
        }







    }
    public void computeAns(){
            valueTwo = Double.parseDouble(ed.getText().toString());

            if(CURRENT_ACTION == ADDITION) {
                double ans = valueOne+valueTwo;
                ed.setText(ans+"");
                valueOne = 0;
                valueTwo = 0;
            }
            else if(CURRENT_ACTION == SUBTRACTION) {
                double ans = valueOne-valueTwo;
                ed.setText(ans+"");
                valueOne = 0;
                valueTwo = 0;

            }
            else if(CURRENT_ACTION == MULTIPLICATION){
                double ans = valueOne*valueTwo;
                ed.setText(ans+"");
                valueOne = 0;
                valueTwo = 0;
            }

            else if(CURRENT_ACTION == DIVISION) {
                if (valueTwo != 0) {
                    double ans = valueOne / valueTwo;
                    ed.setText(ans + "");
                    valueOne = 0;
                    valueTwo = 0;

                }
                else {
                    tv.setText("Cannot divide by zero");
                    valueOne = 0;
                    valueTwo = 0;
                }
            }
    }

}
