package br.edu.ifsp.calculadora;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Double result = Double.valueOf(0);

    private String operator = "";

    private String visor = String.valueOf(result);

    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResult = findViewById(R.id.textResult);
    }

    public void onClickBtn(View view) {
        switch (view.getId()) {
            case R.id.button0:
                visor += 0.0;
                mathOperation(0.0);
                break;
            case R.id.button1:
                visor +=1.0;
                mathOperation(1.0);
                break;
            case R.id.button2:
                visor += 2.0;
                mathOperation(2.0);
                break;
            case R.id.button3:
                visor += 3.0;
                mathOperation(3.0);
                break;
            case R.id.button4:
                visor += 4.0;
                mathOperation(4.0);
                break;
            case R.id.button5:
                visor += 5.0;
                mathOperation(5.0);
                break;
            case R.id.button6:
                visor += 6.0;
                mathOperation(6.0);
                break;
            case R.id.button7:
                visor += 7.0;
                mathOperation(7.0);
                break;
            case R.id.button8:
                visor += 8.0;
                mathOperation(8.0);
                break;
            case R.id.button9:
                visor += 9.0;
                mathOperation(9.0);
                break;
            case R.id.buttonSum:
                ruleOperator("+");
                break;
            case R.id.buttonSub:
                ruleOperator("-");
                break;
            case R.id.buttonMult:
                ruleOperator("X");
                break;
            case R.id.buttonDiv:
                ruleOperator("/");
                break;
            case R.id.buttonClear:
                textResult.setText("0.0");
                result = 0.0;
                operator = "";
                visor = String.valueOf(result);
                break;
            case R.id.buttonResult:
                visor = String.valueOf(result);
                break;
        }
        textResult.setText(visor);
    }

    private void ruleOperator(String op) {
        if(!operator.equals("")) {
            visor = String.valueOf(result);
        }
        operator = op;
        visor += operator;
    }

    private void mathOperation(Double number) {
        switch (operator) {
            case "+":
                result += number;
                break;
            case "-":
                result -= number;
                break;
            case "X":
                result *= number;
                break;
            case "/":
                result /= number;
                break;
            case "":
                result = number;
                visor = String.valueOf(result);
                break;
        }
        operator = "";
    }
}
