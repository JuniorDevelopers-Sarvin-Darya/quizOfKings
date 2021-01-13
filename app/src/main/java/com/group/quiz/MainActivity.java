package com.group.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

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
//    private class Test extends Thread//todo
//    {
//        @Override
//        public void run() {
//            try {
//                System.out.println("connecting...please wait");
//                InetAddress address = InetAddress.getByName("10.0.2.2");
//                Socket newOperationSocket = new Socket(address, 1212);
//
//            } catch (UnknownHostException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//    private class ClientThread extends Thread
//    {
//        private Socket socket;
//        private DataInputStream dis;
//        private DataOutputStream dos;
//        public ClientThread(Socket s)
//        {
//            try {
//                this.socket = s;
//                this.dis = new DataInputStream(s.getInputStream());
//                this.dos = new DataOutputStream(s.getOutputStream());
//            }catch (Exception e)
//            {
//                System.exit(1);
//            }
//        }

//        @Override
//        public void run() {
//            while (true)
//            {
//                try {
//                    String serverMsg = dis.readUTF();
//                    if(serverMsg != null || !serverMsg.trim().equals(""))
//                        ClientHandler.handle(serverMsg, dos);
//                }catch (Exception e)
//                {
//                    System.exit(2);
//                }
//
//            }
//        }
//    }
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