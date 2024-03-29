package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    EditText usernametxt, passwordtxt;
    Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernametxt = findViewById(R.id.username);
        passwordtxt = findViewById(R.id.password);
        loginbtn = findViewById(R.id.loginbtn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();


            }
        });
    }

    private void login(){
        String username = usernametxt.getText().toString();
        String passwrd = passwordtxt.getText().toString();

        if(validate(username, passwrd)){
            if (username.equals("softwarica")&& passwrd.equals("coventry")){
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
            else {
                usernametxt.requestFocus();
                usernametxt.setError("username and password is incorrect");
            }

        }



    }
    private boolean validate (String username, String password){

        if (TextUtils.isEmpty(username)){
            usernametxt.setError("username cannot be empty");
            usernametxt.requestFocus();
            return  false;

        }
        if (TextUtils.isEmpty(password)){
            passwordtxt.setError("password cannot be empty");
            passwordtxt.requestFocus();
            return false;

        }

        return true;
    }
}

