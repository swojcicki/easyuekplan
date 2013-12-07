package pl.krakow.uek.knp.easyuekplan.services;

import pl.krakow.uek.knp.easyuekplan.apollo.GroupPlan;
import pl.krakow.uek.knp.easyuekplan.utils.EntityUrlBridge;
import pl.krakow.uek.knp.easyuekplan.utils.ICal;
import pl.krakow.uek.knp.easyuekplan.utils.JSON;
import pl.krakow.uek.knp.easyuekplan.utils.VCS;
import pl.krakow.uek.knp.easyuekplan.xml.config.Config;
import pl.krakow.uek.knp.easyuekplan.xml.group.PlanZajec;

import java.text.MessageFormat;
import java.util.logging.Logger;

/**
 * Created on: 17.05.12 18:06 <br/>
 *
 * @author Slawomir Wojcicki
 */
public class GroupService {

  private static final Logger log = Logger.getLogger(GroupService.class.getName());

  private Config config;

  public GroupPlan getPlan(Integer groupId) {
    String url = MessageFormat.format(config.getGroupUrl(), groupId.toString());
    PlanZajec plan = new EntityUrlBridge<PlanZajec>(url, PlanZajec.class).create();
    return new GroupPlan(plan);
  }

  public String getICal(GroupPlan groupPlan) {
    return new ICal(groupPlan).generate();
  }

  public String getVcs(GroupPlan groupPlan) {
    return new VCS(groupPlan).generate();
  }

  public String getJSON(GroupPlan groupPlan) {
    return new JSON(groupPlan).generate();
  }

  public void setConfig(Config config) {
    this.config = config;
  }
}
