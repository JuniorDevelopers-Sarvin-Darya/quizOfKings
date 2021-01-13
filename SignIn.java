package com.example.quizofkings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Scanner;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }

    public static Scanner s = new Scanner(System.in);
    public static String username[] = new String[100000];
    public static String password[] = new String[100000];

     System.out.println("Enter username:");
    String user = s.next();
        System.out.println("Enter password:");
    String pass = s.next();
    Boolean find = false;
        for(int i = 0;i<username.length;i++)
    {
        if (user.equals(username[i]) && pass.equals(password[i])) {
            find = true;
            if (!find) {
                System.out.println("The incorrect username or password!");


            }
        }
    }


}





