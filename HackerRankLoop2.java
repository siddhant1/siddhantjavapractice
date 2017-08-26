import java.util.Scanner;

public class HackerRankLoop2 {

	   public static void main(String []argh){
	        Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        for(int j=0;j<t;j++) 
	        {
	          int a = Integer.parseInt(in.next());
	          int b = Integer.parseInt(in.next());
	          int n = in.nextInt();
	            int arr[] = new int[100];
	           int p=0;
			for( int i=1;i<n+2;i++) {
            if(i==1) {
				 arr[i] = a;
            }
            
            else {
            	int loophelp = (int) Math.pow(2, p);
				 arr[i] = arr[i-1]+ (loophelp*b);
				 p++;
            }}
	       for( int i=2;i<n+2;i++) { 
	    	   System.out.print(""+arr[i]+" ");
	       }
	       System.out.print('\n');
	        }
	        in.close();
	   }

}
