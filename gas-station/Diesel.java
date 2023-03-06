

import java.util.InputMismatchException;
import java.util.Scanner;

class Diesel{
	Scanner sc = new Scanner(System.in);
	private String origin;
	private double ppl,pricePerLiter,totalLiters;
	String org;
	double tl;
	boolean localLoop = true;
	
	
	public Diesel(){
		
		System.out.print("Please enter the origin of diesel: ");
        org = sc.nextLine();
		this.origin = org;
		
		while(localLoop)
		    try {
		    
		    System.out.println("Please enter the price per liter: ");
	        ppl = sc.nextDouble();
	        this.pricePerLiter = ppl;
	        localLoop = false;
		    }
			catch(InputMismatchException ex) {
				System.err.println("price should be a double... ");
				sc.nextLine();
			}
			
		
		System.out.print("Please enter the total shipment volume in liter: ");
        tl = sc.nextDouble();
		this.totalLiters = tl;
	}
	
	public String getOrigin(){
		return origin;
	}
	
	public double getPricePerLiter(){
		return pricePerLiter;
	}
	
	public double getTotalLiters(){
		return totalLiters;
	}
	
}
