package com.example.aihfinalproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView header_card_rv, new_books_rv;
    Button home_1, home_2, home_3, give_me_book_btn;

    ImageView daily_image;
    TextView daily_title, daily_author, daily_rate, daily_views, daily_reds;

    public HomeFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        header_card_rv = view.findViewById(R.id.header_card_rv);
        new_books_rv = view.findViewById(R.id.new_books_rv);

        home_1 = view.findViewById(R.id.home_1);
        home_2 = view.findViewById(R.id.home_2);
        home_3 = view.findViewById(R.id.home_3);
        give_me_book_btn = view.findViewById(R.id.give_me_book_btn);

        daily_image = view.findViewById(R.id.daily_image);
        daily_title = view.findViewById(R.id.daily_title);
        daily_author = view.findViewById(R.id.daily_author);
        daily_rate = view.findViewById(R.id.daily_rate);
        daily_views = view.findViewById(R.id.daily_views);
        daily_reds = view.findViewById(R.id.daily_reds);


/************************************************************** When Home Page Start **************************************************************/

        String[] titles = new String[]{
                "أمواج في ليلة مظلمة", "أنا والليل وأفكاري", "حيث تركت روحي", "الحب من اول نقرة",
                "العقل النشط", "مهمة السيدة علية", "تنشيط العقل", "ما وراء الطبيعة"
        };
        String[] authors = new String[]{
                "أحمد أشرف", "سارة أحمد", "حيزوم روحي", "حيزوم روحي",
                "حيزوم روحي", "مارك الن", "حيزوم روحي", "مارك الن"
        };
        float[] rates = new float[]{4.2f, 3.5f, 4.2f, 3.5f, 4.2f, 3.5f, 4.2f, 3.5f};
        int[] views = new int[]{2500, 2365, 2500, 2365, 2500, 2365, 2500, 2365};
        int[] reads = new int[]{1520, 1039, 1520, 1039, 1520, 1039, 1520, 1039};
        float[] prices = new float[]{9.99f, 29.99f, 9.99f, 29.99f, 9.99f, 29.99f, 9.99f, 29.99f};
        int[] quantities = new int[]{100, 70, 100, 70, 100, 70, 100, 70};
        String[] descriptions = new String[]{"", "", "", "", "", "", "", ""};
        int[] images = new int[]{
                R.drawable.book_1, R.drawable.book_2, R.drawable.book_3, R.drawable.book_4,
                R.drawable.book_5, R.drawable.book_6, R.drawable.book_7, R.drawable.book_8
        };
        ArrayList<Book> books1 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Book b = new Book();
            b.setId(100 + i);
            b.setTitle(titles[i]);
            b.setAuthor(authors[i]);
            b.setRate(rates[i]);
            b.setViews(views[i]);
            b.setReads(reads[i]);
            b.setPrice(prices[i]);
            b.setQuantity(quantities[i]);
            b.setDescription(descriptions[i]);
            b.setImage(images[i]);
            books1.add(b);
        }
        CardBookAdapter adapter = new CardBookAdapter(books1);
        LinearLayoutManager lm = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        header_card_rv.setHasFixedSize(true);
        header_card_rv.setLayoutManager(lm);
        header_card_rv.setAdapter(adapter);

        /*--------------------------------------------------------------------------------------------*/

        ArrayList<Book> books2 = new ArrayList<>();
        for (int i = 2; i < 8; i++) {
            Book b = new Book();
            b.setId(100 + i);
            b.setTitle(titles[i]);
            b.setAuthor(authors[i]);
            b.setRate(rates[i]);
            b.setViews(views[i]);
            b.setReads(reads[i]);
            b.setPrice(prices[i]);
            b.setQuantity(quantities[i]);
            b.setDescription(descriptions[i]);
            b.setImage(images[i]);
            books2.add(b);
        }
        Card2BookAdapter adapter2 = new Card2BookAdapter(books2);
        GridLayoutManager lm2 = new GridLayoutManager(getContext(), 2);
        new_books_rv.setHasFixedSize(true);
        new_books_rv.setLayoutManager(lm2);
        new_books_rv.setAdapter(adapter2);


/***************************************************************************************************************************************************/

