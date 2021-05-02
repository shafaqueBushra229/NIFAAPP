package com.example.newsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NewsListAdapter extends RecyclerView.Adapter<NewsViewHolder>  {
     ArrayList<News> item = new ArrayList<News>();
    NewsItemClick listner;
    public NewsListAdapter( NewsItemClick listner) {

        this.listner = listner;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent,false);
        NewsViewHolder viewHolder = new NewsViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listner.onItemClick(item, viewHolder.getAdapterPosition(),v);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
      News currentItem =  item.get(position);
       holder.txtView.setText(currentItem.title);
     
    }

    public void updateItem(ArrayList<News> updateNew){
       // ArrayList<News> updateNews = new ArrayList<News>();
        item.clear();
        item.addAll(updateNew );

        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return item.size();
    }
}
interface NewsItemClick{
      void onItemClick(ArrayList<News> item, int possition, View view);
    }
