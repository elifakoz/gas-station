import java.util.Comparator;


public class PlateCompare implements Comparator<Service> {

	 public int compare(Service service1, Service service2){
	    {
	        return service1.getPlate().compareTo(service2.getPlate());
	    }
	}

}
