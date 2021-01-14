package com.group.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class RegisterViaLoginActivity extends AppCompatActivity {
    private EditText userNameEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;
    private TextView nameError;
    private TextView passwordError;
    private TextView confirmPasswordError;
    private Button okBtn;
    private String task;

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

        Bundle bundle = getIntent().getExtras();
        task = bundle.getString("work");


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



    private boolean validation(String kind, String value)
    {
        try {
            Validation validation = new Validation(kind, value);
            Thread thread = new Thread(validation);
            thread.start();
            thread.join();
            return validation.getResult();
        }catch (Exception e)
        {

        }
        return false;
    }

    private boolean isValidUserName(String username) {
        return validation("username", username);

    }

    private boolean isValidPassword(String password) {
        return validation("password", password);
    }
    private boolean isValidPasswordConfirmation(String password1, String password2) {
        return validation("confirmPassword", password1 + "@" + password2);
    }



    private class Validation implements Runnable
    {
        private Socket s;
        private DataInputStream dis;
        private DataOutputStream dos;
        private String value;
        private String kind;
        private boolean result;

        public Validation(String kind, String value)
        {
            this.kind = kind;
            this.value = value;
            this.result = false;
        }
        @Override
        public void run() {
            try {
                s = new Socket("10.0.2.2", 1212);
                dis = new DataInputStream(s.getInputStream());
                dos = new DataOutputStream(s.getOutputStream());
                dos.writeUTF(kind + " " + value);
                String serverResponse = dis.readUTF();
                if(serverResponse.equals("true"))
                    result = true;


            }catch (Exception e)
            {

            }
        }
        public boolean getResult()
        {
            return result;
        }
    }

}