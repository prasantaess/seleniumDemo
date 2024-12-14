package JavaPractice;

import org.testng.annotations.Test;
import java.util.*;

public class RemoveTheDuplicateValue {


	@Test
	public void removeTheDuplicateValue() {
		
		List<Integer> ls = Arrays.asList(10,20,30,40,10,20,30,40,50);
		Set<Integer> s = new HashSet<Integer>(ls);
		s.stream().forEach(e->System.out.println(e));
		
		
		
		
		
	}	
}
