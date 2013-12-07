package pl.krakow.uek.knp.easyuekplan.actions;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.integration.spring.SpringBean;
import org.apache.commons.lang3.StringUtils;
import pl.krakow.uek.knp.easyuekplan.apollo.OwnPlan;
import pl.krakow.uek.knp.easyuekplan.resolutions.CalResolution;
import pl.krakow.uek.knp.easyuekplan.resolutions.JsonResolution;
import pl.krakow.uek.knp.easyuekplan.resolutions.VcsResolution;
import pl.krakow.uek.knp.easyuekplan.services.OwnService;

/**
 * Created on: 10.04.13 21:37 <br/>
 *
 * @author Slawomir Wojcicki
 */
@UrlBinding("/public/{publicKey}.{$event}")
public class PublicAction extends BaseAction {

  @SpringBean("ownService")
  private OwnService ownService;

  private String publicKey;

  @DefaultHandler
  public Resolution execute() {
    return INVALID_PARAMETERS_RESOLUTION;
  }

  public Resolution ics() {
    if (StringUtils.isBlank(publicKey)) {
      return INVALID_PARAMETERS_RESOLUTION;
    }
    OwnPlan plan = ownService.getPlan(publicKey);
    if (plan == null) {
      return INVALID_PARAMETERS_RESOLUTION;
    }
    String cal = ownService.getICal(plan);
    return new CalResolution(isGc(), cal, plan.getName());
  }

  public Resolution vcs() {
    if (StringUtils.isBlank(publicKey)) {
      return INVALID_PARAMETERS_RESOLUTION;
    }
    OwnPlan plan = ownService.getPlan(publicKey);
    if (plan == null) {
      return INVALID_PARAMETERS_RESOLUTION;
    }
    String cal = ownService.getVcs(plan);
    return new VcsResolution(cal, plan.getName());
  }

  public Resolution json() {
    if (StringUtils.isBlank(publicKey)) {
      return INVALID_PARAMETERS_RESOLUTION;
    }
    OwnPlan plan = ownService.getPlan(publicKey);
    if (plan == null) {
      return INVALID_PARAMETERS_RESOLUTION;
    }
    String cal = ownService.getJSON(plan);
    return new JsonResolution(cal);
  }

  public void setPublicKey(String publicKey) {
    this.publicKey = publicKey;
  }
}
