package com.group.quizofkings;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RegisterActivityModel
{
    public boolean confirmUsername(String username)
    {
        VerifyUsername verifyUsername = new VerifyUsername(username);
        Thread t = new Thread(verifyUsername);
        t.start();
        return true;
    }

    public boolean confirmPassword(String password)
    {
        return true;
    }

    public boolean confirmPasswordConfirmation(String password, String confirmation) {
        return true;
    }

}
class VerifyUsername implements Runnable
{
    private String username;
    public VerifyUsername(String username)
    {
        this.username = username;
    }
    @Override
    public void run() {
        try {
            Socket s = new Socket("10.0.2.2", 1212);
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeUTF(username);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
