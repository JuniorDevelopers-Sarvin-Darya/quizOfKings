
import java.io.*;
import java.net.*;
import java.util.Random;

public class FinalServer extends Thread {
    private static final int  PORTNUM = 1234;
    private static final int  WAITFORCLIENT = 0;
    private static final int  WAITFORANSWER = 1;
    private static final int  WAITFORCONFIRM = 2;
    private String[]          questions;
    private String[]          answers;
    private ServerSocket      serverSocket;
    private int               numQuestions;
    private int               num = 0;
    private int               state = WAITFORCLIENT;
    private Random            rand = new Random(System.currentTimeMillis());

    public FinalServer() {
        super("FinalServer");
        try {
            serverSocket = new ServerSocket(PORTNUM);
            System.out.println("Start");
        }
        catch (IOException e) {
            System.err.println("Error");
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        FinalServer server = new FinalServer();
        server.start();
    }

    public void run() {
        Socket  clientSocket = new Socket();

        if (!initQnA()) {
            System.err.println("Error: couldn't initialize questions and answers");
            return;
        }

        while (true) {

            if (serverSocket == null)
                return;
            try {
                clientSocket = serverSocket.accept();
            }
            catch (IOException e) {
                System.err.println("Error");
                System.exit(1);
            }


            try {
                DataInputStream is = new DataInputStream(new
                        BufferedInputStream(clientSocket.getInputStream()));
                PrintStream os = new PrintStream(new
                        BufferedOutputStream(clientSocket.getOutputStream()), false);
                String inLine, outLine = null;

                processInput(null);
                os.println(outLine);
                os.flush();


                while ((inLine = is.readLine()) != null) {
                    processInput(inLine);
                    os.println(outLine);
                    os.flush();
                    if (outLine.equals("End"))
                        break;
                }


                os.close();
                is.close();
                clientSocket.close();
            }
            catch (Exception e) {
                System.err.println("Exception: " + e);
                e.printStackTrace();
            }
        }
    }

    private boolean initQnA() {
        try {
            File            inFile = new File("QnA.txt");
            FileInputStream inStream = new FileInputStream(inFile);
            byte[]          data = new byte[(int)inFile.length()];


            if (inStream.read(data) <= 0) {
                System.err.println("Error: couldn't read questions and answers");
                return false;
            }


            for (int i = 0; i < data.length; i++)
                if (data[i] == (byte)'\n')
                    numQuestions++;
            numQuestions /= 2;
            questions = new String[numQuestions];
            answers = new String[numQuestions];


            int start = 0, index = 0;
            boolean isQ = true;
            for (int i = 0; i < data.length; i++)
                if (data[i] == (byte)'\n') {
                    if (isQ) {
                        questions[index] = new String(data, 0, start, i - start - 1);
                        isQ = false;
                    }
                    else {
                        answers[index] = new String(data, 0, start, i - start - 1);
                        isQ = true;
                        index++;
                    }
                    start = i + 1;
                }
        }
        catch (FileNotFoundException e) {
            System.err.println("Error");
            return false;
        }
        catch (IOException e) {
            System.err.println(" I/O error trying to read questions");
            return false;
        }

        return true;
    }

    void processInput(String inStr) {
        String outStr;

        switch (state) {
            case WAITFORCLIENT:

                outStr = questions[num];
                state = WAITFORANSWER;
                break;

            case WAITFORANSWER:

                if (inStr.equalsIgnoreCase(answers[num]))
                    outStr = "That's correct! Want another? (y/n)";
                else
                    outStr = "Wrong, the correct answer is " + answers[num] +
                            ". Want another? (y/n)";
                state = WAITFORCONFIRM;
                break;

            case WAITFORCONFIRM:
                // See if they want another question
                if (inStr.equalsIgnoreCase("y")) {
                    num = Math.abs(rand.nextInt()) % questions.length;
                    outStr = questions[num];
                    state = WAITFORANSWER;
                }
                else {
                    outStr = "End";
                    state = WAITFORCLIENT;
                }
                break;
        }

    }}
