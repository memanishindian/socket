/**
 * Server program to process requests for a Country's Capital.
 * 5/10/2016
 * 
 * @author Okeke Arthur Ugochukwu
 * @email : arthurugochukwu@gmail.com
 * @github : ...
 * @facebook : 
 * 
 * @version : 0.1
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    
    private static final String FILE = "data.file";
    
    private static void loadData(HashMap<String, String> H) {
        
        //open the file and read, line by line
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE));
            String in;
            while((in=br.readLine()) != null) {
                String[] data = in.split(",");
                H.put(data[0].toLowerCase(), data[1].toLowerCase());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        int port = args.length != 1 ? 3456 : Integer.parseInt(args[0]);
       
        HashMap<String, String> map = new HashMap<>();
        
        loadData(map);
        
        ServerSocket server = null;
        try {
            
           server = new ServerSocket(port,10);
            
            while(!server.isClosed()) {
                
                Socket accept = server.accept();
                
                Thread ins = new Thread(){
                    @Override
                    public void run() {
                        try {
                            System.out.println("New Connection <:> ");
                            BufferedReader br = new BufferedReader(new InputStreamReader(accept.getInputStream()));
                            PrintWriter out = new PrintWriter(accept.getOutputStream(), true);

                            String in;

                            while((in=br.readLine()) != null) {
                                in=in.toLowerCase();
                                if(!map.containsKey(in)) {
                                    out.println("Please check your input and try again .");
                                }else{
                                    out.println("The capital of "+in+" <is> "+map.get(in));
                                }

                            }
                        } catch (Exception ex) {
                            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                            
                        }
                    }
                };
                ins.start();
            }
          
        } catch(Exception e) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
            if(server != null) server.close();
        }
        
    }
}