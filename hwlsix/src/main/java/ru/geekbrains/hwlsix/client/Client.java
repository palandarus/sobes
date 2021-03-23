package ru.geekbrains.hwlsix.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {

    private String host;
    private Integer port;
    private Socket connectionSocket;
    private PrintWriter output;

    public Client(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

    private void connect(){
        try {
            connectionSocket = new Socket(host, port);
            output = new PrintWriter(connectionSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeConnection(){
        try {
            output.close();
            connectionSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendGetRequest(){
            connect();
            output.println("GET / HTTP/1.0");
            output.println("Host: localhost:9999");
            output.println("");
            output.flush();
            closeConnection();
    }

    public void sendPostRequest(){
            connect();
            output.println("POST / HTTP/1.0");
            output.println("Host: localhost:9999");
            output.println("");
            output.flush();
            closeConnection();

    }

    public static void main(String[] args) throws IOException {
        Client client=new Client("localhost",9999);
        client.sendPostRequest();
        client.sendGetRequest();
    }
}
