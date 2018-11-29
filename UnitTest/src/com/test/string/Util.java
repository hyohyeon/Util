package com.test.string2;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.junit.runner.Result;

public class Util {

	/**
	 * @MethodName : 문자열추출
	 * @author : 박효현
	 * @since : 2018-02-21
	 */
	public String substring(String data, int index) {
		try {
			String result = data.substring(index);
			return result;
		} catch (Exception e) {
			String result = "";
			return result;
		}
	}

	/**
	 * @MethodName : 부분 문자열 추출
	 * @param ex
	 *            "asdfasdf", 1,3
	 * @return ex "asd"
	 * @author : 박효현
	 * @since : 2018-02-21
	 */
	public String substringIndex(String data, int beginIndexgin, int endIndex) {
		try {
			String result = data.substring(beginIndexgin, endIndex);
			return result;
		} catch (Exception e) {
			String result = "";
			return result;
		}
	}

	/**
	 * @MethodName : null empty check
	 * @param 0000-00-00
	 *            or 000000 or 0000/00/00
	 * @return ture or false
	 * @author : 박효현
	 * @since : 2018-02-21
	 */
	public boolean nullOrEmptyCheck(String data) {
		if (data == null || data.isEmpty() || data == "") {
			return false;
		}
		return true;
	}

	/**
	 * @MethodName : 날짜비교
	 * @param 0000-00-00
	 *            or 000000 or 0000/00/00
	 * @return ture or false
	 * @author : 박효현
	 * @since : 2018-02-21
	 */
	public boolean dateCompare(String data1, String data2) {

		if (data1.contains("-") || data1.contains("/")) {
			data1 = data1.replace("-", "");
			data1 = data1.replace("/", "");
		}

		if (data2.contains("-") || data2.contains("/")) {
			data2 = data2.replace("-", "");
			data2 = data2.replace("/", "");
		}

		if (data1.equals(data2)) {
			return true;
		}
		return false;

	}

	/**
	 * @MethodName : stringToDate
	 * @param 0000-00-00
	 *            / 00-00-00 / 00000000 / 0000/00/00 / 00/00/00
	 * @return date : sat jan 02 00:01:00 KST 17
	 * @author : 박효현
	 * @since : 2018-02-21
	 */
	public Date stringToDate(String date) {
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-mm-dd");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy/mm/dd");
		SimpleDateFormat resultformat = new SimpleDateFormat("yyyymmdd");
		Date result, errorResult = null;
		String errorDate = "00000000";

		try {
			errorResult = resultformat.parse(errorDate);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		if (date.contains("-")) {
			try {
				result = dateFormat1.parse(date);
				return result;
			} catch (ParseException e) {
				return errorResult;

			}

		}
		if (date.contains("/")) {
			try {
				result = dateFormat2.parse(date);
				return result;
			} catch (ParseException e) {

				return errorResult;
			}

		}

		try {
			result = resultformat.parse(date);
			return result;
		} catch (ParseException e) {

			return errorResult;
		}

	}

	/**
	 * @MethodName : 날짜계산, dateformat 겸용(두번 째 파라메터 0으로)
	 * @param date
	 *            : 0000-00-00 / 00-00-00 / 00000000 / 0000/00/00 / 00/00/00 , when
	 *            : 오늘기준 구하고 싶은 날 ex -7, 3, 365 ..., type :오늘기준 구하고 싶은 날 ex -7, 3,
	 *            365 ..., type : "yyyy-MM-dd" 와 같은 모든 데이터 포맷타입
	 * @author : 박효현
	 * @since : 2018-02-22
	 */
	public String calculationOfDate(String date, int when, String type) {
		if (date == null) {
			date = "";
		}
		Date defaultTypeDate = stringToDate(date);

		Calendar c = Calendar.getInstance();
		c.setTime(defaultTypeDate);
		c.add(Calendar.DATE, when);

		SimpleDateFormat sdf = new SimpleDateFormat(type);
		String returnDate = sdf.format(c.getTime());
		return returnDate;

	}

