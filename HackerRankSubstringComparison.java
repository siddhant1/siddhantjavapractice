import java.util.Scanner;

public class HackerRankSubstringComparison {

    
	public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        return smallest + "\n" + largest;
		
        
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
	}


