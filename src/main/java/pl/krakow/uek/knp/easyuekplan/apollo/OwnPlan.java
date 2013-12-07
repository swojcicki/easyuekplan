package pl.krakow.uek.knp.easyuekplan.apollo;

import pl.krakow.uek.knp.easyuekplan.entities.Own;
import pl.krakow.uek.knp.easyuekplan.xml.group.Zajecia;

import java.util.Date;
import java.util.List;

/**
 * Created on: 07.04.13 20:38 <br/>
 *
 * @author Slawomir Wojcicki
 */
public class OwnPlan implements ApolloPlan {

  private Own own;
  private List<Object> events;

  public OwnPlan(Own own, List<Object> cumulative) {
    this.own = own;
    this.events = cumulative;
  }

  public String getName() {
    return own.getName();
  }

  public List getEvents() {
    return events;
  }

  public Date getTimeFrom(Object zajecia) {
    Zajecia z = (Zajecia) zajecia;
    try {
      return DATE_FORMAT.parse(new StringBuilder()
        .append(z.getTermin())
        .append(" ")
        .append(z.getOdGodz()).toString());
    } catch (Exception e) {
      return null;
    }
  }

  public Date getTimeTo(Object zajecia) {
    Zajecia z = (Zajecia) zajecia;
    try {
      return DATE_FORMAT.parse(new StringBuilder()
        .append(z.getTermin())
        .append(" ")
        .append(z.getDoGodz()).toString());
    } catch (Exception e) {
      return null;
    }
  }

  public String getTitle(Object zajecia) {
    Zajecia z = (Zajecia) zajecia;
    return new StringBuilder()
      .append("[")
      .append(z.getTyp())
      .append("] ")
      .append(z.getPrzedmiot()).toString();
  }

  public String getDescription(Object zajecia) {
    Zajecia z = (Zajecia) zajecia;
    return z.getNauczyciel().getValue();
  }

  public String getLocation(Object zajecia) {
    Zajecia z = (Zajecia) zajecia;
    return z.getSala();
  }
}
