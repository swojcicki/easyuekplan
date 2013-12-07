package pl.krakow.uek.knp.easyuekplan.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created on: 06.03.13 11:36 <br/>
 *
 * @author Slawomir Wojcicki
 */
public class DatesTest {

  @Test
  public void testDateToStringIso() throws Exception {
    Date input = new GregorianCalendar(2009, Calendar.MAY, 10, 13, 15).getTime();
    String expected = "2009-05-10T13:15:00.000+0200";
    String actual = Dates.iso(input);
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testDateToStringIsoNull() throws Exception {
    Date input = null;
    String expected = null;
    String actual = Dates.iso(input);
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testStringToDateIso() throws Exception {
    String input = "2009-05-10T13:15:00.000+0200";
    Date expected = new GregorianCalendar(2009, Calendar.MAY, 10, 13, 15).getTime();
    Date actual = Dates.iso(input);
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testStringToDateIsoNull() throws Exception {
    String input = "-05-10T13:15:00.000+0200";
    Date expected = null;
    Date actual = Dates.iso(input);
    Assert.assertEquals(expected, actual);
  }
}
