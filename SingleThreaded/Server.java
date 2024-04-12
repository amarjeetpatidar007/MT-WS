package SingleThreaded;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Server{

    public void run(){
        int port = 8010;
        try{
        ServerSocket socket = new ServerSocket(port);
        socket.setSoTimeout(10000);
        while (true){
            
                System.out.println("Server is listening on port" +port);
                Socket acceptedConnection = socket.accept();
                System.out.println("Connection accepted from client" + acceptedConnection.getRemoteSocketAddress());
                PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream());
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));
                toClient.println("MSG from Server");
                fromClient.close();
                toClient.close();
                acceptedConnection.close();
        }}catch (IOException ex){
            ex.printStackTrace();
        }
    }
    


    public static void main(String[] args){
        Server server = new Server();
        try{
            server.run();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}