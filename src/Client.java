import java.net.*;
import java.io.*;
import java.util.Scanner;


public class Client {
    public static void main(String[] args){
        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter  = null;
        try {
            socket = new Socket("localhost", 1234);
            inputStreamReader = new InputStreamReader(socket.getInputStream());
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            Scanner scn = new Scanner(System.in);
            while(true){
                String msgToSend = scn.nextLine();
                bufferedWriter.write(msgToSend);
                bufferedWriter.newLine();
                bufferedWriter.flush();
                System.out.println("server:"+ bufferedReader.readLine());
                if(msgToSend.equalsIgnoreCase("bye"))
                    break;

            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(socket != null)
                    socket.close();
                if(inputStreamReader != null)
                    inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
