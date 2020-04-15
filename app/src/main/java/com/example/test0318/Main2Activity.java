package com.example.test0318;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle = this.getIntent().getExtras();
        String height = bundle.getString("h");
        String weight = bundle.getString("w");
        String name =bundle.getString("n");
        Toast.makeText(this, height+weight+name, Toast.LENGTH_SHORT).show();

    }
}
