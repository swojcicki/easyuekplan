package pl.krakow.uek.knp.easyuekplan.actions;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.integration.spring.SpringBean;
import pl.krakow.uek.knp.easyuekplan.apollo.GroupPlan;
import pl.krakow.uek.knp.easyuekplan.resolutions.CalResolution;
import pl.krakow.uek.knp.easyuekplan.resolutions.JsonResolution;
import pl.krakow.uek.knp.easyuekplan.resolutions.VcsResolution;
import pl.krakow.uek.knp.easyuekplan.services.GroupService;

/**
 * Created on: 06.03.13 15:08 <br/>
 *
 * @author Slawomir Wojcicki
 */
@UrlBinding("/group/{groupId}.{$event}")
public class GroupAction extends BaseAction {

  @SpringBean("groupService")
  private GroupService groupService;

  private Integer groupId;

  @DefaultHandler
  public Resolution execute() {
    return INVALID_PARAMETERS_RESOLUTION;
  }

  public Resolution ics() {
    if (groupId == null) {
      return INVALID_PARAMETERS_RESOLUTION;
    }
    GroupPlan plan = groupService.getPlan(groupId);
    String cal = groupService.getICal(plan);
    return new CalResolution(isGc(), cal, plan.getName());
  }

  public Resolution vcs() {
    if (groupId == null) {
      return INVALID_PARAMETERS_RESOLUTION;
    }
    GroupPlan plan = groupService.getPlan(groupId);
    String vcs = groupService.getVcs(plan);
    return new VcsResolution(vcs, plan.getName());
  }

  public Resolution json() {
    if (groupId == null) {
      return INVALID_PARAMETERS_RESOLUTION;
    }
    GroupPlan plan = groupService.getPlan(groupId);
    return new JsonResolution(groupService.getJSON(plan));
  }

  public void setGroupId(Integer groupId) {
    this.groupId = groupId;
  }

}
