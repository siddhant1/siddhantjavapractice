import java.util.Scanner;

public class SirQuestion2 {

	public static void main(String[] args) 
	{   
		Scanner scanner = new Scanner(System.in);

		//Program Working For One String Only Without spaces
		//Need To Check Some Errors
		System.out.println("Enter The Input String(Without Blank Spaces)");
		String input = scanner.nextLine();
		String temp = input.toLowerCase();
		char[] ch = temp.toCharArray();	
		ch[0] = Character.toUpperCase(ch[0]);
		for (int i=0;i<ch.length;i++)
		System.out.print("" +ch[i] );
		scanner.close();
	}
}
