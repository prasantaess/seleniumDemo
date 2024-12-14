package JavaPractice;

import org.testng.annotations.Test;
import java.util.*;

public class FindTheAverageLengthOfStrings {

	
	@Test
	public void findTheAverageLengthOfStrings() {
		
		List<String> ls = Arrays.asList("Java","C++","Python","C#","JavaScript","Ruby");
		OptionalDouble avg = ls.stream().mapToInt(e->e.length()).average();
		System.out.println("The average is "+ avg);
		
		
	}
	
	
	
	
}
