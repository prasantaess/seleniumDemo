package JavaPractice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.testng.annotations.Test;

public class FindTheSecondHighestNumber {
	
	
	@Test
	public void secondHeightNumber() {
		
		List<Integer> ls = Arrays.asList(90,20,40,10,30,50,80);
		Optional<Integer> op= ls.stream().sorted(Collections.reverseOrder()).skip(1).findFirst();
		System.out.println("The 2nd Height number is "+ op);
		
		
		
	}

}
