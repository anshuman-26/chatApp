package com.brainmentors.chatapp.network;

import java.io.IOException;
import java.net.ServerSocket;

import com.brainmentors.chatapp.utils.ConfigReader;

public class Server {
	
		ServerSocket serverSocket;
		public Server() throws IOException {
			int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
			serverSocket = new ServerSocket(PORT);
			System.out.println("Server started and waiting for client connection");
		}
			public static void main(String[] args) {
				
		}
	

}
