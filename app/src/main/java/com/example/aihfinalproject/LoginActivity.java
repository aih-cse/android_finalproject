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

public class LoginActivity extends AppCompatActivity {


    private EditText login_email, login_password;
    private Button login_bt;
    private TextView create_account;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar));
        window.setNavigationBarColor(ContextCompat.getColor(this, R.color.status_bar));

        login_email = findViewById(R.id.login_email);
        login_password = findViewById(R.id.login_password);
        login_bt = findViewById(R.id.login_bt);
        create_account = findViewById(R.id.create_account);


        login_password.setOnTouchListener(new View.OnTouchListener() {
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


        login_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = login_email.getText().toString();
                String password = login_password.getText().toString();

                if (email.isEmpty()) {
                    Toast.makeText(getBaseContext(), "يجب عليك ادخال الايميل!", Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty()) {
                    Toast.makeText(getBaseContext(), "يجب عليك ادخال كلمة المرور!", Toast.LENGTH_SHORT).show();
                } else {
                    if (!email.endsWith("@gmail.com")) {
                        Toast.makeText(getBaseContext(), "يجب ان ينتهي الايميل ب gmail.com@", Toast.LENGTH_SHORT).show();
                    } else {
                        Log.d("Login Run", "Login Operation Started.");
                        if (email.equals("aih@gmail.com") && password.equals("aih123")) {
                            Toast.makeText(getBaseContext(), "تم تسجيل الدخوال بنجاح", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getBaseContext(), MainActivity.class));
                        } else {
                            Toast.makeText(getBaseContext(), "الايميل او كلمة المرور غير صحيحة", Toast.LENGTH_LONG).show();
                        }

                    }
                }
            }
        });


        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), SignupActivity.class));
            }
        });

        Log.d("Title", "Print In Console.");


    }


    private void togglePasswordVisibility() {
        // Toggle between showing and hiding the password
        if (login_password.getInputType() == (android.text.InputType.TYPE_CLASS_TEXT | android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD)) {
            login_password.setInputType(android.text.InputType.TYPE_CLASS_TEXT | android.text.InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
//            login_password.setSelection(0); // Move cursor to end
            login_password.setCompoundDrawablesWithIntrinsicBounds(R.drawable.seen_on_icon, 0, R.drawable.password_icon, 0);
//            login_password.setSelection(login_password.length()); // Move cursor to end
        } else {
            login_password.setInputType(android.text.InputType.TYPE_CLASS_TEXT | android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD);
//            login_password.setSelection(0); // Move cursor to end
            login_password.setCompoundDrawablesWithIntrinsicBounds(R.drawable.seen_icon, 0, R.drawable.password_icon, 0);
//            login_password.setSelection(login_password.length()); // Move cursor to end

        }
    }


}