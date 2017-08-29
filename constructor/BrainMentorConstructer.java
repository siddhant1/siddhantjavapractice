
public class BrainMentorConstructer {
	private int id ;
	private String name ;
	private double  salary ;
	private String branch;
	
	public BrainMentorConstructer() {
	   branch = "Noida";
	}
	public BrainMentorConstructer(int id , String name , double salary) {
   	 this();	 
     this.id = id;
     this.name = name;
     this.salary = salary;
	}
	public void print() {	
		System.out.println("id is "+id);
		System.out.println("salary is "+name);
		System.out.println(" salary is "+salary);
		System.out.println("Branch is "+branch);
	}
}
