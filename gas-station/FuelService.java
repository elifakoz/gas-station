public class FuelService extends Service {

	public FuelService(){
	}
	
	double litersBought(){
        String l = sc.nextLine();
		return Double.parseDouble(l);
		
	}
	
	void displayServiceInfo(){
		
		super.displayServiceInfo();
	}
	
	double makeTransaction (double price){
		return super.makeTransaction(price);
		
	}
}
