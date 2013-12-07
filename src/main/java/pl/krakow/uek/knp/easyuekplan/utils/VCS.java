package pl.krakow.uek.knp.easyuekplan.utils;

import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.PropertyList;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.*;
import org.apache.commons.lang3.RandomStringUtils;
import pl.krakow.uek.knp.easyuekplan.apollo.ApolloPlan;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created on: 15.03.13 13:49 <br/>
 *
 * @author Slawomir Wojcicki
 */
public class VCS {

  private static final Logger log = Logger.getLogger(VCS.class.getName());

  private Calendar vcsCalendar;
  private ApolloPlan apolloPlan;

  public VCS(ApolloPlan plan) {
    this.vcsCalendar = new Calendar();
    this.apolloPlan = plan;

    PropertyList properties = vcsCalendar.getProperties();
    properties.add(new XProperty("VERSION", "1.0"));

    List events = apolloPlan.getEvents();
    for (Object event : events) {

      Component component = getVEvent(event);
      if (component != null) {
        vcsCalendar.getComponents().add(component);
      }
    }
  }

  public String generate() {
    return vcsCalendar.toString();
  }

  /**
   * DTSTART:20110618T060000Z
   * DTEND:20110618T060000Z
   * UID:7yu
   * SUMMARY:A b c d
   * X-EPOCAGENDAENTRYTYPE:APPOINTMENT
   * CLASS:PRIVATE
   * SEQUENCE:0
   * X-METHOD:NONE
   * LAST-MODIFIED:20110616T172454Z
   * PRIORITY:2
   * X-SYMBIAN-LUID:1272
   */
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
    properties.add(new Uid(RandomStringUtils.randomAlphabetic(5)));
    properties.add(new Summary(Lang.replaceSpecialChars(apolloPlan.getTitle(zajecia))));
    properties.add(new Description(Lang.replaceSpecialChars(apolloPlan.getDescription(zajecia))));
    properties.add(new Location(Lang.replaceSpecialChars(apolloPlan.getLocation(zajecia))));
    properties.add(new XProperty("X-EPOCAGENDAENTRYTYPE", "APPOINTMENT"));
    properties.add(Clazz.PUBLIC);
    properties.add(new Sequence(0));
    properties.add(new XProperty("X-METHOD", "NONE"));
    properties.add(new XProperty("LAST-MODIFIED", new DateTime(new Date()).toString()));
    properties.add(new XProperty("PRIORITY", "2"));
    properties.add(new XProperty("X-SYMBIAN-LUID", RandomStringUtils.randomNumeric(4)));

    return event;
  }
}
