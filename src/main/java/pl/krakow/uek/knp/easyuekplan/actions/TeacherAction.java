package pl.krakow.uek.knp.easyuekplan.actions;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.integration.spring.SpringBean;
import pl.krakow.uek.knp.easyuekplan.apollo.TeacherPlan;
import pl.krakow.uek.knp.easyuekplan.resolutions.CalResolution;
import pl.krakow.uek.knp.easyuekplan.resolutions.JsonResolution;
import pl.krakow.uek.knp.easyuekplan.resolutions.VcsResolution;
import pl.krakow.uek.knp.easyuekplan.services.TeacherService;

/**
 * Created on: 06.03.13 15:27 <br/>
 *
 * @author Slawomir Wojcicki
 */
@UrlBinding("/teacher/{teacherId}.{$event}")
public class TeacherAction extends BaseAction {

  @SpringBean("teacherService")
  private TeacherService teacherService;

  private Integer teacherId;

  @DefaultHandler
  public Resolution execute() {
    return INVALID_PARAMETERS_RESOLUTION;
  }

  public Resolution ics() {
    if (teacherId == null) {
      return INVALID_PARAMETERS_RESOLUTION;
    }
    TeacherPlan plan = teacherService.getPlan(teacherId);
    String cal = teacherService.getICal(plan);
    return new CalResolution(isGc(), cal, plan.getName());
  }

  public Resolution vcs() {
    if (teacherId == null) {
      return INVALID_PARAMETERS_RESOLUTION;
    }
    TeacherPlan plan = teacherService.getPlan(teacherId);
    String cal = teacherService.getVcs(plan);
    return new VcsResolution(cal, plan.getName());
  }

  public Resolution json() {
    if (teacherId == null) {
      return INVALID_PARAMETERS_RESOLUTION;
    }
    TeacherPlan plan = teacherService.getPlan(teacherId);
    return new JsonResolution(teacherService.getJSON(plan));
  }

  public void setTeacherId(Integer teacherId) {
    this.teacherId = teacherId;
  }

}
