package bio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author luomo
 * @date 2021/5/2 18:51
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = null;
        ObjectInputStream inputStream = null;
        ObjectOutputStream outputStream = null;

        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 9090);

        try {
            socket = new Socket();
            socket.connect(socketAddress);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());

            outputStream.writeUTF("luomo");
            outputStream.flush();

            System.out.println(inputStream.readUTF());


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            socket.close();
            outputStream.close();
            inputStream.close();
        }

    }
}
