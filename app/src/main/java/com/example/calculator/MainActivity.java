package com.example.calculator;


import org.mariuszgromada.math.mxparser.*;
import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    private EditText display;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);
    }

    private void updateText(String newString){
        String oldString = display.getText().toString();
        int cursorPosition = display.getSelectionStart();
        String leftString = oldString.substring(0, cursorPosition);
        String rightString = oldString.substring(cursorPosition);

        if (getString(R.string.display).equals(display.getText().toString())){
            display.setText(newString);
        }
        else{
            display.setText(String.format("%s%s%s",leftString,newString,rightString));
        }
        display.setSelection(cursorPosition+1);

    }


    public void zeroButton(View view){
        updateText("0");
    }

    public void oneButton(View view){
        updateText("1");
    }

    public void twoButton(View view){
        updateText("2");
    }

    public void threeButton(View view){
        updateText("3");
    }

    public void fourButton(View view){
        updateText("4");
    }

    public void fiveButton(View view){
        updateText("5");
    }

    public void sixButton(View view){
        updateText("6");
    }

    public void sevenButton(View view){
        updateText("7");
    }

    public void eightButton(View view){
        updateText("8");
    }

    public void nineButton(View view){
        updateText("9");
    }

    public void subtractButton(View view){
        updateText("-");
    }

    public void addButton(View view){
        updateText("+");
    }

    public void multiplyButton(View view){
        updateText("*");
    }

    public void divideButton(View view){
        updateText("/");
    }

    public void exponentButton(View view){
        updateText("^");
    }

    public void clearButton(View view){
        display.setText("");
    }

    public void backspaceButton(View view){
        int cursorPosition = display.getSelectionStart();
        int textLength = display.getText().length();

        if (cursorPosition != 0 && textLength != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPosition-1, cursorPosition, "");
            display.setText(selection);
            display.setSelection(cursorPosition-1);
        }
    }

    public void equalButton(View view){
        String data = display.getText().toString();
        Expression exp = new Expression(data);
        String result = String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());

    }

    public void pointButton(View view){
        updateText(".");
    }






}