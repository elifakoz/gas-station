import java.util.Scanner;

class Person implements Profitable{
	
	String name,surname;
	protected double salary;
	Scanner sc = new Scanner(System.in);
	
	public Person(){
		System.out.print("Please enter a name: ");
        String Name = sc.nextLine();
        this.name = Name;
        
        System.out.print("Please enter a surname: ");
        String surName = sc.nextLine();
        this.surname = surName;
        this.salary = 100;
	}
	
	
	public double calculate() {
		
		return salary;
	}
	
	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}


	void displayInformation(){
		System.out.println("Name: "+ getName());
		System.out.println("Surname: "+ getSurname());
	}
	
}
