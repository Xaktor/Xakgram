package com.example.xakgram;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    final private String TAG= "LoginActivity";
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Directly go to the main activity if signed in
        if(ParseUser.getCurrentUser()!=null){
            goMainActivity();
        }

        etUsername = findViewById(R.id.username);
        etPassword = findViewById(R.id.password);
        btnLogin=findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"onClick login button");
                String username=etUsername.getText().toString();
                String password=etPassword.getText().toString();
                Toast.makeText(LoginActivity.this, "Login", Toast.LENGTH_SHORT);
                loginUser(username,password);
            }
        });
        /*Log.i(TAG,"onClick login button");
        String username=etUsername.getText().toString();
        String password=etPassword.getText().toString();
        Toast.makeText(LoginActivity.this, "Login", Toast.LENGTH_SHORT);
        loginUser(username,password);*/
    }

    private void loginUser(String username, String password){
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e!=null){
                    Log.e(TAG, "Issue with login", e);
                    return;
                }
                goMainActivity();
                Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_SHORT);
            }
        });
    }

    private void goMainActivity() {
        Intent i =new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}