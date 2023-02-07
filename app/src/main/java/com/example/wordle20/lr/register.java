package com.example.wordle20.lr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.Toast;

import com.example.wordle20.MainActivity;
import com.example.wordle20.R;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.util.ArrayList;
import java.util.List;

public class register extends AppCompatActivity {

    //Variable Declaration
    EditText user, pass;
    Button ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Variable Binding
        user = findViewById(R.id.rUsername);
        pass = findViewById(R.id.rPassword);
        ans = findViewById(R.id.rReg);

        //New User setup
        ParseUser nuser = new ParseUser();
        nuser.setUsername(user.getText().toString());
        nuser.setPassword(user.getText().toString());
        nuser.put("friends", new ArrayList<String>());

        //User Registeration
        ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nuser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e != null){
                            Log.e("register", e.toString());
                            Toast.makeText(register.this, "registery failed", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        ParseUser.logInInBackground(user.getText().toString(), pass.getText().toString(), new LogInCallback() {
                            @Override
                            public void done(ParseUser user, ParseException e) {
                                if(e != null){
                                    Log.e("register Login", e.toString());
                                    Toast.makeText(register.this, "Failed authentication", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                                goMainActivity();
                            }
                        });
                    }
                });
            }
        });


    }

    private void goMainActivity() {
        Intent i = new Intent(register.this, MainActivity.class);
        startActivity(i);
    }
}