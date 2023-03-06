import java.text.DecimalFormat;
import java.util.*;


class Station {
	private String stationName;
	private int ID;
	private String stationname;
	int stationID,wantedID;
	static Integer gasc=0,dieselc=0,servicec=0;
	static double agp=0,adp=0,takenGas=0,takenDiesel=0,netProfit=0;
	boolean localLoop=true;
	
	Gasoline[] gasolineArray;
	Diesel[] dieselArray;
	ArrayList<Service> serviceArray;
	ArrayList<Person> personList ;
	ArrayList<Profitable> profitList;
	Scanner sc = new Scanner(System.in);
	static DecimalFormat df = new DecimalFormat("###.##");
	
	private static Scanner wID,selection;
	
	public Station(){
		System.out.print("Please enter the name of the Station: ");
        stationname = sc.nextLine();
        this.stationName = stationname;
        
        while(localLoop)
        try {
		System.out.print("Please enter the Station ID: ");
        stationID = sc.nextInt();
        this.ID = stationID;
        localLoop = false;
        }
		catch(InputMismatchException ex) {
			System.err.println("ID should be an integer...");
			sc.nextLine();
		}
		
		this.gasolineArray= new Gasoline[10];
        this.dieselArray= new Diesel[10];
        this.serviceArray= new ArrayList<Service>();
        this.personList= new ArrayList<Person>();
        this.profitList= new ArrayList<Profitable>();
	}
	
	public static Station createStation(){
		
		return new Station();
        
	}
	
	public int getID() {
		return ID;
	}
	
	public String getName() {
		
		return stationName;
	}
	public  ArrayList<Service> getserviceArray(){
		return serviceArray;
	}
	
	double averageGasolinePrice(){
		agp = 0;
		for (Gasoline e : gasolineArray){
			if (e != null){
				double a=e.getTotalLiters();
				double b=e.getPricePerLiter();
				agp+= a*b;
			}
		}
		agp= agp/totalGasolineInStation();
		return agp;
	}
	
	double averageDieselPrice(){
		adp = 0;
		for (Diesel e : dieselArray){
			if (e != null){
				double a=e.getTotalLiters();
				double b=e.getPricePerLiter();
				adp+= a*b;
			}
		}
		adp= adp/(totalDieselInStation());
		return adp;
	}
	
	double totalGasolineInStation(){
		double totalGas=0;
		for (Gasoline e : gasolineArray){
			if (e != null){
				totalGas+=e.getTotalLiters();
			}
		}
		return totalGas;
	}
	
	double totalDieselInStation(){
		double totalDiesel=0;
		for (Diesel e : dieselArray){
			if (e != null){
				totalDiesel+=e.getTotalLiters();
			}
		}
		return totalDiesel;
	}
	
	
	void getGasoline(){
		for (Gasoline e : gasolineArray){
			if (e != null){
			System.out.println("\nGasoline...");	
			System.out.println("The origin is: " + e.getOrigin());
			System.out.println("Price per liter is: " + e.getPricePerLiter());
			System.out.println("Total liters of this gasoline is: " + e.getTotalLiters());
			}
		}
	}
	
	void getDiesel(){
		for (Diesel e : dieselArray){
			if (e != null){
			System.out.println("\nDiesel...");
			System.out.println("The origin is: " + e.getOrigin());
			System.out.println("Price per liter is: " + e.getPricePerLiter());
			System.out.println("Total liters of this gasoline is: " + e.getTotalLiters());
			}
		}
	}
	
	public static void findStationAndAddGasoline(Station[] stationArray){
		wID = new Scanner(System.in);
		Integer wantedID;
		System.out.print("Please enter the ID of the Station you want to search: ");
        wantedID = wID.nextInt();
        System.out.println();
        for (Station e : stationArray)
        	if (e != null && wantedID.equals(e.getID())){    
        		e.gasolineArray[gasc++] = new Gasoline();
        		
        		System.out.println();
        		System.out.println("The total gasoline liters in Station #"+ e.getID()+" is "+ (e.totalGasolineInStation()-takenGas));
        		System.out.println("The average gasoline price in Station #"+ e.getID()+ " is "+ df.format(e.averageGasolinePrice()));
        		return;
        	}
        System.out.println( "No station found with the given ID!");
	}
	
	public static void findStationAndAddDiesel(Station[] stationArray){
		wID = new Scanner(System.in);
		Integer wantedID;
		System.out.print("Please enter the ID of the Station you want to search: ");
        wantedID = wID.nextInt();
        System.out.println();
        for (Station e : stationArray)
        	if (e != null && wantedID.equals(e.getID())){
        		e.dieselArray[dieselc++] = new Diesel();
        		
        		System.out.println();
        		System.out.println("The total diesel liters in Station #"+ e.getID()+" is "+ (e.totalDieselInStation()-takenDiesel));
        		System.out.println("The average diesel price in Station #"+ e.getID()+ " is "+ df.format(e.averageDieselPrice()));
        		return;
        	}
        System.out.println( "No station found with the given ID!");
        		
	}
	
