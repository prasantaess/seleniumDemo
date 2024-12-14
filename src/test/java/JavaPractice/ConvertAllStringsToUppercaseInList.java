package JavaPractice;

import org.testng.annotations.Test;
import java.util.*;
import java.util.stream.*;

public class ConvertAllStringsToUppercaseInList {
	
	@Test
	public void convertAllStringsToUppercaseInList() {
		
		List<String> strings = List.of("apple", "banana", "cherry");
		System.out.println("Original List is "+strings);
		
		List<String> ls = strings.stream().map(e->e.toUpperCase()).collect(Collectors.toList());
		System.out.println("Final list are "+ls);		
		
	}

}
