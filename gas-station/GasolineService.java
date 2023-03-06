public class GasolineService extends FuelService {

	boolean coupon;
	double liters;
	
	public GasolineService(){
		System.out.print("Please enter the gasoline liter: ");
		this.liters= litersBought();
		this.coupon= hasCoupon();
	}
	
	
		boolean hasCoupon(){
			System.out.print("Please enter if you have a coupon (y/n): ");
	         String c = sc.nextLine();
	         if(c.equals("y"))
	        	 return true;
	         else
	        	 return false;
		}
		double getLiters(){
			return liters;
		}
		
		void displayServiceInfo(){
			System.out.println("\nGasoline Service...");
			System.out.println("Bought "+ liters+ " liters.");
			super.displayServiceInfo();
			if(coupon==true)
				System.out.println("Has 10% discount coupon");
		}
		
		double makeTransaction(double price){
			
			if(coupon == true)
				return super.makeTransaction(liters*price*9/10);
			else
				return super.makeTransaction(price*liters);
				
		}
		
		public double calculate(){
			return revenue();
			
		}
		
		
	}
