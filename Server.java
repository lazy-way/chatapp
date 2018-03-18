import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;
import java.util.Scanner;

public class MyServer {

	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(9999);
		System.out.println("Server Started!");
		while(1!=2) {
			Socket s = ss.accept();
			DataInputStream din = new DataInputStream(s.getInputStream());
			String getMessage = din.readUTF();
			System.out.println("Client: " + getMessage);
			
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			Scanner in = new Scanner(System.in);
			System.out.print("Your Message for Client: ");
			String sendMessage = in.nextLine();
			dout.writeUTF(sendMessage);
			dout.flush();
		}
		
	}
}
