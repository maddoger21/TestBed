import java.util.Scanner;

public class MyProgram
{
    static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

        System.out.println("Enter two numbers");
		int x = in.nextInt(), y = in.nextInt();
		int sum = x + y;
		System.out.println("Sum of them is " + sum);
	}
}
 