package com.example.ex9;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText username, pass;
    Button Login_Button;
    SharedPreferences Shared_pref;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.Name);
        pass = findViewById(R.id.password);
        Login_Button = findViewById(R.id.Login);
        Shared_pref = getSharedPreferences("details", MODE_PRIVATE);
        intent = new Intent(MainActivity.this, SecondActivity.class);
        if (Shared_pref.contains("username") && Shared_pref.contains("password")) {
            startActivity(intent);
        }
        Login_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = MainActivity.this.username.getText().toString();
                String password = pass.getText().toString();
                if (username.equals("Syazira") && password.equals("1234")) {
                    SharedPreferences.Editor editor = Shared_pref.edit();
                    editor.putString("username", username);
                    editor.putString("password", password);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), "Logged in", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Enter Right Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}