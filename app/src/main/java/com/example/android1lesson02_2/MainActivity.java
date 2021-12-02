package com.example.android1lesson02_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String INPUT_ARG = "INPUT_ARG"; // аргумент для передачи
    private TextView Screen;
    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private Button buttonSum, buttonDiff, buttonDiv, buttonMul, buttonDot, buttonSwitch, buttonC,buttonCE, buttonSq, buttonItog;
    // кнопки:       +            -          /           *          .           +/-             C     CE       корень      =
    private String input,Answer;
    private String lastKeyOperation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // заранее определяем Screen, чтобы передать в него при повороте экрана данные
        Screen = findViewById(R.id.textViewLED);
        // проверка savedInstanceState
        if (savedInstanceState != null){
            input = savedInstanceState.getString(INPUT_ARG);
            Screen.setText(input);
        }

        // - функциональные кнопки
        buttonC = findViewById(R.id.buttonC);
        buttonCE = findViewById(R.id.buttonCE);
        // - кнопки операций
        buttonSum = findViewById(R.id.buttonSum);
        buttonDiff = findViewById(R.id.buttonDiff);
        buttonDiv = findViewById(R.id.buttonDiv);
        buttonMul = findViewById(R.id.buttonMul);
        buttonSq = findViewById(R.id.buttonSq);
        buttonItog = findViewById(R.id.buttonItog);
        buttonSwitch = findViewById(R.id.buttonSwitch);
        // - точка
        buttonDot = findViewById(R.id.buttonDot);
        // - цифровые кнопки
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
    }

    public void buttonClick(View view){
        Button button = (Button) view;
        String data = button.getText().toString();
        //lastKeyOperation = "";
        switch (data){
            case "C":
                input = "";
                break;
            case "x":
                calculateMetod();
                input += "*";
                break;
            case "√":
                calculateMetod();
                //input += "√";
                break;
            case "=":
                calculateMetod();
                Answer = input;
                break;
            case "CE":
                String newText = input.substring(0,input.length()-1);
                input = newText;
                break;
            default:
                if (input == null){
                    input = "";
                }
                if (data.equals("+") || data.equals("-") || data.equals("/")){
                    //statusKeyOperation = true;
                    calculateMetod();
                }
                input+=data;
        }
        Screen.setText(input);
    }

    private void calculateMetod(){
        if (input.split("\\*").length == 2){
            String number[] = input.split("\\*");
            try {
                double mul = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input = mul + "";
            }
            catch (Exception e){
                // error
            }
        }
        else if (input.split("/").length == 2){
            String number[] = input.split("/");
            try {
                if (Double.parseDouble(number[1])!=0)
                {
                    double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                    input =div + "";
                } else {
                    //("Деление на 0 - ошибка!") - просто перезаписываем пустотой
                    input = "";
                }

            }
            catch (Exception e){
                // error
            }
        }
        else if (input.split("\\+").length == 2){
            String number[] = input.split("\\+");
            try {
                double sum = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input = sum +"";
            }
            catch (Exception e){
                //error
            }
        }

        else if (input.split("-").length > 1) {
            String number[] = input.split("-");
            if (number[0] == "" && number.length == 2){
                number[0] = 0 +"";
            }
            try {
                double sub = 0;
                if (number.length == 2){
                    sub = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                } else if (number.length == 3) {
                    sub = -Double.parseDouble(number[1]) - Double.parseDouble(number[2]);
                }
                input = sub + "";
            }
            catch (Exception e){
                // error
            }
        }
        // удаляем 0 из целочисленного результата
        String n[] = input.split("\\.");
        if (n.length > 1){
            if (n[1].equals("0")){
                input = n[0];
            }
        }
        Screen.setText(input);
        lastKeyOperation="";
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle instanceState){
        super.onSaveInstanceState(instanceState);
        instanceState.putString(INPUT_ARG, input); //1
    }

    // остальные методы на момент задания №3 не используются, комментируем их

/*    @Override
    protected void onStart(){
        super.onStart();
    }*/



/*
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState){
        super.onRestoreInstanceState(instanceState);
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
*/

/*    private void makeToast(String toast){
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
        Log.e("mylogs: ", toast);
    }*/
}