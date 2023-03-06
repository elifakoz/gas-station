public class DieselService extends FuelService  {
	double liters;
	int antiFreeze;
	
	public DieselService(){
		System.out.print("Please enter the diesel liter: ");
		this.liters= litersBought();
		this.antiFreeze= discountedAntiFreezeCount();
	}
	
	double getLiters(){
		return liters;
	}
		
	boolean discountedAntiFreeze(){
		System.out.print("Please enter if you want discounted anti-freeze (y/n): ");
        String af = sc.nextLine();
        if(af.equals("y"))
       	 return true;
        else
       	 return false;
	}
	
	int discountedAntiFreezeCount(){
		if(discountedAntiFreeze() == true){
			System.out.print("Please enter how many anti-freeze you want: ");
			int af = sc.nextInt();
			return af;
		}
		else
			return 0;			
	}
	
	double discountedAntiFreezePrice(){
		double afp=antiFreeze*25;
		return afp;
	}
	
	void displayServiceInfo(){
		System.out.println();
		System.out.println("Diesel Service...");
		System.out.println("Bought "+ liters+ " liters.");
		super.displayServiceInfo();
		if(antiFreeze > 0)
			System.out.println("Bought "+ antiFreeze+ " discounted anti-freeze.");
		
	}
	
	double makeTransaction(double price){
		return super.makeTransaction((price*liters)+ discountedAntiFreezePrice());
	}
	
	public double calculate(){
		return revenue();
		
	}

}
