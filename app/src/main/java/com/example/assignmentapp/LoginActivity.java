package com.example.assignmentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login);

        TextView username = (TextView) findViewById(R.id.username);

        TextView password = (TextView) findViewById(R.id.password);

        Button loginbtn = (Button) findViewById(R.id.loginbtn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (username.getText().toString().equals("admin") && password.getText().toString().equals("1234"))
                {
                    Intent loginintent = new Intent(LoginActivity.this,DrawerActivity.class);
                    startActivity(loginintent);
                    finish();
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Incorrect Username & Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
