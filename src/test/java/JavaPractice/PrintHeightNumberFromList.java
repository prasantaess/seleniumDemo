package JavaPractice;

import org.testng.annotations.Test;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PrintHeightNumberFromList {
	
	
	@Test
	
	public void printHeightNumberFromList() {
		List<Integer> numbers = Arrays.asList(90,1, 2, 3, 4, 5, 6, 7, 8, 9, 10,100);
		Optional<Integer> HeightNum = numbers.stream().max(Comparator.comparing(e->e));
		//Optional<Integer> HeightNum= numbers.stream().sorted(Collections.reverseOrder()).findFirst();
		
		Optional<Integer> MinNum = numbers.stream().min(Comparator.comparing(e->e));
		
		//Optional<Integer> MinNum= numbers.stream().sorted().findFirst();

		System.out.println("The Height number is "+HeightNum);
		System.out.println("The Lowest number is "+MinNum);
	}

}
