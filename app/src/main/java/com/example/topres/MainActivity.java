package com.example.topres;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    Restaurents restaurent = new Restaurents();
    ArrayList<String> resNames = new ArrayList<>();
    ArrayList<Double> resRates = new ArrayList<>();
    RecyclerView view;
    private int [] imgages = {R.drawable.top1, R.drawable.top2, R.drawable.top3,
        R.drawable.top4, R.drawable.top5, R.drawable.top6,
        R.drawable.top7, R.drawable.top8, R.drawable.top9, R.drawable.top10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Restaurents> restaurents = restaurent.restaurentsList();
        for (int i = 0; i < restaurents.size(); i++) {
            resNames.add(restaurents.get(i).getName());
            resRates.add(restaurents.get(i).getRating());
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        MyAdapter.RecyclerClickListener listener = new MyAdapter.RecyclerClickListener() {
            @Override
            public void onClick(View v, int position) {
                clickedResponse(position);
            }
        };
        MyAdapter adapter = new MyAdapter(this, resNames, resRates, imgages, listener);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void clickedResponse(int position) {
        Log.d(TAG, "clickedResponse: position" + position);
        Intent intent = new Intent(this, ShowRestaurent.class);
        intent.putExtra("resName", resNames.get(position));
        int top = position + 1;
        intent.putExtra("resTop", top);
        this.startActivity(intent);
    }
}
