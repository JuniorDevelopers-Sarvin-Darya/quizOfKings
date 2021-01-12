package com.group.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterViaLoginActivity extends AppCompatActivity {
    private EditText userNameEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;
    private TextView nameError;
    private TextView passwordError;
    private TextView confirmPasswordError;
    private Button okBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_via_login);
        userNameEditText = findViewById(R.id.nameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        confirmPasswordEditText = findViewById(R.id.passwordConfirmationEditText);
        nameError = findViewById(R.id.invalidUserNameModified);
        passwordError = findViewById(R.id.invalidPasswordModified);
        confirmPasswordError = findViewById(R.id.invalidRepeatPassword);
        okBtn = findViewById(R.id.ok_btn);
        passwordEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isValidUserName(userNameEditText.getText().toString()))
                {
                    nameError.setVisibility(View.VISIBLE);
                }
            }
        });
        confirmPasswordEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isValidPassword(passwordEditText.getText().toString()))
                {
                    passwordError.setVisibility(View.VISIBLE);
                }
            }
        });
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isValidUserName(userNameEditText.getText().toString()))
                    if(isValidPassword(passwordEditText.getText().toString()))
                        if(isValidPasswordConfirmation(passwordEditText.getText().toString(), confirmPasswordEditText.getText().toString()))
                        {
                            Intent intent = new Intent(RegisterViaLoginActivity.this, GamePageActivity.class);
                            intent.putExtra("username", userNameEditText.getText().toString());
                            intent.putExtra("password", passwordEditText.getText().toString());
                            startActivity(intent);
                        }

            }
        });


    }

    private boolean isValidPasswordConfirmation(String toString, String toString1) {
        return true;//todo
    }

    private boolean isValidUserName(String username) {
        return true;//todo

    }

    private boolean isValidPassword(String password) {
        return true;//todo
    }


}