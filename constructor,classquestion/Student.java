
public class Student{
	
	private String name;
	private int marksOfSubject1 ;
	private int marksOfSubject2 ;
	private int marksOfSubject3 ;
    private	 String course ;
    private int rollNo;
    private int totalMarks ;
    private double percentage;
    
    public Student(String name,int marksOfSubject1,int marksOfSubject2,int marksOfSubject3, String course,int rollNo) {
    	
    	this.name= name;
    	this.marksOfSubject1 = marksOfSubject1;
    	this.marksOfSubject2 = marksOfSubject2;
    	this.marksOfSubject3 = marksOfSubject3;
    	this.course = course;
    	this.rollNo = rollNo;
    	}
    
    public int getRollNo() {
		return rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarksOfSubject1() {
		return marksOfSubject1;
	}

	public void setMarksOfSubject1(int marksOfSubject1) {
		this.marksOfSubject1 = marksOfSubject1;
	}

	public int getMarksOfSubject2() {
		return marksOfSubject2;
	}

	public void setMarksOfSubject2(int marksOfSubject2) {
		this.marksOfSubject2 = marksOfSubject2;
	}

	public int getMarksOfSubject3() {
		return marksOfSubject3;
	}

	public void setMarksOfSubject3(int marksOfSubject3) {
		this.marksOfSubject3 = marksOfSubject3;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public void totalMarks() {
       	totalMarks = this.marksOfSubject1+this.marksOfSubject2+this.marksOfSubject3;
       	
    }
    public void percentage() {
    	
    	percentage = (marksOfSubject1+marksOfSubject2+marksOfSubject3)/3;
    	
    }
    
    public void print(){
    {   System.out.println(name);
        System.out.println(course);
        System.out.println(rollNo);
    	System.out.println("Your percentage is"+percentage);
    	System.out.println("Your total marks are"+totalMarks);
    }
    
    }
}

