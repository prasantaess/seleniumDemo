package JavaPractice;

import java.util.*;
import java.util.stream.*;

import org.testng.annotations.Test;

public class FindAllTheNumbersStartingWithGivenList {
	
	@Test
	public void findAllTheNumbersStartingWithGivenList() {
	List<Integer>ls = Arrays.asList(112,115,222,214,217,312,416,425,328,118);
	List<Integer>finalList = ls.stream().filter(n->String.valueOf(n).startsWith("2")).map(e->Integer.valueOf(e)).collect(Collectors.toList());
	System.out.println(finalList);
	
	}
}
