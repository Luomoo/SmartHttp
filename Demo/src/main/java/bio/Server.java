package bio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * @author luomo
 * @date 2021/5/2 18:20
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(9090));
        System.out.println("server is start");
        int poolCount = Runtime.getRuntime().availableProcessors() * 2;
        ExecutorService executorService = new ThreadPoolExecutor(poolCount, poolCount,
                0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        while (true) {
            executorService.execute(new ServerTask(server.accept()));
        }
    }

    private static class ServerTask implements Runnable {
        private Socket socket = null;

        public ServerTask(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                 ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())) {

                String userName = inputStream.readUTF();
                System.out.println("服务器收到：" + userName);
                outputStream.writeUTF("Hello " + userName);
                outputStream.flush();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
    }


}
