package com.example.ex9;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    SharedPreferences newPreference;
    Intent newIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView result = findViewById(R.id.res_text);
        Button LogOut_btn = findViewById(R.id.LogOut);
        newPreference = getSharedPreferences("details", MODE_PRIVATE);
        newIntent = new Intent(SecondActivity.this, MainActivity.class);
        result.setText("Welcome, " + newPreference.getString("username",null));

        LogOut_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor edit = newPreference.edit();
                edit.clear();
                edit.commit();
                startActivity(newIntent);
            }
        });
    }
}