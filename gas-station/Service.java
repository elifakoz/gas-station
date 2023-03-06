import java.util.Scanner;


class Service implements Profitable,Comparable<Service>  {
	private String plate;
	private double revenue=0;
	boolean localLoop = true;
	Scanner sc = new Scanner(System.in);
	public Service(){
		carPlate();
		this.revenue=revenue();
	}
	
	void carPlate(){
		
		while(localLoop)
		try {
		System.out.print("Please enter the car plate: ");
	    String p = sc.nextLine();
	    authenticateCarPlate(p);
        this.plate = p;
		localLoop = false;
		}
		catch(Exception ex) {
			System.err.println("Please enter a valid Car Plate...");
		}
	}
	
	public String getPlate() {
		return plate;
	}


	double revenue() {
			return revenue;
			}
	
	void displayServiceInfo(){
		System.out.println("Car Plate is "+ plate+".");
		System.out.println("The revenue from this service is "+ revenue);
	}
	
	double makeTransaction(double price){
		revenue= price;
		return revenue;
	}

	public double calculate() {
		
		return revenue();
	}

	public int compareTo(Service service) {
		
		return (int) (this.revenue - service.revenue());
	}
	
	public static void authenticateCarPlate(String plate) throws CarPlateException{
		
		
		String[] arrOfplate = plate.split(" ");
		int plate1= Integer.parseInt(arrOfplate[0]);
		
		String[] arrOfplate2 = arrOfplate[1].split("");
		
		String[] arrOfplate3 = arrOfplate[2].split("");
		 
            
        if( 0 < plate1 && plate1 < 81 ){
            if(arrOfplate2.length == 1 ){
            	if(arrOfplate3.length == 4 || arrOfplate3.length == 5 ){
            		return;
            	}
            	else{
            		throw new CarPlateException();
            	}
            }
            else if (arrOfplate2.length == 2 ){
            	if(arrOfplate3.length == 2 || arrOfplate3.length == 3 || arrOfplate3.length == 4 ){  //despite the format, I added arrOfplate3.length == 2 because of in  assignment walkthrough it is accepted
            		return ;
            	}
            	else{
            		throw new CarPlateException();
            	}
            }
            else if (arrOfplate2.length == 3 ){
            	if(arrOfplate3.length == 2 || arrOfplate3.length == 3 ){
            		return;
            	}
            	else{
            		throw new CarPlateException();
            	}
            }
            else{
            	throw new CarPlateException();
            }
        }
            else{
            	throw new CarPlateException();
            }
            
	}
	
}
