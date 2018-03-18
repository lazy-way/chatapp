import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;
import java.util.Scanner;

public class MyClient {

	public static void main(String[] args) throws Exception {
		// using while to run program continuously accept message... otherwise it will terminate...
		while(1 != 2) {
			/* localhost will run the server at local ip address (default local ip is 127.0.0.1)
			* to connect to a different computer, type the ip address of that computer here...
			*/
			Socket s = new Socket("localhost", 9999);
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			Scanner in = new Scanner(System.in);
			System.out.print("Your message for Server: ");
			String sendMessage = in.nextLine();
			dout.writeUTF(sendMessage);
			dout.flush(); // flush will send the whole message if the sendMessage contains message greater than specified length
			
			DataInputStream din = new DataInputStream(s.getInputStream());
			String getMessage = din.readUTF(); // this will read any incoming message from server
			System.out.println("Server: " + getMessage);
		}

	}

}
