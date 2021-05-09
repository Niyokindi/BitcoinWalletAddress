package Elliptic_Curve;
import java.security.MessageDigest;
import java.util.Scanner;
public class Public_Key {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		//Defining the Base/Generator point
		System.out.println("Enter one coordinate (x,y) in the field F223");
		System.out.print("x:");
		int x1 = in.nextInt();
		System.out.print("y:");
		int y1 = in.nextInt();
		//Checking that the coordinates are in range
		if(x1>=223 || y1>=223 || x1<0 || y1<0) {
			System.out.println("Sorry wrong input");
			System.out.println("Enter one coordinate (x,y) in the field F223");
			System.out.print("x:");
			x1 = in.nextInt();
			System.out.print("y:");
			y1 = in.nextInt();	
		}
		//Generating the private key
		int e = (int)(Math.random()* 1000000);
		
		//Calculating the public key using the formula: P=eG
		int x2 =(e* x1)%223;
		int y2 =(e* y1)%223;

		System.out.println("Elliptic curve cryptography");
		System.out.println("The public key coordinate is: ("+x2+","+y2+")");

		//Hashing of the public key
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		String pk = Integer.toString(x2) + Integer.toString(y2);
		byte[] digest = md.digest(pk.getBytes("UTF-8"));

		StringBuilder sb = new StringBuilder();
		
		for (byte b : digest) {
			sb.append(String.format("%02X", b));
		}
		System.out.println();
		System.out.println("Public key after hashing (SHA-256)");
		System.out.println("Public key: "+ sb.toString().toUpperCase());
	}
}


