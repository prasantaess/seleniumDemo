package JavaPractice;

import org.testng.annotations.Test;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FilterOutTheStringsThatStartWithTheLetter {
	
	
	@Test
	
	public void filterOutTheStringsThatStartWithTheLetter() {
		List<String> strings = Arrays.asList("Apple", "Banana", "Apricot", "Orange");
		List<String> ls= strings.stream().filter(e->e.startsWith("A")).collect(Collectors.toList());
		System.out.println(ls);
	}

}
