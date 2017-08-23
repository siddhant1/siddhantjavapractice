import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        String temp = A.toLowerCase();
        String temp1 = B.toLowerCase();
		char[] ch = temp.toCharArray();	
		char[] ch1 = temp1.toCharArray();  
		System.out.println(""+(temp.length()+temp1.length()) );
		ch[0] = Character.toUpperCase(ch[0]);
		ch1[0] = Character.toUpperCase(ch1[0]);
		int ans = A.compareTo(B);
		if (ans >0)
		{
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
		String yo = String.valueOf(ch);
		String yo1 = String.valueOf(ch1);
		System.out.print("" +yo );
	    System.out.print(" "+yo1 );
		

        sc.close();
    }
}

