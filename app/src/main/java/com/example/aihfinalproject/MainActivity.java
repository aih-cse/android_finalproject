package com.example.aihfinalproject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    Button home_btn, cart_btn, my_lib_btn, user_btn;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar));
        window.setNavigationBarColor(ContextCompat.getColor(this, R.color.status_bar));


        home_btn = findViewById(R.id.home_btn);
        cart_btn = findViewById(R.id.cart_btn);
        my_lib_btn = findViewById(R.id.my_lib_btn);
        user_btn = findViewById(R.id.user_btn);

        HomeFragment fragment = new HomeFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, fragment);
        ft.commit();


        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeButtonsStyle(true, false, false, false);
                HomeFragment fragment = new HomeFragment();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_container, fragment);
                ft.commit();
            }
        });

        cart_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeButtonsStyle(false, true, false, false);
                CartFragment fragment = new CartFragment();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_container, fragment);
                ft.commit();
            }
        });

        my_lib_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeButtonsStyle(false, false, true, false);
                MyLibFragment fragment = new MyLibFragment();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_container, fragment);
                ft.commit();
            }
        });

        user_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeButtonsStyle(false, false, false, true);
                ProfileFragment fragment = new ProfileFragment();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_container, fragment);
                ft.commit();
            }
        });


    }


    private void changeButtonsStyle(boolean home_enable, boolean cart_enable, boolean lib_enable, boolean user_enable) {
        home_btn.setTextColor(getColor(R.color.gray));
        home_btn.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.home_icon, 0, 0);
        cart_btn.setTextColor(getColor(R.color.gray));
        cart_btn.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.cart_icon, 0, 0);
        my_lib_btn.setTextColor(getColor(R.color.gray));
        my_lib_btn.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.my_lib_icon, 0, 0);
        user_btn.setTextColor(getColor(R.color.gray));
        user_btn.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.user_icon_gray, 0, 0);

        if (home_enable) {
            home_btn.setTextColor(getColor(R.color.status_bar));
            home_btn.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.home_icon_green, 0, 0);
        } else if (cart_enable) {
            cart_btn.setTextColor(getColor(R.color.status_bar));
            cart_btn.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.cart_icon_green, 0, 0);
        } else if (lib_enable) {
            my_lib_btn.setTextColor(getColor(R.color.status_bar));
            my_lib_btn.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.my_lib_icon_green, 0, 0);
        } else if (user_enable) {
            user_btn.setTextColor(getColor(R.color.status_bar));
            user_btn.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.user_icon_green, 0, 0);
        }

    }


}