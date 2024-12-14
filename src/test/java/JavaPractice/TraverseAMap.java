package JavaPractice;

import org.testng.annotations.Test;
import java.util.*;
import java.util.Map.*;

public class TraverseAMap {
	
	
	@Test
	public void traverseMap() {
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("1", "ABC");
		map.put("2", "BCD");
		map.put("3", "CDF");
		map.put("4", "DEF");
		
		map.forEach((k,v)->System.out.println(k+" :: "+v));
		System.out.println("       ");
		
		
		
		for(Entry<String,String>e : map.entrySet()) {
			System.out.println(e.getKey() +" :: "+e.getValue());
			
		}
		
	}

}
