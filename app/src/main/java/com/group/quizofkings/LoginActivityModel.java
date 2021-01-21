package com.group.quizofkings;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.Semaphore;

public class LoginActivityModel
{

    public boolean isValidUsername(String username)  {

        ValidationForLogin v = new ValidationForLogin("usernameRequest", username);
        Thread t = new Thread(v);

        synchronized (t)
        {
            t.start();
            try {
                t.join(1000);
            }catch (Exception e)
            {
                ////////-/-/-/-/-/-
            }
            return v.getResult();
        }

    }

    public boolean isValidPassword(String password)
    {
        ValidationForLogin v = new ValidationForLogin("passwordRequest", password);
        Thread t = new Thread(v);
        synchronized (t)
        {
            t.start();
            try {
                t.join(1000);
            }catch (Exception e)
            {
                /////////////////////
            }
            return v.getResult();
        }
    }

    public boolean isValidPasswordConfirmation(String pass1, String pass2)
    {
        return pass1.equals(pass2);
    }
    private class ValidationForLogin implements Runnable
    {
        private String task;
        private String value;
        private Socket socket;
        private ObjectInputStream ois;
        private ObjectOutputStream oos;
        private boolean res;
        public ValidationForLogin(String task, String value)
        {
            try {
                this.task = task;
                this.value = value;
            }catch (Exception e)
            {
                e.printStackTrace();
            }

        }

        @Override
        public void run() {
            try {

                this.socket = new Socket("10.0.2.2", 1212);
                this.oos = new ObjectOutputStream(socket.getOutputStream());
                this.ois = new ObjectInputStream(socket.getInputStream());
                oos.writeUTF("login" + " " + task + " " + value);
                oos.flush();
                String serverResponse = ois.readUTF();
                if (serverResponse.equals("true"))
                    res = true;
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        public boolean getResult()
        {
            return res;
        }
    }
}
