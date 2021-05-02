package com.example.newsapp;

import android.net.UrlQuerySanitizer;

public class News {
    String author;
    String title;
    String url;
    String imageUrl;
    public News ( String author,String title,String url,String imageUrl) {
       this.author=author;
        this.title = title;
        this.url =url;
        this.imageUrl=imageUrl;
    }
    
}
