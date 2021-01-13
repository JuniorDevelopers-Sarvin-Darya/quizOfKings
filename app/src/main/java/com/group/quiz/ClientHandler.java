package com.group.quiz;

import java.io.DataOutputStream;
import java.io.IOException;

public class ClientHandler
{

    public static void handle(String serverMsg, DataOutputStream dos) throws IOException {
        String[] msg = serverMsg.split("@");
        switch (msg[0])
        {

        }
    }
}
