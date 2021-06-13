package com.example.shoppingrecover;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import java.util.ArrayList;

class myAdapter extends Adapter<myAdapter.myViewHolder> {

    ArrayList<String> data;
    Context context;

    public myAdapter(Context ct,  ArrayList<String> data)
    {
        context = ct;
        this.data = data;
    }
    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView item;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.textView);
        }
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.my_row,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.item.setText(data.get(position));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}
