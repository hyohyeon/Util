package com.test.string;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
	

}
