package mtcss_Server;

import java.io.IOException;
import java.net.ServerSocket;

import java.io.*;
import java.net.*;
import java.util.*;

public class MTCSS_Server {
	public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        boolean listening = true;

        try {
        	serverSocket = new ServerSocket(4444);
        	System.out.println("Server is already.");
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
            System.exit(-1);
        }
        

        while (listening)
	    new MTCSS_ServerThreads(serverSocket.accept()).start();

        serverSocket.close();
    }

}
