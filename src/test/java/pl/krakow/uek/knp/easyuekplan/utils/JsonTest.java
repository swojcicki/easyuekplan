package pl.krakow.uek.knp.easyuekplan.utils;

import org.junit.Assert;
import org.junit.Test;
import pl.krakow.uek.knp.easyuekplan.apollo.ApolloPlan;
import pl.krakow.uek.knp.easyuekplan.xml.group.Zajecia;

import java.util.*;

/**
 * Created on: 06.03.13 10:42 <br/>
 *
 * @author Slawomir Wojcicki
 */
public class JsonTest {

  @Test
  public void testGenerate() throws Exception {
    String expected = "[{\"id\":1,\"body\":\" <br> \",\"title\":\"Lunch with Mike\",\"start\":\"2009-05-10T13:15:00.000+0200\",\"end\":\"2009-05-10T14:15:00.000+0200\"}]";
    ApolloPlan plan = new ApolloPlan() {

      public String getName() {
        return "";
      }

      public List getEvents() {
        ArrayList list = new ArrayList(1);
        list.add(new Zajecia());
        return list;
      }

      public Date getTimeFrom(Object zajecia) {
        return new GregorianCalendar(2009, Calendar.MAY, 10, 13, 15).getTime();
      }

      public Date getTimeTo(Object zajecia) {
        return new GregorianCalendar(2009, Calendar.MAY, 10, 14, 15).getTime();
      }

      public String getTitle(Object zajecia) {
        return "Lunch with Mike";
      }

      public String getDescription(Object zajecia) {
        return "";
      }

      public String getLocation(Object zajecia) {
        return "";
      }
    };
    String actual = new JSON(plan).generate();
    Assert.assertEquals(expected, actual);
  }
}
