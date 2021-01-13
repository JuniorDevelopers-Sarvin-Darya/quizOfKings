package com.example.quizofkings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public static String username[] = new String[100000];
    public static String password[] = new String[100000];
    public static int usersCounter = 0;


            System.out.println("Enter username:");
    String str = s.next();
    Boolean next = true;
        for (int i = 0; i < username.length; i++) {
        if (str.equals(username[i])) {
            System.err.println("This username isn't available!");
            next = false;
            break;
        }
    }
        if (next == true) {
        username[usersCounter] = str;
        Boolean correctpass = false;
        while (!correctpass) {
            System.out.println("Enter password:");
            password[usersCounter] = s.next();
            for (int j = 0; j < password[usersCounter].length(); j++) {
                if (password[usersCounter].charAt(j) >= 65 && password[usersCounter].charAt(j) <= 90) {
                    correctpass = true;
                }
            }
            if (!correctpass) {
                System.out.println("The password should contains at least one Capital letter!");
            }
        }
}