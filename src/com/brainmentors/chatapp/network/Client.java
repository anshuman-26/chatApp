package com.brainmentors.chatapp.network;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.brainmentors.chatapp.utils.ConfigReader;

public class Client {
	Socket socket;
	public Client() throws UnknownHostException, IOException {
		int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
		socket = new Socket(ConfigReader.getValue("SERVER_IP"), PORT);
	}
	public static void main(String[] args) {
		
	}
}
