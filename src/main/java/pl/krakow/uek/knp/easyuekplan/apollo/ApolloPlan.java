package pl.krakow.uek.knp.easyuekplan.apollo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created on: 06.03.13 10:05 <br/>
 *
 * @author Slawomir Wojcicki
 */
public interface ApolloPlan {

  DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");

  String getName();

  List getEvents();

  Date getTimeFrom(Object zajecia);

  Date getTimeTo(Object zajecia);

  String getTitle(Object zajecia);

  String getDescription(Object zajecia);

  String getLocation(Object zajecia);

}
