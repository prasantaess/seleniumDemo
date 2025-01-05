package JavaPractice;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

// Interview Questions 
// There is a student class contains Name, DOB , City.
// sort the list of Student based on name 


public class ListOfStudent {

	
	String name;
	String dateOfBirth;
	String city;
	
	
	public   ListOfStudent( String name, String dateOfBirth, String city){
		
		this.name=name;
		this.dateOfBirth = dateOfBirth;
		this.city = city;		
		
	}
	
	public String getName() {
		
		return name;
	}
	
  public String getdateOfBirth() {
		
		return dateOfBirth;
	}
  
  public String getcity() {
		
		return city;
	}
	
	public String toString() {
		return( "name" + name+ "dateOfBirth" + dateOfBirth + "city"+ city);
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Map<String,ListOfStudent> map = new TreeMap<String,ListOfStudent>();
		map.put("Vivaan", new ListOfStudent("Vivaan","01-01-2000","Kolkata") );
		map.put("Abhishek", new ListOfStudent("Abhishek","01-01-2010","BBSR") );
		map.put("Doly", new ListOfStudent("Doly","01-01-2006","Delhi") );
		map.put("Purbayan", new ListOfStudent("Purbayan","01-01-2003","Howrah") );
		
		TreeMap<String,ListOfStudent> tM= map.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect
				(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(oldValue,newValue)->oldValue,TreeMap::new));
		
		tM.forEach((k,v)->System.out.println(k+ ": "+v));
		
		
		
		
		

	}

}
