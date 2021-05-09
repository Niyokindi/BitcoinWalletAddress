package Elliptic_Curve;
import java.util.Scanner;
public class Ex4 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter one coordinate (x,y)");
		System.out.print("x:");
		int x1 = in.nextInt();
		System.out.print("y:");
		int y1 = in.nextInt();
		
		System.out.println("Enter a second coordinate (x,y)");
		System.out.print("x:");
		int x2 = in.nextInt();
		System.out.print("y:");
		int y2 = in.nextInt();
		int x3;
		int y3;
		x3 = (x1+x2);
		y3 = (y1+y2);
		System.out.println("The result of point addition ");
		System.out.println("The third point is: ("+x3+","+y3+")");
		}
	}

