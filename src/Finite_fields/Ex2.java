package Finite_fields;
import java.util.Scanner;
public class Ex2 {

	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	System.out.println("Enter an integer between 0 and 57");
	int x = in.nextInt();
	System.out.println("Enter another integer between 0 and 57");
	int y = in.nextInt();
	System.out.println("Do you want to add(0)or substract(1) both integers?");
	int choice = in.nextInt();
	int sum = 0;
	int sub = 0;
	if(choice == 0) {
		sum = (x+y)%57;
		System.out.println("Sum: "+sum);
	}
	else {
		if(x>y)
			sub = (x-y)%57;
		else sub = (y-x)%57;
		System.out.println("Sub:" + sub);
	}
}
}
