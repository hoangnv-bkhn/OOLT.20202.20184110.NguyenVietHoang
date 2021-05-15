package hust.soict.hedspi.aims.utils;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class MyDate {

	private int day;
	private int month;
	private int year;

	private String[] datewrinword = { "first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth",
			"ninth", "tenth", "eleventh", "twelfth", "thirteenth", "fourteenth", "fifteen", "sixteenth", "seventeenth",
			"eighteenth", "nineteenth", "twentieth", "twenty-first", "twenty-second", "twenty-third", "twenty-fourth",
			"twenty-fifth", "twenty-sixth", "twenty-seventh", "twenty-eighth", "twenty-ninth", "thirtieth",
			"thirty-first" };
	private List<String> monthwrinword = Arrays.asList("January", "February", "March", "April", "May", "June", "July",
			"August", "September", "October", "November", "December", "Jan.", "Feb.", "Mar.", "Apr.", "Aug.", "Sept.",
			"Oct.", "Nov.", "Dec.", "Jan", "Feb", "Mar", "Apr", "Jul", "Aug", "Aug", "Sep", "Oct", "Nov", "Dec");

	public MyDate() {
		this.year = Calendar.getInstance().get(Calendar.YEAR);
		this.month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		this.day = Calendar.getInstance().get(Calendar.DATE);
	}

	public MyDate(int day, int month, int year) throws Exception {
		setYear(year);
		setMonth(month);
		setDay(day);
	}

	public MyDate(String date) throws Exception { // string input: dd mmm uuuu
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM uuuu")
				.withResolverStyle(ResolverStyle.STRICT);
		LocalDate datetime = LocalDate.parse(date, formatter);
		System.out.println(datetime);
		setYear(datetime.getYear());
		setMonth(datetime.getMonthValue());
		setDay(datetime.getDayOfMonth());
	}

	public MyDate(String day, String month, String year) throws Exception {
		int d = 0;
		for (int i = 0; i < datewrinword.length; i++) {
			if (day.toLowerCase().equals(datewrinword[i])) {
				d = i + 1;
				break;
			}
		}
		int m = checkMonth(month, monthwrinword);
		int y = getYearFromString(year);
		setYear(y);
		setMonth(m);
		setDay(d);

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

	public String print() {
//		System.out.println(day + "/" + month + "/" + year);
		
		String m = null;
		switch (month) {
		case 1:
			m = "January";
			break;
		case 2:
			m = "February";
			break;
		case 3:
			m = "March";
			break;
		case 4:
			m = "April";
			break;
		case 5:
			m = "May";
			break;
		case 6:
			m = "June";
			break;
		case 7:
			m = "July";
			break;
		case 8:
			m = "August";
			break;
		case 9:
			m = "September";
			break;
		case 10:
			m = "October";
			break;
		case 11:
			m = "November";
			break;
		case 12:
			m = "December";
			break;
		default:
			break;
		}
		
		String d;
		if(day == 1 || day == 21)
            d = day+"st";
        else if(day == 2 || day == 22)
            d = day+"nd";
        else if(day == 3 || day == 23)
            d = day+"rd";
        else
            d = day+"th";
		
		return m + " " + d + " " + year;
	}
	
	public String print_Format(int format) {
		String d = (day>9)?day+"":"0"+day;
        String mm = (month>9)?month+"":"0"+month;
        String MMM = monthwrinword.get(month-1).substring(0,3);
        switch (format){
            case 1:
                return "Date in format (yyyy-MM-dd): "+year+"-"+mm+"-"+d;
            case 2:
                return "Date in format (d/M/yyyy): "+day+"/"+month+"/"+year;
            case 3:
                return "Date in format (dd-MMM-yyyy): "+d+"-"+MMM+"-"+year;
            case 4:
                return "Date in format (MMM d yyyy): "+MMM+" "+day+" "+year;
            case 5:
                return "Date in format (mm-dd-yyyy): "+mm+"-"+d+"-"+year;
            default:
                return print();
        }
	}

	private int checkMonth(String month, List<String> monthStrings) {
		if (monthStrings.stream().filter(elem -> elem.toLowerCase().equals(month.toLowerCase())).findFirst() != null) {
			String m = month.toLowerCase();
			if (m.equals("january") || m.equals("jan.") || m.equals("jan"))
				return 1;
			else if (m.equals("february") || m.equals("feb.") || m.equals("feb"))
				return 2;
			else if (m.equals("march") || m.equals("mar.") || m.equals("mar"))
				return 3;
			else if (m.equals("april") || m.equals("apr.") || m.equals("apr"))
				return 4;
			else if (m.equals("may"))
				return 5;
			else if (m.equals("june") || m.equals("jun"))
				return 6;
			else if (m.equals("july") || m.equals("jul"))
				return 7;
			else if (m.equals("august") || m.equals("aug.") || m.equals("aug"))
				return 8;
			else if (m.equals("september") || m.equals("sep.") || m.equals("sep"))
				return 9;
			else if (m.equals("october") || m.equals("oct.") || m.equals("oct"))
				return 10;
			else if (m.equals("november") || m.equals("nov.") || m.equals("nov"))
				return 11;
			else if (m.equals("december") || m.equals("dec.") || m.equals("dec"))
				return 12;
		}
		return 0;
	}
	
	private int getYearFromString(String year) {
		String y = year.toLowerCase();
		String[] items = y.split("\\s");
		if (items.length < 2) {
			return -1;
		}
		int a, b;
		a = getNumber(items[0]);
		if (a == -1) {
			return -1;
		}
		b = getNumber(items[1]);
		if (b ==1 && items[1].equals("hundred")) {
			b = 0;
		}else if (b == -1 && !items[1].equals("hundred")) {
			return -1;
		}
		return a*100 + b;
	}
	
	private int getNumber(String item) {
		String[] compo1 = {"one","two","three","four","five","six","seven","eight","nine"};
        String[] compo2 = {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
        String[] compo3 = {"twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
        int x= 0, y = 0, c = 0;
        if (!item.contains("-")) {
			for (int i = 0; i < compo1.length; i++) {
				if (compo1[i].equals(item)) {
					x = i +1;
					y = 0;
					c = 1;
					break;
				}
			}
			if (c== 0) {
				for (int i = 0; i < compo2.length; i++) {
					if (compo2[i].equals(item)) {
						x = 1;
						y = i;
						c = 1;
						break;
					}
				}
			}
			if (c == 0) {
				for (int i = 0; i < compo3.length; i++) {
					if (compo3[i].equals(item)) {
						x = i +2;
						y = 0;
						c = 1;
						break;
					}
				}
			}
			if (c == 0) {
				return -1;
			}
		}else {
			String[] items = item.split("-");
			if (items.length > 2) {
				return -1;
			}
			for (int i = 0; i < compo3.length; i++) {
				if (compo3[i].equals(items[0])) {
					x = i + 2;
					break;
				}
			}
			if (x == 0) {
				return -1;
			}
			for (int i = 0; i < compo1.length; i++) {
				if (compo1[i].equals(items[1])) {
					y = i + 1;
					break;
				}
			}
			if (y == 0) {
				return -1;
			}
		}
        
        return x*10 + y;
	}

}
