import java.util.Scanner;

public class Manager extends Person{
	
	int jobYear;
	Scanner sc = new Scanner(System.in);
	
	public Manager(){
		System.out.print("Please enter how many years the manager is working: ");
        int jobyear = sc.nextInt();
        this.jobYear = jobyear;
	}
	
	
	public double calculate(){
		
		return -(salary + 200 + jobYear*50);
	
	}
	
}