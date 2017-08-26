import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
  
	public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String arr[] = new String[s.length()-k+1];
        String largest = "";
        for(int i=0;i<s.length()-k+1;i++) {
			arr[i] = s.substring(i,i+k);	
        }
        
        Arrays.sort(arr);
        smallest= arr[0];
        largest = arr[arr.length-1];
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

