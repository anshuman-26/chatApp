package com.brainmentors.chatapp.network;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.brainmentors.chatapp.utils.ConfigReader;

public class Client {
	Socket socket;
	public Client() throws UnknownHostException, IOException {
		int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
		socket = new Socket(ConfigReader.getValue("SERVER_IP"), PORT);
		System.out.println("Client Comes");
		System.out.println("Enter the message send to the server...");
		Scanner sc = new Scanner(System.in);
		String message = sc.nextLine();
		OutputStream out = socket.getOutputStream();   //Write bytes on network
		out.write(message.getBytes());
		System.out.println("Message sent to the Server ");
		sc.close();
		out.close();
		socket.close();
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		Client client = new Client();
	}
}
