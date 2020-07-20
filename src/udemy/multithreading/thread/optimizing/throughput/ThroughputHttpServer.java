package udemy.multithreading.thread.optimizing.throughput;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThroughputHttpServer {

    public static final String INPUT_FILE = "./resources/udemy/multithreading/war_and_peace.txt";
    public static final int NUMBER_OF_THREADS = 6;

    public void startServer(String text) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/search", new WordCountHandler(text));
        Executor executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        server.setExecutor(executor);
        server.start();
    }

    public static void main(String[] args) throws IOException {
        ThroughputHttpServer httpServer = new ThroughputHttpServer();
        String text = new String(Files.readAllBytes(Paths.get(INPUT_FILE)));
        httpServer.startServer(text);
    }
}
