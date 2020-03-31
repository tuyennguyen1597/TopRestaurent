package com.example.topres;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private static final String TAG = "MyAdapter";
    ArrayList<String> resNames = new ArrayList<>();
    ArrayList<Double> resRates = new ArrayList<>();
    int[] images;
    Context context;
    RecyclerClickListener listener;
    public MyAdapter( Context context, ArrayList<String> resNames, ArrayList<Double> resRates, int[] images, RecyclerClickListener listener) {
        this.resNames = resNames;
        this.resRates = resRates;
        this.context = context;
        this.images = images;
        this.listener = listener;
    }

    public interface RecyclerClickListener {
        void onClick(View v, int position);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.res_list, parent, false);
        ViewHolder holder = new ViewHolder(view, listener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        holder.resNameL.setText(resNames.get(position));
        //holder.resRateL.setText(String.valueOf(resRates.get(position)));
        holder.resImgL.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return resNames.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView resNameL, resRateL;
        ImageView resImgL;
        ConstraintLayout parentL;
        RecyclerClickListener listener;
        public ViewHolder(@NonNull View itemView, RecyclerClickListener listener) {
            super(itemView);
            this.resNameL = itemView.findViewById(R.id.resNameL);
            //this.resRateL = itemView.findViewById(R.id.resRateL);
            this.resImgL = itemView.findViewById(R.id.resImgL);
            this.parentL = itemView.findViewById(R.id.parentL);
            itemView.setOnClickListener(this);
            this.listener = listener;
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v, getAdapterPosition());
        }
    }
}
