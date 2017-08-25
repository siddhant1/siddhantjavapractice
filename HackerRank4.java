import java.util.Scanner;

public class HackerRank4 {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        StringBuffer sb = new StringBuffer(sc.next());
        StringBuffer dup = new StringBuffer(sb);
        sb.reverse();
        if(sb.toString().equals(dup.toString()))
        {
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
        sc.close();    }
}
