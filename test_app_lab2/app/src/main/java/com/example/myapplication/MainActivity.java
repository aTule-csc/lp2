package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText firstNum;
    private EditText secondNum;
    private TextView resultNum;
    private TextView symb;
    private TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        firstNum = findViewById(R.id.number1);
        secondNum =findViewById(R.id.number2);
        resultNum = findViewById(R.id.res);
        symb = findViewById(R.id.sym);
        error = findViewById(R.id.errorMessage);


    }
    public void Sum(View view){
        if (!firstNum.getText().toString().equals("") & !secondNum.getText().toString().equals("")){
            symb.setText("+");
            Number resnumber = Double.parseDouble(firstNum.getText().toString()) + Double.parseDouble(secondNum.getText().toString());
            resultNum.setText(resnumber.toString());
        }else{
            error.setText("!Ошибка, поля пустые");
        }
    }
    public void Dif(View view) {
        if(!firstNum.getText().toString().equals("") & !secondNum.getText().toString().equals("")){
            symb.setText("-");

            Number resnumber = Double.parseDouble(firstNum.getText().toString()) - Double.parseDouble(secondNum.getText().toString());
            resultNum.setText(resnumber.toString());

        }else{
            error.setText("!Ошибка, поля пустые");
        }


    }
    public void Mul(View view) {
        if (!firstNum.getText().toString().equals("") & !secondNum.getText().toString().equals("")) {
            symb.setText("*");

            Number resnumber = Double.parseDouble(firstNum.getText().toString()) * Double.parseDouble(secondNum.getText().toString());
            resultNum.setText(resnumber.toString());

        }else{
            error.setText("!Ошибка, поля пустые");
        }
    }
    public void Div(View view) {
        if(!firstNum.getText().toString().equals("") & !secondNum.getText().toString().equals("")){
            symb.setText("/");
            if(!secondNum.getText().toString().equals("0")){

                Number resnumber = Double.parseDouble(firstNum.getText().toString()) / Double.parseDouble(secondNum.getText().toString());
                resultNum.setText(resnumber.toString());
            }else{
                error.setText("!Ошибка, деление на ноль");
            }
        }else{
            error.setText("!Ошибка, поля пустые");
        }
    }
    public void cleanSlate(View view) {
        resultNum.setText("0");
        firstNum.setText("");
        secondNum.setText("");
        symb.setText("+");
        error.setText("");
    }
}