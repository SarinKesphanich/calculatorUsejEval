package com.buu.se.s55160403.calculatorUserjEval;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;


public class MainActivity extends Activity implements View.OnClickListener {

    private String equation;
    private Float result;
    private Button n1, n2, n3, n4, n5, n6, n7, n8, n9, n0, btnDot, btnReset, btnEqua, btn01, btn02, btn03, btn04;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        equation = "";
        n1 = (Button) findViewById(R.id.n1);
        n2 = (Button) findViewById(R.id.n2);
        n3 = (Button) findViewById(R.id.n3);
        n4 = (Button) findViewById(R.id.n4);
        n5 = (Button) findViewById(R.id.n5);
        n6 = (Button) findViewById(R.id.n6);
        n7 = (Button) findViewById(R.id.n7);
        n8 = (Button) findViewById(R.id.n8);
        n9 = (Button) findViewById(R.id.n9);
        n0 = (Button) findViewById(R.id.n0);

        btn01 = (Button) findViewById(R.id.btn01);
        btn02 = (Button) findViewById(R.id.btn02);
        btn03 = (Button) findViewById(R.id.btn03);
        btn04 = (Button) findViewById(R.id.btn04);
        btnDot = (Button) findViewById(R.id.btnDot);

        n1.setOnClickListener(this);
        n2.setOnClickListener(this);
        n3.setOnClickListener(this);
        n4.setOnClickListener(this);
        n5.setOnClickListener(this);
        n6.setOnClickListener(this);
        n7.setOnClickListener(this);
        n8.setOnClickListener(this);
        n9.setOnClickListener(this);
        n0.setOnClickListener(this);

        btn01.setOnClickListener(this);
        btn02.setOnClickListener(this);
        btn03.setOnClickListener(this);
        btn04.setOnClickListener(this);
        btnDot.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn01:
                equation += "+";
                break;
            case R.id.btn02:
                equation += "-";
                break;
            case R.id.btn03:
                equation += "*";
                break;
            case R.id.btn04:
                equation += "/";
                break;
            case R.id.n1:
                equation += "1";
                break;
            case R.id.n2:
                equation += "2";
                break;
            case R.id.n3:
                equation += "3";
                break;
            case R.id.n4:
                equation += "4";
                break;
            case R.id.n5:
                equation += "5";
                break;
            case R.id.n6:
                equation += "6";
                break;
            case R.id.n7:
                equation += "7";
                break;
            case R.id.n8:
                equation += "8";
                break;
            case R.id.n9:
                equation += "9";
                break;
            case R.id.n0:
                equation += "0";
                break;
            case R.id.btnDot:
                equation += ".";
                break;
        }

        TextView resultView = (TextView) findViewById(R.id.txt01);
        resultView.setText(equation);

    }

    public void resetResult(View v) {
        equation = "";
        TextView resultView = (TextView) findViewById(R.id.txt01);
        resultView.setText("");
    }

    public void calculate(View v) {

        Evaluator evaluator = new Evaluator();

        TextView resultView = (TextView) findViewById(R.id.txt01);
        equation = resultView.getText().toString();

        String resultString = null;
        try {
            resultString = evaluator.evaluate(equation);
            equation = resultString;
        } catch (EvaluationException e) {
            resultString = "ป้อนข้อมูลไม่ถูกต้อง" + e;
            equation = "0";
        }

        resultView.setText(resultString);
    }
}
