package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.example.newsapp.R.layout.activity_main;
import static com.example.newsapp.R.layout.items;

public class MainActivity extends AppCompatActivity implements NewsItemClick {

    NewsListAdapter adapter;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        RecyclerView recyclerView;
        recyclerView= (RecyclerView)findViewById(R.id.res);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        fetchData();
         adapter = new NewsListAdapter(this);
        recyclerView.setAdapter(adapter);
        //RecyclerView.ViewHolder viewHolder;


    }

    private void fetchData(){

       //RequestQueue queue = Volley.newRequestQueue(this);
       // String url ="https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=b520fefb20914d4aba89ff827147beaa";

// Request a string response from the provided URL.
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, "https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=b084059d93474eb0a470e064bfba1ed0", null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                           // JSONObject newsJsonObject=(new JSONObject()).getJSONObject("articles");
                            JSONArray newsJsonArray= response.getJSONArray("articles");

                            ArrayList<News> newsArray = new ArrayList<News>();
                            for(int i =0;i<newsJsonArray.length();i++){
                                //JSONObject newsJsonObject = new JSONObject();

                                JSONObject newsJsonObject=newsJsonArray.getJSONObject(i);
                                News news = new News(newsJsonObject.getString("author"),
                                        newsJsonObject.getString("title"),
                                        newsJsonObject.getString("url"),
                                        newsJsonObject.getString("urlToImage")
                                );
                                        newsArray.add(news);
                            }
                            adapter.updateItem(newsArray);
                          //  currenturl = response.getString("url");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        // Glide.with(imageView.getContext()).load(currenturl).into(imageView);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.w("error in response", "Error: " + error.getMessage());

                    }
                });

      queue.add(jsonObjectRequest);
       // Mysingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }


    @Override
    public void onItemClick(News item) {

    }
}