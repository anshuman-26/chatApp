package com.brainmentors.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.brainmentors.chatapp.utils.ConfigReader;

public class Server {
	
		ServerSocket serverSocket;
		public Server() throws IOException {
			int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
			serverSocket = new ServerSocket(PORT);
			System.out.println("Server started and waiting for client connection");
			Socket socket = serverSocket.accept();  //HandShaking
			System.out.println("Client Joins the server");
			InputStream in = socket.getInputStream();  //read bytes from the network
			byte[] arr = in.readAllBytes();
			String str = new String(arr);   //bytes converted into string
			System.out.println("Message recieved from client :"+str);
			in.close();
			socket.close();
		}
			public static void main(String[] args) throws IOException {
				Server server = new Server();
				
		}
}
