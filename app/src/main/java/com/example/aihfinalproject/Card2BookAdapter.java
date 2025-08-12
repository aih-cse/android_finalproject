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

public class Card2BookAdapter extends RecyclerView.Adapter<Card2BookAdapter.CardBookViewHolder> {

    ArrayList<Book> books = new ArrayList<>();

    public Card2BookAdapter(ArrayList<Book> books) {
        this.books = books;
    }

    @NonNull
    @Override
    public CardBookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_book_new, parent, false);
        CardBookViewHolder viewHolder = new CardBookViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardBookViewHolder holder, int position) {

        Book book = books.get(position);
        holder.title.setText(book.getTitle());
        holder.author.setText((book.getAuthor()));
        holder.image.setImageResource(book.getImage());


    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    class CardBookViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title, author;

        public CardBookViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image_card_2);
            title = itemView.findViewById(R.id.title_card_2);
            author = itemView.findViewById(R.id.author_card_2);

        }
    }
}
