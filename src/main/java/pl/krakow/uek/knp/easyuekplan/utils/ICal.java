package pl.krakow.uek.knp.easyuekplan.utils;

import net.fortuna.ical4j.model.*;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.*;
import org.apache.commons.lang3.RandomStringUtils;
import pl.krakow.uek.knp.easyuekplan.apollo.ApolloPlan;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created on: 17.05.12 20:45 <br/>
 *
 * @author Slawomir Wojcicki
 */
public class ICal {

  private static final Logger log = Logger.getLogger(ICal.class.getName());

  private Calendar icsCalendar;
  private ApolloPlan apolloPlan;

  public ICal(ApolloPlan apolloPlan) {
    this.icsCalendar = new Calendar();
    this.apolloPlan = apolloPlan;

    PropertyList properties = icsCalendar.getProperties();
    properties.add(new ProdId("-//Google Inc//Google Calendar 70.9054//EN"));
    properties.add(Version.VERSION_2_0);
    properties.add(CalScale.GREGORIAN);
    properties.add(new Method("PUBLISH"));
    properties.add(new XProperty("X-WR-CALNAME", Lang.replaceSpecialChars(apolloPlan.getName())));
    properties.add(getAdditionalProperties());

    List events = apolloPlan.getEvents();
    for (Object event : events) {

      Component component = getVEvent(event);
      if (component != null) {
        icsCalendar.getComponents().add(component);
      }
    }
  }

  public String generate() {
    return icsCalendar.toString();
  }

  private Component getVEvent(Object zajecia) {
    Component event = new VEvent();
    PropertyList properties = event.getProperties();
    Date timeFrom = apolloPlan.getTimeFrom(zajecia);
    if (timeFrom == null) {
      return null;
    }
    try {
      properties.add(new XProperty("DTSTART;TZID=Europe/Warsaw", new DateTime(timeFrom).toString()));
    } catch (Exception e) {
      log.info("Time from: " + timeFrom);
    }
    Date timeTo = apolloPlan.getTimeTo(zajecia);
    if (timeTo == null) {
      return null;
    }
    try {
      properties.add(new XProperty("DTEND;TZID=Europe/Warsaw", new DateTime(timeTo).toString()));
    } catch (Exception e) {
      log.info("Time to: " + timeTo);

    }
    properties.add(new Summary(Lang.replaceSpecialChars(apolloPlan.getTitle(zajecia))));
    properties.add(new Description(Lang.replaceSpecialChars(apolloPlan.getDescription(zajecia))));
    properties.add(new Location(Lang.replaceSpecialChars(apolloPlan.getLocation(zajecia))));
    properties.add(new Sequence(0));
    properties.add(Clazz.PUBLIC);
    properties.add(Status.VEVENT_CONFIRMED);
    properties.add(Transp.TRANSPARENT);
    properties.add(new Uid(RandomStringUtils.randomAlphabetic(20)));
    return event;
  }

  private Property getAdditionalProperties() {
    String others = new StringBuilder()
      .append("X-WR-TIMEZONE:Europe/Warsaw\n")
      .append("BEGIN:VTIMEZONE\n")
      .append("TZID:Europe/Warsaw\n")
      .append("X-LIC-LOCATION:Europe/Warsaw\n")
      .append("BEGIN:DAYLIGHT\n")
      .append("TZOFFSETFROM:+0100\n")
      .append("TZOFFSETTO:+0200\n")
      .append("TZNAME:CEST\n")
      .append("DTSTART:19700329T020000\n")
      .append("RRULE:FREQ=YEARLY;BYMONTH=3;BYDAY=-1SU\n")
      .append("END:DAYLIGHT\n")
      .append("BEGIN:STANDARD\n")
      .append("TZOFFSETFROM:+0200\n")
      .append("TZOFFSETTO:+0100\n")
      .append("TZNAME:CET\n")
      .append("DTSTART:19701025T030000\n")
      .append("RRULE:FREQ=YEARLY;BYMONTH=10;BYDAY=-1SU\n")
      .append("END:STANDARD\n")
      .append("END").toString();
    return new XProperty(others, "VTIMEZONE");
  }
}
