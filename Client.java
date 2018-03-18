import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;
import java.util.Scanner;

public class MyClient {

	public static void main(String[] args) throws Exception {
		while(1 != 2) {
			Socket s = new Socket("localhost", 9999);
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			Scanner in = new Scanner(System.in);
			System.out.print("Your message for Server: ");
			String sendMessage = in.nextLine();
			dout.writeUTF(sendMessage);
			dout.flush();
			
			DataInputStream din = new DataInputStream(s.getInputStream());
			String getMessage = din.readUTF();
			System.out.println("Server: " + getMessage);
		}

	}

}
