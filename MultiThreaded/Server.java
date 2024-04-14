package MultiThreaded;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class Server {
    
    public Consumer<Socket> getConsumer(){
        //Overiding the accept function defined in Consumer by Using Lambda
        return (clientSocket)->{
            try{
                PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream());
                toClient.println("Hello from the server");
                toClient.close();
            }catch(IOException ex){
                ex.printStackTrace();
            }
        };

        //ANOTHER WAY OF IMPLEMENTING ABOVE FUNCTION WITHOUT LAMBDA
        // return new Consumer<Socket>(){
        //     @Override
        //     public void accept(Socket clientSocket){

        //     }
        // }
    }


    public static void main(String[] args) {
        int port = 8010;
        Server server = new Server();
        try{
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(10000);
            System.out.println("Server is listening on port"+port);
            while (true) {
                Socket acceptedSocket = serverSocket.accept();
                Thread thread = new Thread(()->server.getConsumer().accept(acceptedSocket));
                thread.start();
            }

        }catch(IOException ex){
            ex.printStackTrace();
        }

    }


}
