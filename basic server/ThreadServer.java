import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadServer {
    public static void main(String[] args) {
        int port = 9000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                HandleRequest requestHandle = new HandleRequest(socket);
                requestHandle.start();
            }

        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

class HandleRequest extends Thread {
    private Socket socket;

    public HandleRequest(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            System.out.println("New client connected");

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            writer.println("Hello");
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}