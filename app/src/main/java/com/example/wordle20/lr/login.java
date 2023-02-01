package com.example.wordle20.lr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wordle20.MainActivity;
import com.example.wordle20.R;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class login extends AppCompatActivity {

    //Variable Declaration
    EditText user, pass;
    Button ans;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Variable Binding BIND BUTTON
        user = findViewById(R.id.lUsername);
        pass = findViewById(R.id.lPassword);
        ans = findViewById(R.id.lLog);

        //Login
        ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseUser.logInInBackground(user.getText().toString(), pass.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if(e != null){
                            Toast.makeText(login.this, "login failed", Toast.LENGTH_SHORT).show();
                            Log.e("login", "Login 31");
                            return;
                        }
                        goMainActivity();
                    }
                });
            }
        });


    }

    private void goMainActivity() {
        Intent i = new Intent(login.this, MainActivity.class);
        startActivity(i);
    }
}