	public static void displayStationInventory(Station[] stationArray){
		wID = new Scanner(System.in);
		Integer wantedID;
		System.out.print("Please enter the ID of the Station you want to display: ");
        wantedID = wID.nextInt();
        for (Station e : stationArray)
        	if (e != null && wantedID.equals(e.getID())){
					System.out.println("\nDisplaying the inventory of Station #" + e.getID());
					
	        		e.getGasoline();
	        		System.out.println();
	        		System.out.println("The total gasoline liters in Station #"+ e.getID()+ " is "+ (e.totalGasolineInStation()-takenGas));
	        		System.out.println("The average gasoline price in Station #"+ e.getID()+ " is "+ df.format(e.averageGasolinePrice()));
	        		
	        		e.getDiesel();
	        		System.out.println();
	        		System.out.println("The total diesel liters in Station #"+ e.getID()+" is "+ (e.totalDieselInStation()-takenDiesel));
	        		System.out.println("The average diesel price in Station #"+ e.getID()+ " is "+ df.format(e.averageDieselPrice()));
	        		return;
        	}
        System.out.println( "No station found with the given ID!");
        		
	}
	public static void sellGasoline(Station[] stationArray){
		wID = new Scanner(System.in);
		Integer wantedID;
		System.out.print("Please enter the ID of the Station you want to sell Gasoline: ");
        wantedID = wID.nextInt();
        System.out.println();
        for (Station e : stationArray){
        	if (e != null && wantedID.equals(e.getID())){
        		if (e.personList.isEmpty()){
        			System.out.println( "This station has no personnel!");
        			return;
        		}
        		
        		GasolineService s= new GasolineService();
        		if(s.getLiters() > e.totalGasolineInStation()){
        			System.out.println("Not enough gasoline in the station!");
        			return;
        		}
        		else{
        			s.makeTransaction(agp);
        			takenGas+=s.getLiters();
        			e.serviceArray.add(s);
        			e.profitList.add(s);
            		}
        		System.out.println("Personnel that helped during this service:");
        	
        	Collections.shuffle(e.personList);
	        
	        Iterator<Person> itr = e.personList.iterator();
			while(itr.hasNext()){
				   
				   Profitable p = itr.next();
				   
				   if ( p instanceof Personnel){
					   Personnel per  = (Personnel) p;
					    
					   per.displayInformation();
					   per.incJobCount();
					   return;
				   }
			}
            }
        }  
        	
        System.out.println( "No station found with the given ID!");
	}
	
	public static void sellDiesel(Station[] stationArray){
		wID = new Scanner(System.in);
		Integer wantedID;
		System.out.print("Please enter the ID of the Station you want to sell Diesel: ");
        wantedID = wID.nextInt();
        System.out.println();
        for (Station e : stationArray){
        	if (e != null && wantedID.equals(e.getID())){
        		if (e.personList.isEmpty()){
        			System.out.println( "This station has no personnel!");
        			return;
        		}
        		
        		DieselService s= new DieselService();
        		if(s.getLiters() > e.totalDieselInStation()){
        			System.out.println("Not enough diesel in the station!");
        			return;
        		}
        		else{
        			s.makeTransaction(adp);
        			takenDiesel+=s.getLiters();
        			e.serviceArray.add(s);
        			e.profitList.add(s);
            		}
        		System.out.println("Personnel that helped during this service:");
        		Collections.shuffle(e.personList);
                
                Iterator<Person> itr = e.personList.iterator();
        		while(itr.hasNext()){
        			   
        			   Profitable p = itr.next();
        			   
        			   if ( p instanceof Personnel){
        				   Personnel per  = (Personnel) p;
        				    
        				   per.displayInformation();
        				   per.incJobCount();
        				   return;
        			   }
        		}
        	}
        }
        
        System.out.println( "No station found with the given ID!");
	}
	
	public static void displayServices(Station[] stationArray){
		wID = new Scanner(System.in);
		Integer wantedID;
		System.out.print("Please enter the ID of the Station you want to display: ");
        wantedID = wID.nextInt();
        for (Station e : stationArray)
        	if (e != null && wantedID.equals(e.getID())){
        		
        		Collections.sort(e.serviceArray);
        		System.out.println("\nDisplaying the sold services of Station #"+e.getID());
        		
        		for (Service a : e.getserviceArray()){
        			if (a != null){
        				a.displayServiceInfo();
        			}
        		}
        		return;
        	}
        System.out.println( "No station found with the given ID!");
	}

