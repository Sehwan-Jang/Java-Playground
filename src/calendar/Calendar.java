package calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Calendar {
	private static final int[] DAY = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_DAY = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	private HashMap<Date, ArrayList<String>> schedule;
	private ArrayList<String> list = new ArrayList<String>();
	
	public Calendar() {
		schedule =new HashMap<Date, ArrayList<String>>();
	}
	
	public void registerPlan(String strDate, String plan) {
		Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
			if (schedule.containsKey(date)) {
				list = schedule.get(date);
				list.add(plan);
			} else
				list.add(plan);
			schedule.put(date, list);		
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("에러가 발생했습니다.");
		}		
	}
	
	public void searchPlan(String strDate) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		
		if (schedule.containsKey(date)) {
			System.out.println(schedule.get(date).size() + "개의 일정이 있습니다.");
			for (int i = 0; i < schedule.get(date).size(); i++) {
				System.out.println((i + 1) + ". " + schedule.get(date).get(i));
			}
		} else
			System.out.println("일정이 없습니다.");
	}

	public boolean isLeapYear(int year) {
		if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0))
			return true;
		else
			return false;
	}

	public int getMaxDayOfMonth(int year, int month) {
		if (isLeapYear(year))
			return LEAP_DAY[month - 1];
		else
			return DAY[month - 1];
	}

	// calculate first day of month automatically
	public int getFirstDay(int year, int month) {
		int dayCount = 1;  // 0001/Jan/1 = Monday
		for (int i = 1; i < year; i++) {
			int delta = isLeapYear(i) ? 366: 365;
			dayCount += delta;
		}

		for (int i = 1; i < month; i++) {
			int delta = getMaxDayOfMonth(year, i);
			dayCount += delta;
		}
		
		int firstDay = dayCount % 7;
		return firstDay;
	}

	public void printCalendar(int year, int month) {
		System.out.printf("                <<%4d년%5d월>>%n", year, month);
		System.out.print("SU" + "\t" + "MO" + "\t" + "TU" + "\t" + "WE" + "\t" + "TH" + "\t" + "FR" + "\t" + "SA");
		System.out.println();
		System.out.println("--------------------------------------------------");

		int maxDay = getMaxDayOfMonth(year, month);
		int firstDay = getFirstDay(year, month);

		for (int i = 0; i < firstDay; i++) {
			System.out.print("  " + "\t");
		}

		for (int i = 1; i <= maxDay; i++) {
			if (i < 10) {
				System.out.print(" " + i + "\t");
			} else
				System.out.print(i + "\t");
			if ((firstDay + i) % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println();

	}
	
}
