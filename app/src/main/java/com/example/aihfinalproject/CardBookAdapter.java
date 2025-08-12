package com.example.aihfinalproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CardBookAdapter extends RecyclerView.Adapter<CardBookAdapter.CardBookViewHolder> {

    ArrayList<Book> books;

    public CardBookAdapter(ArrayList<Book> books) {
        this.books = books;
    }

    @NonNull
    @Override
    public CardBookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_book_header, parent, false);
        CardBookViewHolder viewholder = new CardBookViewHolder(view);

        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardBookViewHolder holder, int position) {

        Book book = books.get(position);
        holder.title.setText(book.getTitle());
        holder.price.setText(book.getPrice() + "$");
        holder.author.setText(book.getAuthor());
        holder.views.setText(book.getViews() + "");
        holder.rate.setText(book.getRate() + "");
        holder.image.setImageResource(book.getImage());

    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    class CardBookViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView price, title, author, views, rate;

        public CardBookViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            price = itemView.findViewById(R.id.price);
            title = itemView.findViewById(R.id.title);
            author = itemView.findViewById(R.id.author);
            views = itemView.findViewById(R.id.views);
            rate = itemView.findViewById(R.id.rate);
        }
    }
}
