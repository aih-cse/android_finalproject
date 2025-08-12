package com.example.aihfinalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MyLibFragment extends Fragment {

    RecyclerView my_books_rv, suggested_books_rv;

    public MyLibFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_lib, container, false);

        my_books_rv = view.findViewById(R.id.my_books_rv);
        suggested_books_rv = view.findViewById(R.id.suggested_books_rv);

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
        ArrayList<Book> books2 = new ArrayList<>();
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
            books2.add(b);
        }
        Card3BookAdapter adapter2 = new Card3BookAdapter(books2);
        GridLayoutManager lm2 = new GridLayoutManager(getContext(), 2);
        my_books_rv.setHasFixedSize(true);
        my_books_rv.setLayoutManager(lm2);
        my_books_rv.setAdapter(adapter2);


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
        suggested_books_rv.setHasFixedSize(true);
        suggested_books_rv.setLayoutManager(lm);
        suggested_books_rv.setAdapter(adapter);


        return view;
    }
}