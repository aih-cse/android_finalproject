package com.example.aihfinalproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignupActivity extends AppCompatActivity {

    private EditText signup_username, signup_email, signup_password;
    private Button signup_bt;
    private TextView login;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar));
        window.setNavigationBarColor(ContextCompat.getColor(this, R.color.status_bar));

        signup_username = findViewById(R.id.signup_username);
        signup_email = findViewById(R.id.signup_email);
        signup_password = findViewById(R.id.signup_password);
        signup_bt = findViewById(R.id.signup_bt);
        login = findViewById(R.id.login);


        signup_password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    final TextView textView = (TextView) v;
                    if (event.getX() >= 10 && event.getX() < 120) {
//                    if(event.getX() >= textView.getWidth() - textView.getCompoundPaddingEnd()) {
                        togglePasswordVisibility();
                        return true;
                    }
                }
                return false;
            }
        });


        signup_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = signup_username.getText().toString();
                String email = signup_email.getText().toString();
                String password = signup_password.getText().toString();

                if (username.isEmpty()) {
                    Toast.makeText(getBaseContext(), "يجب عليك ادخال اسم المستخدم!", Toast.LENGTH_SHORT).show();
                } else if (email.isEmpty()) {
                    Toast.makeText(getBaseContext(), "يجب عليك ادخال الايميل!", Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty()) {
                    Toast.makeText(getBaseContext(), "يجب عليك ادخال كلمة المرور!", Toast.LENGTH_SHORT).show();
                } else {
                    if (!email.endsWith("@gmail.com")) {
                        Toast.makeText(getBaseContext(), "يجب ان ينتهي الايميل ب gmail.com@", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getBaseContext(), "تم انشاء حساب جديد", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getBaseContext(), MainActivity.class));
                    }

                }
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), LoginActivity.class));
            }
        });


    }

    private void togglePasswordVisibility() {
        // Toggle between showing and hiding the password
        if (signup_password.getInputType() == (android.text.InputType.TYPE_CLASS_TEXT | android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD)) {
            signup_password.setInputType(android.text.InputType.TYPE_CLASS_TEXT | android.text.InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
//            login_password.setSelection(0); // Move cursor to end
            signup_password.setCompoundDrawablesWithIntrinsicBounds(R.drawable.seen_on_icon, 0, R.drawable.password_icon, 0);
//            login_password.setSelection(login_password.length()); // Move cursor to end
        } else {
            signup_password.setInputType(android.text.InputType.TYPE_CLASS_TEXT | android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD);
//            login_password.setSelection(0); // Move cursor to end
            signup_password.setCompoundDrawablesWithIntrinsicBounds(R.drawable.seen_icon, 0, R.drawable.password_icon, 0);
//            login_password.setSelection(login_password.length()); // Move cursor to end

        }
    }


}