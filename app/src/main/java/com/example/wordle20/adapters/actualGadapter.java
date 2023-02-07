package com.example.wordle20.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wordle20.R;
import com.example.wordle20.gs.game;

import java.util.ArrayList;
import java.util.List;

public class actualGadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<String> players;
    int attempted;
    game Game;

    public actualGadapter(game Game, List<String> players, int attempted){
        this.players = players;
        this.attempted = attempted;
        this.Game = Game;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_actual_g, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if(attempted  >= 4)return 0;
        return 4 - attempted;
    }


    public class Viewholder extends RecyclerView.ViewHolder{

        EditText L1,L2,L3,L4,L5;
        List<EditText> letters;
        public Viewholder(@NonNull View itemView) {
            super(itemView);


            String currWord = Game.getCurrWord();
            if(currWord.contains(L1.getText().toString())){
                L1.setBackgroundColor();
            }
        }
    }
}
