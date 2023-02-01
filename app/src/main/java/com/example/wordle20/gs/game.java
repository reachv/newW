package com.example.wordle20.gs;

import com.parse.Parse;
import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.util.Map;

@ParseClassName("games")
public class game extends ParseObject {

    //Constructor
    public game(){}

    //Getters
    public Map<String, Integer> getUsers(){
        return getMap("users");
    }
    public Map<String,Integer> getScore(){
        return getMap("score");
    }
    public String getCurrWord(){
        return getString("currWord");
    }

    //Setters
    public void setUsers(Map<String, Integer> x){
        put("users", x);
    }
    public void setScore(Map<String, Integer> x){
        put("score", x);
    }
    public void setCurrWord(String x){
        put("currWord", x);
    }

}
