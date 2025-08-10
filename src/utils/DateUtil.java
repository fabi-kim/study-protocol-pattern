package utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

  public static Date addDay(Date sourceDate, int day) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(sourceDate);
    cal.add(Calendar.DATE, day);

    return cal.getTime();
  }
}
