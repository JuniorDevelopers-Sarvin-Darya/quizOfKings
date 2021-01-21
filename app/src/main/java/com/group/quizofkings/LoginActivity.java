package com.group.quizofkings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.InetAddress;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private EditText passwordConfirmationEditText;
    private Button loginCompleteBtn;
    private LoginActivityModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameEditText = findViewById(R.id.login_username_edit_text);
        passwordEditText = findViewById(R.id.login_password_edit_text);
        passwordConfirmationEditText = findViewById(R.id.login_confirm_password_edit_text);
        loginCompleteBtn = findViewById(R.id.login_complete_btn);
        loginCompleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(model.isValidUsername(usernameEditText.getText().toString()) && model.isValidPassword(passwordEditText.getText().toString()) &&
                model.isValidPasswordConfirmation(passwordConfirmationEditText.getText().toString(), passwordEditText.getText().toString()))
                {
                    Intent intent = new Intent(LoginActivity.this, GameActivity.class);

                    startActivity(intent);
                }
            }
        });

    }
}