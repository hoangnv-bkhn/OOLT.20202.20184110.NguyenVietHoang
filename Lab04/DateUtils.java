package Lab04;

public class DateUtils {

	public static int compare(MyDate d1, MyDate d2) {
		if (d1.getYear() > d2.getYear()) {
			return 1;
		}else if (d1.getYear() < d2.getYear()) {
			return -1;
		}else {
			if(d1.getMonth() > d2.getMonth())
                return 1;
            else if(d1.getMonth() < d2.getMonth())
                return -1;
            else {
                if(d1.getDay() > d2.getDay())
                    return 1;
                else if(d1.getDay() < d2.getDay())
                    return -1;
                else
                    return 0;
            }
		}
	}
	
	public static void sortDate(MyDate[] arr) throws Exception {
		MyDate tmp;
		if(arr !=null && arr.length >0){
            for (int i = 0 ; i < arr.length ; i++){
                for (int j = i+1 ; j < arr.length ; j++){
                    if(compare(arr[i],arr[j])>0){
                        tmp = new MyDate(arr[i].getDay(),arr[i].getMonth(),arr[i].getYear());
                        arr[i] = new MyDate(arr[j].getDay(),arr[j].getMonth(),arr[j].getYear());
                        arr[j] = new MyDate(tmp.getDay(),tmp.getMonth(),tmp.getYear());
                    }
                }
            }
        }
	}
}
