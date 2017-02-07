package com.example.houshuai.textdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.houshuai.textdemo.custom.CustomActivity;
import com.example.houshuai.textdemo.manager.RecycleActivity;
import com.example.houshuai.textdemo.picture.PicActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button number1 = (Button) findViewById(R.id.btn_number_1);
        Button number2 = (Button) findViewById(R.id.btn_number_2);
        Button number3 = (Button) findViewById(R.id.btn_number_3);
        Button number4 = (Button) findViewById(R.id.btn_number_4);
        number1.setOnClickListener(this);
        number2.setOnClickListener(this);
        number3.setOnClickListener(this);
        number4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_number_1:
                skip(PicActivity.class);
                break;
            case R.id.btn_number_2:
                skip(RecycleActivity.class);
                break;
            case R.id.btn_number_3:
                skip(PicActivity.class);
                break;
            case R.id.btn_number_4:
                skip(CustomActivity.class);
                break;
        }
    }


    private void skip(Class name) {
        Intent intent = new Intent(this, name);
        startActivity(intent);


    }


}
