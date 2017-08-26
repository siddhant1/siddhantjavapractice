import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

    static boolean isAnagram(String a, String b) {
    	 String alow = a.toLowerCase();
    	 String blow =  b.toLowerCase();
        char[] d= alow.toCharArray();
        char[] e = blow.toCharArray();
        
        Arrays.sort(d);
        Arrays.sort(e);
        if(Arrays.equals(d, e)){
            
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}

