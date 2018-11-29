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
	 * @MethodName : ���ڿ�����
	 * @author : ��ȿ��
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
	 * @MethodName : �κ� ���ڿ� ����
	 * @param ex
	 *            "asdfasdf", 1,3
	 * @return ex "asd"
	 * @author : ��ȿ��
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
	 * @author : ��ȿ��
	 * @since : 2018-02-21
	 */
	public boolean nullOrEmptyCheck(String data) {
		if (data == null || data.isEmpty() || data == "") {
			return false;
		}
		return true;
	}

	/**
	 * @MethodName : ��¥��
	 * @param 0000-00-00
	 *            or 000000 or 0000/00/00
	 * @return ture or false
	 * @author : ��ȿ��
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
	 * @author : ��ȿ��
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
	 * @MethodName : ��¥���, dateformat ���(�ι� ° �Ķ���� 0����)
	 * @param date
	 *            : 0000-00-00 / 00-00-00 / 00000000 / 0000/00/00 / 00/00/00 , when
	 *            : ���ñ��� ���ϰ� ���� �� ex -7, 3, 365 ..., type :���ñ��� ���ϰ� ���� �� ex -7, 3,
	 *            365 ..., type : "yyyy-MM-dd" �� ���� ��� ������ ����Ÿ��
	 * @author : ��ȿ��
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
	 * @MethodName : ���ϱ��ϱ�
	 * @param date
	 *            : Stringtype�� ��¥, dateType : date�� ����Ÿ�� ex) date : "000000"
	 *            datetype : "yyyyMMdd"
	 * @author : ��ȿ��
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
			day = "��";
			break;
		case 2:
			day = "��";
			break;
		case 3:
			day = "ȭ";
			break;
		case 4:
			day = "��";
			break;
		case 5:
			day = "��";
			break;
		case 6:
			day = "��";
			break;
		case 7:
			day = "��";
			break;

		}
		return day;
	}

	/**
	 * @MethodName : ������ �����(�¿�,�߰� ���)
	 * @param String
	 * @author : ��ȿ��
	 * @since : 2018-02-22
	 */
	public String removeAllSpace(String data) {
		data = data.replaceAll("\\p{Z}", "");
		return data;
	}

	/**
	 * @MethodName : �ݿø�, ���� �Լ�(round)
	 * @param String
	 * @author : ��ȿ��
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
	 * @MethodName : String���� ǥ���� ���ڵ����� ���� ������ comma(,) ���
	 * @param String
	 * @author : ��ȿ��
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
	 * @MethodName : String���� ǥ���� ���ڵ����Ͱ� ���� �������� Ȯ���ϴ� �Լ�
	 * @param String
	 * @author : ��ȿ��
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
	 * @MethodName : ���ڿ��ڸ��� / split�Լ�
	 * @param data
	 *            : string, split : string ex) data : "����,�谡,������" / split : ","
	 * @return String[] �迭
	 * @author : ��ȿ��
	 * @since : 2018-02-23
	 */
	public String[] split(String data, String split) {
		String[] returnData = data.split(split);
		return returnData;
	}

	/**
	 * @MethodName : ��->��, ��->�빮�� ��ȯ
	 * @param caseIs
	 *            : 1 : LowerToUpper, 2 : upperToLower
	 * @author : ��ȿ��
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
	 * @MethodName : ���ڰ��� / ������ġ��
	 * @author : ��ȿ��
	 * @param :
	 *            �� �Ķ������ �Ѱ��� ���� null �̶�� !null �� �� return �� �Ķ���� ��� null �̶�� ""��
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
	 * @MethodName : �ִ밪 �ּҰ� ���ϱ�
	 * @author : ��ȿ��
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
	 * @MethodName : �ؽ�Ʈ�� �����ϴ� �� �˻��ϴ� �Լ�(null �� ��Ʈ�� �˻�)
	 * @author : ��ȿ��
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
	 * ��Ʈ�� üũ �Լ�
	 * 
	 * @author : ��ȿ��
	 * @param :
	 *            String
	 * @return : boolean
	 * @since : 2018-11-29
	 */
	public static boolean isEmptyString(String str) {
		return !hasText(str);
	}
	/**
	 * 1. ArrayList�� ��� textView�� textColor = black 2. View�� null�� �ƴ� ��쿡�� �ش�
	 * view(TextView)�� ���� ���� ����
	 * 
	 * @author : ��ȿ��
	 * @param :
	 *            ArrayList<TextView>
	 * @since : 2018-11-29
	 */
	/*
	 * �ȵ���̵忡�� ���.. public static void ChangeOnAlignment(ArrayList<TextView> tvArr,
	 * View v) { for (int i = 0; i < tvArr.size(); i++) {
	 * tvArr.get(i).setTextColor(Color.BLACK); } // �����÷� ���� ���� if (v != null) {
	 * TextView selected = null; selected = (TextView) v;
	 * selected.setTextColor(Color.rgb(0, 122, 255)); } }
	 */

	/**
	 * ���ڿ� �� Ư������ ���� �Լ�
	 * 
	 * @author : ��ȿ��
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
