import java.io.PrintStream;
import java.util.Scanner;

public class MyProgram
{
	// инструменты ввода-вывода
	// TestBed их заменяет на свои
	public static Scanner in = new Scanner(System.in);
	public static PrintStream out = System.out;
	
	public static void main(String[] args) {
		out.println("Enter two numbers");
		int x = in.nextInt(), y = in.nextInt();
		int sum = x + y;
		out.println("Sum of them is " + sum );
    }
}
 