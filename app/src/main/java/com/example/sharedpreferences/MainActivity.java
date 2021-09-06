package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText name, email;
    Button button;
    SharedPreferences sp;
    String nameStr, emailStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editTextTextPersonName);
        email = findViewById(R.id.editTextTextPersonName2);
        sp = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);

        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                nameStr = name.getText().toString();
                emailStr = email.getText().toString();

                SharedPreferences.Editor editor = sp.edit();
                editor.putString("name", nameStr);
                editor.putString("email",emailStr);
                editor.commit();
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:

                startActivity(new Intent(this, MainActivity2.class));

                break;

        }
    }
}