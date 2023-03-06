public class CarWash extends Service{
	final static double basePrice=10;
	
	public CarWash(){}
	
	void displayServiceInfo(){
		System.out.println("\nCar Wash Service...");
		super.displayServiceInfo();
	}
	
	public double calculate(){
		return	revenue();
		
	}
	
	double makeTransaction(double price){
		
		return super.makeTransaction(basePrice);
			
	}
}