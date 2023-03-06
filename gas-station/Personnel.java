import java.util.Scanner;

public class Personnel extends Person{
	private String Name,surName;
	private int jobCount=0;
	
	
	public Personnel(){
		this.jobCount=0;
	}
	
	void incJobCount(){
		
		jobCount++;
	}
	
	public double calculate() {
		return -(salary+getjobCount()*1.5);
	}

	public int getjobCount() {
		
		return jobCount;
	}
}