package JavaPractice;

import org.testng.annotations.Test;
import java.util.*;

public class FindCountOfDuplicatesValueFromList {


	@Test
	public void findCountOfDuplicatesValueFromList() {
		
		List<Integer> ls = Arrays.asList(10,20,30,40,10,20,30,40,50);
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0; i<ls.size();i++) {
			if(map.containsKey(ls.get(i))) {
				map.put(ls.get(i), map.get(ls.get(i))+1);
			} else {
				map.put(ls.get(i),1);
			}
		}
		
		map.forEach((k,v)->System.out.println(k+" ; "+v)); 
		
	}	
}
