package HKETests.Soroco;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(getNum("123-456-7890"));
		System.out.println(getNum("1234567890"));
		System.out.println(getNum("xxx999-999-9999"));
		System.out.println(getNum("(000) 000-0000111"));
	}
	
	/*
	 123-456-7890
	(123) 456-7890
 
	 */
	private static String getNum(String s) {
		String pattern1 = "\\d{3}-\\d{3}-\\d{4}";
		String pattern2 = "[(]\\d{3}[)]\\s\\d{3}-\\d{4}";
		
		Pattern p1 = Pattern.compile(pattern1);
		Pattern p2 = Pattern.compile(pattern2);
		
		Matcher m1 = p1.matcher(s);
		while(m1.find()) {
			return m1.group();
		}
		
		Matcher m2 = p2.matcher(s);
		while(m2.find()) {
			return m2.group();
		}
		
		return "NONE";
	}

}
