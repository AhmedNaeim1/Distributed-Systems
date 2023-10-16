package lab_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		try {
			Socket clientSocket = new Socket("localhost", 2023);
			DataInputStream dataInput = new DataInputStream(clientSocket.getInputStream());
			DataOutputStream dataOutput = new DataOutputStream(clientSocket.getOutputStream());

			while (true) {
				String msg = (String) dataInput.readUTF();
				System.out.println(msg);

				Scanner scan = new Scanner(System.in);
				String messageScan = scan.nextLine();
				dataOutput.writeUTF(messageScan);

				if (messageScan.equals("exit")) {
					break;
				}
			}
			dataInput.close();
			dataOutput.close();
			clientSocket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
