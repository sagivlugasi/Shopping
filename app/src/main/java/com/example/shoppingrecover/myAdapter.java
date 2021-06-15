package com.example.shoppingrecover;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import java.util.ArrayList;

class myAdapter extends Adapter<myAdapter.myViewHolder> {

    ArrayList<String> data;
    Context context;
    private OnItemClickListener mListener;

    public myAdapter(Context ct,  ArrayList<String> data)
    {
        context = ct;
        this.data = data;
    }
    public interface OnItemClickListener{
        void onItemClick(int position);
        void onChecklClick (int position);

    }
    public void setOnItemClickListener (OnItemClickListener listener)
    {
        mListener =  listener;
    }
    public static class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView item;
        ImageView check;


        public myViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            item = itemView.findViewById(R.id.textView);
            check = itemView.findViewById(R.id.check);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
               if( listener != null)
                    {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION)
                        {
                            listener.onItemClick(position);
                        }
                    }
                }
            });

            check.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if( listener != null)
                    {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION)
                        {
                            listener.onChecklClick( position);
                        }
                    }
                }

            });

        }

        @Override
        public void onClick(View view) {

        }
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.my_row,parent,false);
        return new myViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.item.setText(data.get(position));


    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public interface OnCheckListener{
        void OnCheckClick(int position);
    }

}
