package com.test.string;

import java.util.Date;

import org.junit.jupiter.api.Test;

class SubstringTest {

	@Test
	void testSubString() {
		Util util = new Util();
		/*String result = util.substring("asd", 5);
		
		System.out.println(result);
		
		String result2 = util.substringIndex("ㅁㅁㅁㅁㅁdddddd", 6, 12);
		
		System.out.println(result2);
		
		String test = "";
		Boolean result3 = util.valueCheck(test);
		System.out.println(result3);*/
		Boolean result = util.dateCompare("20170102", "20170101");
		System.out.println(result); 
		Date date = util.stringToDate("17/01/02");
		System.out.println(date);
		
		
		String resultDate = util.calculationOfDate("20180222", 0, "yyyy/MM/dd");
		System.out.println(resultDate);
		String day = util.getDateDay("20180222","yyyyMMdd");
		System.out.println(day);
		
		System.out.println(resultDate+"는 "+day+"요일입니다.");
		
	}


}
