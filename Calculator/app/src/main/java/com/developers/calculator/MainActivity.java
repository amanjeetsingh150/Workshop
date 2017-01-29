package com.developers.calculator;

import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button addition,subtract,multiply,divide;
    private EditText first,second;
    private String firstnum,secondnum;
    private float fnum,secnum;
    private TextView sol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addition= (Button) findViewById(R.id.add);
        subtract= (Button) findViewById(R.id.sub);
        multiply= (Button) findViewById(R.id.multi);
        divide=(Button)findViewById(R.id.div);
        sol= (TextView) findViewById(R.id.answer);
        first= (EditText) findViewById(R.id.firstnumber);
        second= (EditText) findViewById(R.id.secondnumber);
        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    firstnum = first.getText().toString();
                    fnum = Integer.parseInt(firstnum);
                    secondnum = second.getText().toString();
                    secnum = Float.parseFloat(secondnum);
                    float addsol = fnum + secnum;
                    sol.setText("Sol: "+String.valueOf(addsol));
                }
                catch (Exception e){
                    e.printStackTrace();
                    sol.setText("Exeption occured: "+e.toString());
                }
            }
        });
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    firstnum=first.getText().toString();
                    fnum=Integer.parseInt(firstnum);
                    secondnum=second.getText().toString();
                    secnum=Integer.parseInt(secondnum);
                    float subsol=fnum-secnum;
                    sol.setText("Sol: "+String.valueOf(subsol));
                }
                catch (Exception e){
                    e.printStackTrace();
                    sol.setText("Exception occured: "+e.toString());
                }
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    firstnum=first.getText().toString();
                    fnum=Integer.parseInt(firstnum);
                    secondnum=second.getText().toString();
                    secnum=Integer.parseInt(secondnum);
                    float mulsol=fnum*secnum;
                    sol.setText("Sol: "+String.valueOf(mulsol));
                }
                catch (Exception e){
                    e.printStackTrace();
                    sol.setText("Exception occured: "+e.toString());
                }

            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    firstnum=first.getText().toString();
                    fnum=Integer.parseInt(firstnum);
                    secondnum=second.getText().toString();
                    secnum=Integer.parseInt(secondnum);
                    float divsol=fnum/secnum;
                    sol.setText("Sol: "+String.valueOf(divsol));
                }
                catch (Exception e){
                    e.printStackTrace();
                    sol.setText("Exception occured: "+e.toString());
                }
            }
        });

    }
}
