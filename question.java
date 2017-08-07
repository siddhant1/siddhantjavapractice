
public class question {

	public static void main(String[] args) {
	     int arr[] = {31,103,1,54,22,40};
	     int sum=0;
	     int counter=0;
	     for(int i : arr) 
	     {   sum=0;
	    	 while(i>0) 
	    	 {
	    		 int e=i%10;
	    		  sum = sum+e;
	    		  i=i/10; 
	    	 }
	    	 if(sum==4) {
	    		 
				counter++;
	    	 }
	    	 
	     }
	     System.out.println(" "+counter);
	}

}
