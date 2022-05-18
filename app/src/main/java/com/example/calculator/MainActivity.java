package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0;
    Button add,sub,mul,div;
    Button equal,dot,c;
    EditText txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final boolean[] flag = {true};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0 = (Button)findViewById(R.id.btn0);
        btn0.setOnClickListener(this);
        btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn2 = (Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        btn3 = (Button)findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        btn4 = (Button)findViewById(R.id.btn4);
        btn4.setOnClickListener(this);
        btn5 = (Button)findViewById(R.id.btn5);
        btn5.setOnClickListener((View.OnClickListener) this);
        btn6 = (Button)findViewById(R.id.btn6);
        btn6.setOnClickListener((View.OnClickListener) this);
        btn7 = (Button)findViewById(R.id.btn7);
        btn7.setOnClickListener(this);
        btn8 = (Button)findViewById(R.id.btn8);
        btn8.setOnClickListener(this);
        btn9 = (Button)findViewById(R.id.btn9);
        btn9.setOnClickListener(this);
        add = (Button)findViewById(R.id.add);
        add.setOnClickListener(this);
        sub = (Button)findViewById(R.id.sub);
        sub.setOnClickListener(this);
        mul = (Button)findViewById(R.id.mul);
        mul.setOnClickListener(this);
        div = (Button)findViewById(R.id.div);
        div.setOnClickListener(this);
        c = (Button)findViewById(R.id.c);
        c.setOnClickListener(this);
        dot = (Button)findViewById(R.id.dot);
        dot.setOnClickListener(this);
        equal = (Button)findViewById(R.id.equal);
        equal.setOnClickListener(this);
        txtResult = (EditText)findViewById(R.id.txtResult);
        txtResult.setText(" ");
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtResult.setText("");
            }
        });
    }
    @Override
    public void onClick(View v) {
        if (v.equals(btn0))
            txtResult.append("0");
        if (v.equals(btn1))
            txtResult.append("1");
        if (v.equals(btn2))
            txtResult.append("2");
        if (v.equals(btn3))
            txtResult.append("3");
        if (v.equals(btn4))
            txtResult.append("4");
        if (v.equals(btn5))
            txtResult.append("5");
        if (v.equals(btn6))
            txtResult.append("6");
        if (v.equals(btn7))
            txtResult.append("7");
        if (v.equals(btn8))
            txtResult.append("8");
        if (v.equals(btn9))
            txtResult.append("9");
        if (v.equals(dot))
            txtResult.append(".");
        if (v.equals(c))
            txtResult.setText("");
        if(v.equals(add))
            txtResult.append("+");
        if(v.equals(sub))
            txtResult.append("-");
        if(v.equals(mul))
            txtResult.append("*");
        if(v.equals(div))
            txtResult.append("/");
        if(v.equals(equal)) {
            try{
                String data = txtResult.getText().toString();
                if(data.contains("/")){
                    String[] operands = data.split("/");
                    if (operands.length==2){
                        double operand1=Double.parseDouble(operands[0]);
                        double operand2=Double.parseDouble(operands[1]);
                        double res=operand1/operand2;
                        txtResult.setText(String.valueOf(res));

                    }
                    else {
                        Toast.makeText(getBaseContext(), "invalid input", Toast.LENGTH_LONG).show();
                    }
                }
                else if(data.contains("*")){
                    String[] operands = data.split(Pattern.quote("*"));
                    if (operands.length==2){
                        double operand1=Double.parseDouble(operands[0]);
                        double operand2=Double.parseDouble(operands[1]);
                        double res =operand1*operand2;
                        txtResult.setText(String.valueOf(res));
                    }
                    else {
                        Toast.makeText(getBaseContext(), "invalid input", Toast.LENGTH_LONG).show();
                    }
                }
                else if(data.contains("+")){
                    String[] operands = data.split(Pattern.quote("+"));
                    if (operands.length==2){
                        double operand1=Double.parseDouble(operands[0]);
                        double operand2=Double.parseDouble(operands[1]);
                        double res=operand1+operand2;
                        txtResult.setText(String.valueOf(res));
                    }
                    else {
                        Toast.makeText(getBaseContext(), "invalid input", Toast.LENGTH_LONG).show();
                    }
                }
                else if(data.contains("-")){
                    String[] operands = data.split(Pattern.quote("-"));
                    if (operands.length==2){
                        double operand1=Double.parseDouble(operands[0]);
                        double operand2=Double.parseDouble(operands[1]);
                        double res=operand1-operand2;
                        txtResult.setText(String.valueOf(res));
                    }
                    else {
                        Toast.makeText(getBaseContext(), "invalid input", Toast.LENGTH_LONG).show();
                    }
                }
            }
            catch (Exception e)
            {
                Toast.makeText(getBaseContext(),"INVALID INPUT",Toast.LENGTH_LONG).show();
            }

        }

    }
}