/*
package com.example.newsapp;


import android.content.Context;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public final class Mysingleton {
    public String s;

    Context context;
    String url;
    private static volatile Mysingleton single_instance = null;

    // variable of type String

    // private constructor restricted to this class itself
    private Mysingleton(Context context)
    {
        this.context = context;
        s = "Hello I am a string part of Singleton class";
    }

    // static method to create instance of Singleton class
    public static Mysingleton getInstance(Context context)
    {
        if (single_instance == null)
            synchronized (Mysingleton.class) {
                // single_instance = new Mysingleton();
                if (single_instance == null) {
                    single_instance = new Mysingleton(context);
                }
            }
        return single_instance;
    }

    public void addToRequestQueue(JsonObjectRequest jsonObjectRequest) {
       // RequestQueue queue = Volley.newRequestQueue(context.getApplicationContext());

        RequestQueue queue = Volley.newRequestQueue(context.getApplicationContext());


        //String Request initialized
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        });

        queue.add(request);
    }

}

*/
