package pl.krakow.uek.knp.easyuekplan.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created on: 06.03.13 11:15 <br/>
 *
 * @author Slawomir Wojcicki
 */
public class Dates {

  public static final SimpleDateFormat ISO_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

  public static String iso(Date date) {
    if (date == null) {
      return null;
    }
    return ISO_DATE_FORMAT.format(date);
  }

  public static Date iso(String date) {
    try {
      return ISO_DATE_FORMAT.parse(date);
    } catch (ParseException e) {
      return null;
    }
  }
}
