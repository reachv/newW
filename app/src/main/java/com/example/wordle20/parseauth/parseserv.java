package com.example.wordle20.parseauth;

import android.app.Application;

import com.example.wordle20.R;
import com.parse.Parse;

public class parseserv extends Application {
    public void onCreate(){
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(getString(R.string.PARSEAPPLICATIONKEY))
                .clientKey(getString(R.string.PARSECLIENTKEY))
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
