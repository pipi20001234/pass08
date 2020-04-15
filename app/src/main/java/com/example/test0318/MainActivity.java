package com.example.test0318;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    private EditText name;
    private EditText height;
    private EditText weight;
    private ImageView im;
    private TextView b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.ed_name);
        height = (EditText) findViewById(R.id.ed_heigh);
        weight = (EditText) findViewById(R.id.ed_weight);
        im = findViewById(R.id.imageView2);
        b = findViewById(R.id.textView);
    }

    public void show(View view) {

        weight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        String h = height.getText().toString();
        String w = weight.getText().toString();
        double bmi = Double.parseDouble(w) / (Double.parseDouble(h) / 100.0 * Double.parseDouble(h) / 100.0);
        DecimalFormat df = new DecimalFormat("#.##");
        b.setText(name.getText().toString() + "您的BMI是" + df.format(bmi));

        String msg = "";
        if (bmi < 18.5) {
            msg = "過輕";
            im.setImageResource(R.drawable.kevin);
        } else if (bmi > 25) {
            msg = "過重";
            im.setImageResource(R.drawable.small);
        } else {
            msg = "標準";
            im.setImageResource(R.drawable.grand);
        }
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
        b.setText(name.getText().toString() + "您的BMI是" + df.format(bmi));
    }

    public void nextpage(View view) {
        String h = height.getText().toString();
        String w = weight.getText().toString();
        String n = name.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("height",h);
        bundle.putString("weight",w);
        bundle.putString("name",n);

        Intent i = new Intent(this, Main2Activity.class);
        i.putExtras(bundle);
        startActivity(i);
    }
}








