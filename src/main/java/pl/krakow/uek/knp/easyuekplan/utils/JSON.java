package pl.krakow.uek.knp.easyuekplan.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pl.krakow.uek.knp.easyuekplan.apollo.ApolloPlan;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created on: 06.03.13 09:45 <br/>
 *
 * @author Slawomir Wojcicki
 */
public class JSON {

  private static final Logger log = Logger.getLogger(JSON.class.getName());

  private JSONArray jsonArray;
  private ApolloPlan apolloPlan;

  public JSON(ApolloPlan apolloPlan) {
    jsonArray = new JSONArray();
    this.apolloPlan = apolloPlan;

    List events = apolloPlan.getEvents();
    int id = 1;
    for (Object event : events) {

      JSONObject jsonEvent;
      try {
        jsonEvent = getJsonEvent(id, event);
        if (jsonEvent != null) {
          jsonArray.put(jsonEvent);
          id++;
        }
      } catch (JSONException e) {
        log.warning("JSON exception");
      }

    }
  }

  public String generate() {
    return jsonArray.toString();
  }

  private JSONObject getJsonEvent(int id, Object event) throws JSONException {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("id", id);
    jsonObject.put("body", Lang.replaceSpecialChars(
      apolloPlan.getLocation(event) + " <br> " + apolloPlan.getDescription(event)));
    jsonObject.put("title", Lang.replaceSpecialChars(apolloPlan.getTitle(event)));
    Date timeFrom = apolloPlan.getTimeFrom(event);
    if (timeFrom == null) {
      return null;
    }
    jsonObject.put("start", Dates.iso(timeFrom));
    Date timeTo = apolloPlan.getTimeTo(event);
    if (timeTo == null) {
      return null;
    }
    jsonObject.put("end", Dates.iso(timeTo));
    return jsonObject;
  }

}
