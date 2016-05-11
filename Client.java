
//package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;


public class Client {

    
    public static void main(String[] args) throws IOException{
        
        
        if (args.length != 2) {
            
            System.err.println("Usage: java EchoClient <hostname> <port number>");
            
            System.exit(1);
        }
        
        String hostname = args[0];
        int portNumber = Integer.parseInt(args[1]);
        Socket echo = null;
        try {
            
            //create socket
            echo = new Socket(InetAddress.getByName(null), portNumber);
            
            PrintWriter out = new PrintWriter(echo.getOutputStream(), true);
            
            BufferedReader br = new BufferedReader(new InputStreamReader(echo.getInputStream()));
            
            BufferedReader stdbr = new BufferedReader(new InputStreamReader(System.in));
            
            
            //program
            String in;
            
            while ((in=stdbr.readLine()) != null) {
                //write to socket out stream
                out.println(in);
                
                //read from in stream and write out
                System.out.println("res->: "+br.readLine());
                
            }
            
        } catch(IOException e) {
            System.err.println("Something bad went wrong ");
            
            System.exit(1);
        }
        catch (Exception e ) {
            System.err.println("Something bad went wrong ");
            System.exit(1);
        }
    }
    
}
