package calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class PlanItem {
	public Date planDate;
	public ArrayList<String> detail;

	public static Date getDatefromString(String strDate) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		} catch (ParseException e) {
			System.out.println("에러가 발생했습니다.");
		}
		return date;
	}

	public PlanItem(String date, ArrayList<String> detail) {
		this.planDate = getDatefromString(date);
		this.detail = detail;
	}

	public PlanItem(HashMap<Date, ArrayList<String>> schedule, String date) {
		this.planDate = getDatefromString(date);
		this.detail = getPlanList(schedule, date);
	}

	public Date getDate() {
		return planDate;
	}

	public ArrayList<String> getPlanList(HashMap<Date, ArrayList<String>> schedule, String sDate) {
		Date date = getDatefromString(sDate);
		if (schedule.containsKey(date)) {
			ArrayList<String> list = schedule.get(date);
			return list;
		} else {
			ArrayList<String> list = new ArrayList<String>();
			return list;
		}
	}
	
	public ArrayList<String> addPlanList(HashMap<Date, ArrayList<String>> schedule, String sDate, String plan) {
		ArrayList<String> list = getPlanList(schedule, sDate);
		list.add(plan);
		this.detail = list;
		return list;
	}

	public String saveString() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String sDate = formatter.format(planDate);
		return sDate +"." + detail + "\n";
	}
}
