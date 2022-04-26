package com.brainmentors.chatapp.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.brainmentors.chatapp.utils.ConfigReader;

public class Server {
	
		ServerSocket serverSocket;
		ArrayList<ServerWorker> workers = new ArrayList<>(); //Conatins all the client sockets
		public Server() throws IOException {
			int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
			serverSocket = new ServerSocket(PORT);
			System.out.println("Server started and waiting for client to join...");
			handleClientRequest();
		}
		//Multiple Client HandShaking
		public void handleClientRequest() throws IOException {
			while(true) {
				Socket clientSocket = serverSocket.accept(); //HandShaking
				//Per client Per Thread
				ServerWorker serverWorker = new ServerWorker(clientSocket, this); //Creating a new thread/worker
				workers.add(serverWorker);
				serverWorker.start();
				}
		}
		
		
		
		
		
		
		
		
		
		/*Single Client*/
		/*
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
			serverSocket.close();
		}*/
			public static void main(String[] args) throws IOException {
				Server server = new Server();
				
		}
}
