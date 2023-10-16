package lab_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try {
			// Open server
			ServerSocket serverSocket = new ServerSocket(2023);

			while (true) {
				// Listen and accept client
				Socket clientSocket = serverSocket.accept();

				// Read or write
				DataInputStream dataInput = new DataInputStream(clientSocket.getInputStream());
				DataOutputStream dataOutput = new DataOutputStream(clientSocket.getOutputStream());

				dataOutput.writeUTF("Server Opened, waiting for your message");

				while (true) {
					String msg = (String) input.readUTF();
					System.out.println(msg);

					dataOutput.writeUTF("Received: " + msg);

					if (msg.equals("exit")) {
						break;
					}
				}

				input.close();
				dataOutput.close();
				clientSocket.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
