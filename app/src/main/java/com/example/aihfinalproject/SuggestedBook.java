package com.example.aihfinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SuggestedBook extends AppCompatActivity {

    ImageButton btn_increment, btn_decrement;
    RecyclerView suggested_books_rv;
    TextView quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_suggested_book);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar));
        window.setNavigationBarColor(ContextCompat.getColor(this, R.color.status_bar));

        btn_increment = findViewById(R.id.btn_increment);
        btn_decrement = findViewById(R.id.btn_decrement);
        suggested_books_rv = findViewById(R.id.suggested_books_rv);
        quantity = findViewById(R.id.quantity);


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
        for (int i = 0; i < 5; i++) {
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
        LinearLayoutManager lm = new LinearLayoutManager(getBaseContext(), LinearLayoutManager.HORIZONTAL, false);
        suggested_books_rv.setHasFixedSize(true);
        suggested_books_rv.setLayoutManager(lm);
        suggested_books_rv.setAdapter(adapter);


        btn_increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = Integer.parseInt(quantity.getText().toString());
                if ((count + 1) > 10) {
                    Toast.makeText(getBaseContext(), "لا يجب ان يتجاوز عدد النسخ 10 نسخ", Toast.LENGTH_LONG).show();
                } else {
                    quantity.setText(String.valueOf(count + 1));
                }
            }
        });

        btn_decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = Integer.parseInt(quantity.getText().toString());
                if ((count - 1) < 1) {
                    Toast.makeText(getBaseContext(), "يجب ان يكون عدد النسخ على الأقل 1", Toast.LENGTH_LONG).show();
                } else {
                    quantity.setText(String.valueOf(count - 1));
                }
            }
        });


    }
}