	public static void sellCarWash(Station[] stationArray) {
		wID = new Scanner(System.in);
		Integer wantedID;
		System.out.print("Please enter the ID of the Station you want to sell car wash: ");
        wantedID = wID.nextInt();
        System.out.println();
        for (Station e : stationArray){
        	if (e != null && wantedID.equals(e.getID())){
        		if (e != null && wantedID.equals(e.getID())){
        			if (e.personList.isEmpty()){
            			System.out.println( "This station has no personnel!");
            			return;
            		}
            		
	        		CarWash w= new CarWash();
	        		e.serviceArray.add(w);
	        		w.makeTransaction(10);
	        		e.profitList.add(w);
	        		System.out.println("Personnel that helped during this service:");
	        		Collections.shuffle(e.personList);
	                
	                Iterator<Person> itr = e.personList.iterator();
	        		while(itr.hasNext()){
	        			   
	        			   Profitable p = itr.next();
	        			   
	        			   if ( p instanceof Personnel){
	        				   Personnel per  = (Personnel) p;
	        				    
	        				   per.displayInformation();
	        				   per.incJobCount();
	        				   return;
	        			   }
	        		}
        		}
        	}
        }
        System.out.println( "No station found with the given ID!");
	}

	public static void addPerson(Station[] stationArray) {
		selection = new Scanner(System.in);
		
		subMenu.printsubMenu();
		
		String choice = selection.nextLine();

		wID = new Scanner(System.in);
		Integer wantedID;
		System.out.print("Please enter the ID of the Station you want to add a person: ");
		wantedID = wID.nextInt();
		System.out.println();
		
        for (Station e : stationArray)
        	if (e != null && wantedID.equals(e.getID())){
		
        	if (choice.equals("1")){
        		Personnel p = new Personnel();
        		e.personList.add(p);
        		e.profitList.add(p);
        		return;
		}
        	else if (choice.equals("2")){
        	
        		Manager m = new Manager();
        		e.personList.add(m);
        		e.profitList.add(m);
        		return;
        	}
        }
        System.out.println( "No station found with the given ID!");
	}

	public static void calculateNetProfit(Station[] stationArray) {
		
		wID = new Scanner(System.in);
		Integer wantedID;
		System.out.print("Please enter the ID of the Station you want to calculate profit: ");
        wantedID = wID.nextInt();
        System.out.println();
        for (Station e : stationArray){
        	if (e != null && wantedID.equals(e.getID())){
        	Iterator<Profitable> itr = e.profitList.iterator();
			while(itr.hasNext()){
				   
				   Profitable p = itr.next();
				   
				   if ( p instanceof Personnel){
					   Personnel per  = (Personnel) p;
					    
					   System.out.println("Personnel: "+ per.calculate());
					   netProfit += p.calculate();
				   }
				   else if( p instanceof Manager){
					   Manager m = (Manager) p;
					    
					   System.out.println("Manager: "+ m.calculate());
					   netProfit += m.calculate();
				   }
				   
				   else if (p instanceof GasolineService){
					   
					   GasolineService g = (GasolineService) p;
					   
					   System.out.println("GasolineService: "+ df.format(g.calculate()));
					   netProfit += g.calculate();
				   }
				   
				   else if (p instanceof DieselService){
					   
					   DieselService d = (DieselService) p;
					   
					   System.out.println("DieselService: "+df.format(d.calculate()));
					   netProfit += d.calculate();
				   }
				   
				   else if (p instanceof CarWash){
					   
					   CarWash cw = (CarWash) p;
					   
					   System.out.println("CarWash: "+ cw.calculate());
					   netProfit+= cw.calculate();
				   }
				   
			   }
			System.out.println("Net profit of station is: "+ df.format(netProfit));
			netProfit=0;
			return;
        	}
        }
	}


	public static void displayServices2(Station[] stationArray) {
		
		PlateCompare plateCompare = new PlateCompare();
		wID = new Scanner(System.in);
		Integer wantedID;
		System.out.print("Please enter the ID of the Station you want to display: ");
        wantedID = wID.nextInt();
        for (Station e : stationArray)
        	if (e != null && wantedID.equals(e.getID())){
        		
        		Collections.sort(e.serviceArray,plateCompare);
        		System.out.println("\nDisplaying the sold services of Station #"+e.getID());
        		
        		for (Service a : e.getserviceArray()){
        			if (a != null){
        				a.displayServiceInfo();
        			}
        		}
        		return;
        	}
        System.out.println( "No station found with the given ID!");
		
	}


}