/************************************************************ When Home Button 1 Click *************************************************************/


        home_1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
                ArrayList<Book> books3 = new ArrayList<>();
                for (int i = 0; i < 2; i++) {
                    Book b = new Book();
                    b.setId(100 + i);
                    b.setTitle(titles[i]);
                    b.setAuthor(authors[i]);
                    b.setRate(rates[i]);
                    b.setViews(views[i]);
                    b.setReads(reads[i]);
                    b.setPrice(prices[i]);
                    b.setQuantity(quantities[i]);
                    b.setDescription(descriptions[i]);
                    b.setImage(images[i]);
                    books3.add(b);
                }
                CardBookAdapter adapter = new CardBookAdapter(books3);
                LinearLayoutManager lm = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
                header_card_rv.setHasFixedSize(true);
                header_card_rv.setLayoutManager(lm);
                header_card_rv.setAdapter(adapter);

                adapter.notifyDataSetChanged();

                home_1.setBackgroundResource(R.drawable.home_buttons_on_click);
                home_1.setTextColor(Color.parseColor("#363636"));

                home_2.setBackgroundResource(R.drawable.home_buttons);
                home_2.setTextColor(Color.parseColor("#7A7A7A"));

                home_3.setBackgroundResource(R.drawable.home_buttons);
                home_3.setTextColor(Color.parseColor("#7A7A7A"));


            }
        });

/***************************************************************************************************************************************************/

/************************************************************ When Home Button 2 Click *************************************************************/

        home_2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
                ArrayList<Book> books3 = new ArrayList<>();
                for (int i = 2; i < 4; i++) {
                    Book b = new Book();
                    b.setId(100 + i);
                    b.setTitle(titles[i]);
                    b.setAuthor(authors[i]);
                    b.setRate(rates[i]);
                    b.setViews(views[i]);
                    b.setReads(reads[i]);
                    b.setPrice(prices[i]);
                    b.setQuantity(quantities[i]);
                    b.setDescription(descriptions[i]);
                    b.setImage(images[i]);
                    books3.add(b);
                }
                CardBookAdapter adapter = new CardBookAdapter(books3);
                LinearLayoutManager lm = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
                header_card_rv.setHasFixedSize(true);
                header_card_rv.setLayoutManager(lm);
                header_card_rv.setAdapter(adapter);

                adapter.notifyDataSetChanged();

                home_1.setBackgroundResource(R.drawable.home_buttons);
                home_1.setTextColor(Color.parseColor("#7A7A7A"));

                home_2.setBackgroundResource(R.drawable.home_buttons_on_click);
                home_2.setTextColor(Color.parseColor("#363636"));

                home_3.setBackgroundResource(R.drawable.home_buttons);
                home_3.setTextColor(Color.parseColor("#7A7A7A"));


            }
        });


/***************************************************************************************************************************************************/

/************************************************************ When Home Button 3 Click *************************************************************/

        home_3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
                ArrayList<Book> books3 = new ArrayList<>();
                for (int i = 4; i < 6; i++) {
                    Book b = new Book();
                    b.setId(100 + i);
                    b.setTitle(titles[i]);
                    b.setAuthor(authors[i]);
                    b.setRate(rates[i]);
                    b.setViews(views[i]);
                    b.setReads(reads[i]);
                    b.setPrice(prices[i]);
                    b.setQuantity(quantities[i]);
                    b.setDescription(descriptions[i]);
                    b.setImage(images[i]);
                    books3.add(b);
                }
                CardBookAdapter adapter = new CardBookAdapter(books3);
                LinearLayoutManager lm = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
                header_card_rv.setHasFixedSize(true);
                header_card_rv.setLayoutManager(lm);
                header_card_rv.setAdapter(adapter);

                adapter.notifyDataSetChanged();

                home_1.setBackgroundResource(R.drawable.home_buttons);
                home_1.setTextColor(Color.parseColor("#7A7A7A"));

                home_2.setBackgroundResource(R.drawable.home_buttons);
                home_2.setTextColor(Color.parseColor("#7A7A7A"));

                home_3.setBackgroundResource(R.drawable.home_buttons_on_click);
                home_3.setTextColor(Color.parseColor("#363636"));


            }
        });


/***************************************************************************************************************************************************/


        give_me_book_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), SuggestedBook.class));
            }
        });


        return view;
    }


}