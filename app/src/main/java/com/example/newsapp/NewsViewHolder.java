package com.example.newsapp;

import android.icu.text.CaseMap;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

public class NewsViewHolder extends RecyclerView.ViewHolder {
    TextView txtView = (TextView) itemView.findViewById(R.id.title);
    public NewsViewHolder(@NonNull View item) {
        super(item);
    }
}
