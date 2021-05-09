package Finite_fields;

import java.util.Scanner;

public class Ex4 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter an integer between 0 and 57");
		int x = in.nextInt();
		System.out.println("Enter another integer between 0 and 57");
		int y = in.nextInt();
		System.out.println("Do you want to Multiply(0), take the power of(1) or divide(2) both integers?");
		int choice = in.nextInt();
		int prdct = 0;
		int pwr = 0;
		int qtnt = 0;
		if(choice == 0) {
			prdct = (x*y)%57;
			System.out.println("Product = " + prdct);
		}
		else if(choice == 1) {
			System.out.println("Do you want x power y (0) or y power x (1)");
			int answer = in.nextInt();
			if(answer == 0)
				pwr = (int) Math.pow(x, y)%57;
			else pwr = (int) Math.pow(y, x)%57;
			System.out.println("Power = " + pwr);
		}
		else if(choice == 2) {
			qtnt = (int) (x * Math.pow(y, 55))%57;
			System.out.println("Quotient = " +qtnt);
		}
			
	}

}
