package pl.krakow.uek.knp.easyuekplan.apollo;

import pl.krakow.uek.knp.easyuekplan.xml.group.PlanZajec;
import pl.krakow.uek.knp.easyuekplan.xml.group.Zajecia;

import java.util.Date;
import java.util.List;

/**
 * Created on: 06.03.13 20:14 <br/>
 *
 * @author Slawomir Wojcicki
 */
public class GroupPlan implements ApolloPlan {

  private PlanZajec planZajec;

  public GroupPlan(PlanZajec planZajec) {
    this.planZajec = planZajec;
  }

  public String getName() {
    return planZajec.getNazwa();
  }

  public List getEvents() {
    return planZajec.getZajecia();
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
