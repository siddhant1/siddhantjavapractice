import java.util.Scanner;

public class ReportCardTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Your Name");
		String name = scan.nextLine();
		System.out.println("Enter Your Course");
		String course = scan.next();
		System.out.println("Enter Your RollNo.");
		int rollNo = scan.nextInt();
		System.out.println("Enter Marks of subject 1");
		int marksOfSubject1 = scan.nextInt();
		System.out.println("Enter Marks of subject 2");
		int marksOfSubject2 = scan.nextInt();
		System.out.println("Enter Marks of subject 3");
		int marksOfSubject3 = scan.nextInt();
		
		
		Student student1 = new Student(name,marksOfSubject1,marksOfSubject2,marksOfSubject3,course,rollNo);
		student1.totalMarks();
		student1.percentage();
		student1.print();
		scan.close();
		
	}

}
