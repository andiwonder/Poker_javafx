package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class PokerServer {
    public static final int port = 4444;
    private ServerSocket ss = null;

    public void  runServer() throws IOException, ClassNotFoundException{
        ss = new ServerSocket(port);
        System.out.println("Welcome to the PokerServer :");
        Socket socket = ss.accept();
        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());



//        os.writeObject(Card card);
//        socket.close();
    }


    public static void main(String[] args) throws ClassNotFoundException, IOException {
        new PokerServer().runServer();
    }
}
