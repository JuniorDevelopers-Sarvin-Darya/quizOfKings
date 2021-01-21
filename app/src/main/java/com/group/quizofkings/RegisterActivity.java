package com.group.quizofkings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private EditText passwordConfirmationEditText;
    private Button registrationCompleteBtn;

    private RegisterActivityModel model = new RegisterActivityModel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        usernameEditText = findViewById(R.id.register_username_edit_text);
        passwordEditText = findViewById(R.id.register_password_edit_text);
        passwordConfirmationEditText = findViewById(R.id.register_confirm_password_edit_text);
        registrationCompleteBtn = findViewById(R.id.registration_complete_btn);
        registrationCompleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String passwordConfirm = passwordConfirmationEditText.getText().toString();
                if(model.confirmUsername(username) && model.confirmPassword(password) &&
                model.confirmPasswordConfirmation(password, passwordConfirm))
                {
                    String user = username + " " + password;
                    Intent intent = new Intent(RegisterActivity.this, GameActivity.class);
                    intent.putExtra("user", user);
                    intent.putExtra("work", "register_user" + " " + username);
                    startActivity(intent);
                }
            }
        });
    }
}