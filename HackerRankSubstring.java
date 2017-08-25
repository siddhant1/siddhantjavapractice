import java.util.Scanner;

public class HackerRankSubstring {

	public static void main(String[] args) {

	   
	        Scanner in = new Scanner(System.in);
	        String S = in.nextLine();
	        int start = in.nextInt();
	        int end = in.nextInt();
	        String s1 = S.substring(start,end);
	        System.out.println(""+s1);
	        in.close();
	}

}
