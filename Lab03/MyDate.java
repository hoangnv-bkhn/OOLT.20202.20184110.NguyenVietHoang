package lab03;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Calendar;

public class MyDate {

	private int day;
	private int month;
	private int year;
	
	public MyDate() {
		this.year = Calendar.getInstance().get(Calendar.YEAR);
		this.month = Calendar.getInstance().get(Calendar.MONTH)+1;
		this.day = Calendar.getInstance().get(Calendar.DATE);
	}
	
	public MyDate(int day, int month, int year) throws Exception {
		setYear(year);
		setMonth(month);
		setDay(day);
	}
	
	public MyDate(String date) throws Exception { // string input: dd mmm uuuu
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM uuuu").withResolverStyle(ResolverStyle.STRICT);
		LocalDate datetime = LocalDate.parse(date, formatter);
		System.out.println(datetime);
		setYear(datetime.getYear());
		setMonth(datetime.getMonthValue());
		setDay(datetime.getDayOfMonth());
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) throws Exception {
		int m = getMonth();
		int y = getYear();
		YearMonth yearMonth = YearMonth.of(y, m);
		int daysInMonth = yearMonth.lengthOfMonth();
		if (day > daysInMonth || day <= 0) {
			throw new Exception("Day is invalid!!!");
		}
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) throws Exception {
		if (month < 1 || month > 12) {
			throw new Exception("Month is invalid!!!");
		}
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) throws Exception {
		if (year <= 0) {
			throw new Exception("Year is invalid!!!");
		}
		this.year = year;
	}
	
	public void print() {
		System.out.println(day+"/"+month+"/"+year);
	}
	
}
