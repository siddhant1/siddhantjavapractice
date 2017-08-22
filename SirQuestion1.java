import java.util.Scanner;

public class SirQuestion1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter The String You Want To Repeat");
		String repeat = scanner.nextLine();
		System.out.println("Enter The No. of Times You Want To repeat The String");
		int NO = scanner.nextInt();
		for(int i=0;i<NO;i++)
		{
		
		System.out.print(" "+repeat);
        scanner.close();
	}
}}
