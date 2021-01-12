package com.group.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button loginBtn;
    private Button registerBtn;
    private Button guestBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginBtn = findViewById(R.id.login_btn);
        registerBtn = findViewById(R.id.register_btn);
        guestBtn = findViewById(R.id.guest_btn);
        loginBtn.setOnClickListener(new LoginListener());
        registerBtn.setOnClickListener(new RegisterListener());
        guestBtn.setOnClickListener(new GuestListener());
    }
    private class LoginListener implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, RegisterViaLoginActivity.class);
            intent.putExtra("work", "login");
            startActivity(intent);
        }
    }
    private class RegisterListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, RegisterViaLoginActivity.class);
            intent.putExtra("work", "register");
            startActivity(intent);
        }
    }
    private class GuestListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, GamePageActivity.class);
            intent.putExtra("work", "guest");
            startActivity(intent);
        }
    }
}