import java.util.Scanner;

strictfp public class Employee {
	int id;
	String name;
	double salary;
	Scanner scanner = new Scanner(System.in);
	
    void input() {
	
	 id = scanner.nextInt();
	 scanner.nextLine();
	 name = scanner.nextLine();
	 salary = scanner.nextDouble();
    }
	
	void print() {
		System.out.println("id = "+id);
		System.out.println("name = "+name);
		System.out.println("Salary = "+salary);
	}

}
