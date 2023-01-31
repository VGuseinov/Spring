package com.company;

import java.io.*;
import java.net.Socket;

public class ServerSocket {
    private static Socket clientSocket;
    private static java.net.ServerSocket server;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        try {
            try {
                server = new java.net.ServerSocket(4006);
                System.out.println("The server is running!");
                clientSocket = server.accept();
                try {
                    boolean isConnected = true;
                    in = new BufferedReader(new InputStreamReader((clientSocket.getInputStream())));
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                    out.write("Welcome to the calculator! To exit, press \"-\" " + "\n");
                    out.flush();
                    while (isConnected) {
                        String clientWord = in.readLine();

                        if (clientWord.equals("-")) {
                            out.write("See you soon. \n");
                            out.flush();
                            isConnected = false;
                        } else {
                            out.write(Calculator.workCalc(clientWord) + "\n");
                            out.flush();
                        }
                    }
                } finally {
                    clientSocket.close();
                    in.close();
                    out.close();
                }
            } finally {
                System.out.println("The server is closed!");
                server.close();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
