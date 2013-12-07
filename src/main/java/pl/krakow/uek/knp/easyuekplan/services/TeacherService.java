package pl.krakow.uek.knp.easyuekplan.services;

import pl.krakow.uek.knp.easyuekplan.apollo.TeacherPlan;
import pl.krakow.uek.knp.easyuekplan.utils.EntityUrlBridge;
import pl.krakow.uek.knp.easyuekplan.utils.ICal;
import pl.krakow.uek.knp.easyuekplan.utils.JSON;
import pl.krakow.uek.knp.easyuekplan.utils.VCS;
import pl.krakow.uek.knp.easyuekplan.xml.config.Config;
import pl.krakow.uek.knp.easyuekplan.xml.teacher.PlanZajec;

import java.text.MessageFormat;
import java.util.logging.Logger;

/**
 * Created on: 17.05.12 20:25 <br/>
 *
 * @author Slawomir Wojcicki
 */
public class TeacherService {

  private static final Logger log = Logger.getLogger(TeacherService.class.getName());

  private Config config;

  public TeacherPlan getPlan(Integer teacherId) {
    String url = MessageFormat.format(config.getTeacherUrl(), teacherId.toString());
    PlanZajec plan = new EntityUrlBridge<PlanZajec>(url, PlanZajec.class).create();
    return new TeacherPlan(plan);
  }

  public String getICal(TeacherPlan teacherPlan) {
    return new ICal(teacherPlan).generate();
  }

  public String getVcs(TeacherPlan teacherPlan) {
    return new VCS(teacherPlan).generate();
  }

  public String getJSON(TeacherPlan teacherPlan) {
    return new JSON(teacherPlan).generate();
  }

  public void setConfig(Config config) {
    this.config = config;
  }
}
