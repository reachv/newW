package com.example.wordle20.gs;

import com.parse.Parse;
import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.util.List;
import java.util.Map;

@ParseClassName("friends")
public class friendsGS extends ParseObject {
    public friendsGS(){}

    //getters
    public String getSender(){
        return getString("sender");
    }
    public String getReciever(){
        return getString("receiver");
    }

    //setters
    public void setSender(String x){
        put("sender", x);
    }
    public void setReciever(String x){
        put("receiver", x);
    }
}
