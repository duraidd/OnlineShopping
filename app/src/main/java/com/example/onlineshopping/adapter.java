package com.example.onlineshopping;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.holder> {
    Context context;
ArrayList<model> itemcontent;

    public adapter(Context context, ArrayList<model> itemcontent) {
        this.context = context;
        this.itemcontent = itemcontent;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content,parent,false);
        return new holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {

        Log.e("1212121212",itemcontent.get(position).getImage());
       model list = itemcontent.get(position);
       holder.name.setText(itemcontent.get(position).getName());
       holder.price.setText(itemcontent.get(position).getPrice());
        Glide
                .with(context)
                .load(itemcontent.get(position).getImage())
                .centerCrop()
                .into(holder.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i = new Intent(context,FullViewActivity.class);
            i.putExtra("fullname",list.getName());
            i.putExtra("fullprice",list.getPrice());
            i.putExtra("fullimage",list.getImage());
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemcontent.size();
    }

    public class holder extends RecyclerView.ViewHolder {

        TextView name,price;
        ImageView image;

        public holder(@NonNull View itemView) {
            super(itemView);
            name =itemView.findViewById(R.id.name);
            price=itemView.findViewById(R.id.price);
            image=itemView.findViewById(R.id.imageView);
        }
    }
}
