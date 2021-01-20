package com.group.quizofkings;

import java.io.IOException;
import java.io.ObjectInputStream;
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

    public void sendRequestToCreateUser(String username, String password) {
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
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            oos.writeUTF("username_validation " + username);
            oos.flush();
            String response = ois.readUTF();
            if(response.equals("true"))
                System.out.println("finished with exit code 0! :)");
            System.out.println("finished");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
