import java.io.DataOutputStream;
import java.io.ObjectOutputStream;

public class ServerHandler
{
    public static void handle(String clientReq, ObjectOutputStream oos)
    {
        String[] splitReq = clientReq.split(" ");
        switch (splitReq[0])
        {
            case "login":
            {
                switch (splitReq[1])
                {
                    case "usernameRequest":
                    {
                        if(splitReq.length > 2)
                        {
                            String username = splitReq[2];
                            try {
                                if (isValidUsernameForLogin(username))
                                    oos.writeUTF("true");
                                else
                                    oos.writeUTF("false");
                            }catch (Exception e)
                            {
                                e.printStackTrace();
                            }
                        }
                    }
                    break;
                }
            }
            break;
        }
    }

    private static boolean isValidUsernameForLogin(String username)
    {
        for (User u: ServerModel.getUsers())
            if(u.getUsername().equals(username))
                return true;
            return false;
    }
}