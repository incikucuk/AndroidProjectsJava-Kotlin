package com.incikucuk.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView2);

        sharedPreferences = this.getSharedPreferences("com.incikucuk.firstapp", Context.MODE_PRIVATE);

        int storedAge = sharedPreferences.getInt("storedAge",0);
        if(storedAge==0){
            textView.setText("Your age: ");
        }else{
            textView.setText("Your age: "+storedAge);
        }

    }
    public void saveData(View view){

        if(!editText.getText().toString().matches("")){
            int age= Integer.parseInt(editText.getText().toString());

            sharedPreferences.edit().putInt("storedAge",age).apply();
            textView.setText("Your age:"+age);
        }
    }

    public void delete(View view){
        int storedData = sharedPreferences.getInt("storedAge",0);

        if(storedData != 0){
            sharedPreferences.edit().remove("storedAge").apply();
            textView.setText("Your age: ");
        }
    }
}