import java.util.Scanner;

public class HackerRankIfElse {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();            
        String ans="";
        if(n>1&&n<100) {
        if(n%2==1){
          ans = "Weird";
        }
        else{
        
          if(n%2==0 && n>=2 && n<=5) {
        	  System.out.println("Not Weird");
        	  
        	  
          }
          if(n%2==0 && n>=6 && n<=20) {
        	  
        	  System.out.println("Weird");
        	  
        	  
          }
          
          if(n%2==0 && n>20 ) {
        	  System.out.println("Not Weird");}
        	  
            
        }
        System.out.println(ans);
        }
        else {
        	System.out.println("Out Of range");
        }

	}

}
