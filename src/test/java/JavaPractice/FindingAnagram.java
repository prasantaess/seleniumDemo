package JavaPractice;

import java.util.*;

import org.testng.annotations.Test;

public class FindingAnagram {
	
	@Test
	public void findingAnagram() {
		String s = "Silent";
		String l = "listen";
		if(s.length()==l.length()) {
			System.out.println("Length is match "+s.length()+" : " + l.length() );
			String uc1= s.toUpperCase();
			String uc2= s.toUpperCase();
			char array1[] = uc1.toCharArray();
			char array2[] = uc2.toCharArray();
			Arrays.sort(array1);
			Arrays.sort(array2);
			if(Arrays.equals(array1, array2)) {
				System.out.println("The Two Words are Anagram");
			}else {
				System.out.println("The Two Words are Not Anagram");
			}	
		}else {
			System.out.println("Length are not match "+s.length()+" : " + l.length() );
		}
		
	}

}
