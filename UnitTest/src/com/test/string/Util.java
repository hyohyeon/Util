package com.test.string;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
	public String roundUp(String s){
		if(s != null && isNumeric(s.replace(".", ""))){
			float val = Float.parseFloat(s);
			int rVal = Math.round(val);
			return Integer.toString(rVal);
		}else{
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
	

}