	/**
	 * @MethodName : 요일구하기
	 * @param date
	 *            : Stringtype의 날짜, dateType : date의 포맷타입 ex) date : "000000"
	 *            datetype : "yyyyMMdd"
	 * @author : 박효현
	 * @since : 2018-02-22
	 */
	public String getDateDay(String date, String dateType) {
		String day = "";

		SimpleDateFormat dateFormat = new SimpleDateFormat(dateType);
		Date nDate = null;
		try {
			nDate = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Calendar cal = Calendar.getInstance();
		cal.setTime(nDate);

		int dayNum = cal.get(Calendar.DAY_OF_WEEK);

		switch (dayNum) {
		case 1:
			day = "일";
			break;
		case 2:
			day = "월";
			break;
		case 3:
			day = "화";
			break;
		case 4:
			day = "수";
			break;
		case 5:
			day = "목";
			break;
		case 6:
			day = "금";
			break;
		case 7:
			day = "토";
			break;

		}
		return day;
	}

	/**
	 * @MethodName : 모든공백 지우기(좌우,중간 모두)
	 * @param String
	 * @author : 박효현
	 * @since : 2018-02-22
	 */
	public String removeAllSpace(String data) {
		data = data.replaceAll("\\p{Z}", "");
		return data;
	}

	/**
	 * @MethodName : 반올림, 내림 함수(round)
	 * @param String
	 * @author : 박효현
	 * @since : 2018-02-22
	 */
	public String roundUp(String s) {
		if (s != null && isNumeric(s.replace(".", ""))) {
			float val = Float.parseFloat(s);
			int rVal = Math.round(val);
			return Integer.toString(rVal);
		} else {
			return s;
		}
	}

	/**
	 * @MethodName : String으로 표현된 숫자데이터 숫자 단위별 comma(,) 찍기
	 * @param String
	 * @author : 박효현
	 * @since : 2018-02-22
	 */
	public String addComma(String s) {
		if (s != null && isNumeric(s.replace(".", ""))) {
			double val = Double.parseDouble(s);
			NumberFormat formatter = new DecimalFormat("###,###,###.##");
			return formatter.format(val);
		} else {
			return s;
		}
	}

	/**
	 * @MethodName : String으로 표현된 숫자데이터가 전부 숫자인지 확인하는 함수
	 * @param String
	 * @author : 박효현
	 * @since : 2018-02-22
	 */
	public boolean isNumeric(String str) {
		for (int i = 0, len = str.length(); i < len; ++i) {
			if (!Character.isDigit(str.charAt(i))) {
				if (i == 0 && str.charAt(i) == 0x2D) {
					continue;
				}
				return false;
			}
		}
		return true;
	}

	/**
	 * @MethodName : 문자열자르기 / split함수
	 * @param data
	 *            : string, split : string ex) data : "나는,배가,고프다" / split : ","
	 * @return String[] 배열
	 * @author : 박효현
	 * @since : 2018-02-23
	 */
	public String[] split(String data, String split) {
		String[] returnData = data.split(split);
		return returnData;
	}

	/**
	 * @MethodName : 대->소, 소->대문자 변환
	 * @param caseIs
	 *            : 1 : LowerToUpper, 2 : upperToLower
	 * @author : 박효현
	 * @since : 2018-02-23
	 */
	public String toUpperOrLowerCase(String data, int caseIs) {

		if (caseIs == 1) {
			return data.toUpperCase();
		}
		if (caseIs == 2) {
			return data.toLowerCase();
		}
		return data;
	}

	/**
	 * @MethodName : 문자결합 / 문자합치기
	 * @author : 박효현
	 * @param :
	 *            두 파라메터중 한가지 값이 null 이라면 !null 인 값 return 두 파라메터 모두 null 이라면 ""값
	 *            return
	 * @since : 2018-02-23
	 */
	public String concatString(String data1, String data2) {
		if (data1 != null && data2 != null) {
			return data1.concat(data2);
		} else if (data1 == null) {
			return data2;
		} else if (data2 == null) {
			return data1;
		}
		return "";
	}

	/**
	 * @MethodName : 최대값 최소값 구하기
	 * @author : 박효현
	 * @param :
	 *            String = 1 2 3 4 5 6
	 * @return : String = 1 6
	 * @since : 2018-03-09
	 */

	public String intCompareStringVersion(String data) {
		String[] splitData = split(data, "\\s");

		int smaller = 0;
		int bigger = 0;
		for (String w : splitData) {

			int num = Integer.parseInt(w);
			if (smaller == 0 && bigger == 0) {
				smaller = num;
				bigger = num;
			}
			if (num > bigger) {
				bigger = num;
			} else if (num < smaller) {
				smaller = num;
			}
		}
		String result = String.valueOf(smaller) + " " + String.valueOf(bigger);
		return result;

	}

	public int getMean(int[] array) {
		int result = 0;
		int length = array.length;
		for (int x : array) {
			result = result + x;
		}
		return result = result / length;
	}

	public int sumDivisor(int num) {
		int answer = 0;
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				answer += i;
			}
		}
		return answer;
	}

	public String printTrangle(int num) {
		for (int x = 1; x <= num; x++) {
			for (int y = 0; y < x; y++) {
				System.out.print("*");
			}
			System.out.println();
		}
		return "";
	}

	public String getMiddle(String word) {
		int wordLeng = word.length();
		int index = wordLeng / 2;

		return (wordLeng % 2 == 0) ? word.substring(index - 1, index + 1) : word.substring(index, index + 1);

	}

	public int[][] sumMatrix(int[][] A, int[][] B) {
		int[][] answer = new int[A.length][A[0].length];

		for (int x = 0; x < A.length; x++) {
			for (int y = 0; y < A[x].length; y++) {
				answer[x][y] = A[x][y] + B[x][y];
			}
			;
		}
		;
		return answer;

	}

	public int[] gcdlcm(int a, int b) {
		int[] answer = new int[2];
		int temp;
		if (a > b) {
			temp = a;
			b = a;
			a = temp;
		}
		int one, two;
		for (int i = 1; i <= a; i++) {
			if (a % i == 0 && b % i == 0) {
				one = i;
				two = i * (a / i) * (b / i);
				answer[0] = one;
				answer[1] = two;
			}
		}

		return answer;
	}

	public boolean isHarshad(int num) {

		String sNum = Integer.toString(num);
		String[] arrNum = split(sNum, "");
		int numLeng = arrNum.length;
		int[] reArrNum = new int[numLeng];
		int sum = 0;
		for (int i = 0; i < numLeng; i++) {
			reArrNum[i] = Integer.parseInt(arrNum[i]);
			sum += reArrNum[i];
		}
		;
		if (num % sum == 0) {
			return true;
		}
		return false;
	}

	/**
	 * @MethodName : 텍스트가 존재하는 지 검사하는 함수(null 및 빈스트링 검사)
	 * @author : 박효현
	 * @param :
	 *            String
	 * @return : boolean
	 * @since : 2018-11-29
	 */
	public static boolean hasText(String str) {
		boolean resultValue = true;

		if (str == null) {
			resultValue = false;
		} else if (str.length() == 0) {
			resultValue = false;
		}
		return resultValue;
	}

	/**
	 * 빈스트링 체크 함수
	 * 
	 * @author : 박효현
	 * @param :
	 *            String
	 * @return : boolean
	 * @since : 2018-11-29
	 */
	public static boolean isEmptyString(String str) {
		return !hasText(str);
	}
	/**
	 * 1. ArrayList의 모든 textView는 textColor = black 2. View가 null이 아닐 경우에는 해당
	 * view(TextView)만 글자 색상 변경
	 * 
	 * @author : 박효현
	 * @param :
	 *            ArrayList<TextView>
	 * @since : 2018-11-29
	 */
	/*
	 * 안드로이드에서 사용.. public static void ChangeOnAlignment(ArrayList<TextView> tvArr,
	 * View v) { for (int i = 0; i < tvArr.size(); i++) {
	 * tvArr.get(i).setTextColor(Color.BLACK); } // 선택컬럼 색상 변경 if (v != null) {
	 * TextView selected = null; selected = (TextView) v;
	 * selected.setTextColor(Color.rgb(0, 122, 255)); } }
	 */

	/**
	 * 문자열 내 특수문자 제거 함수
	 * 
	 * @author : 박효현
	 * @param :
	 *            String
	 * @return : String
	 * @since : 2018-11-29
	 */
	public static String cleanSpecialCharacters(String str) {
		String resultValue = "0";

		if (null == str) {
		} else if (str.matches(".*[0-9].*")) {
			resultValue = str.replaceAll("[^0-9,.]", "");
		}
		return resultValue;
	}
}
