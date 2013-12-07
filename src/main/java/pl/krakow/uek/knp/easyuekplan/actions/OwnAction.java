package pl.krakow.uek.knp.easyuekplan.actions;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.StreamingResolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.integration.spring.SpringBean;
import pl.krakow.uek.knp.easyuekplan.entities.Own;
import pl.krakow.uek.knp.easyuekplan.resolutions.JsonResolution;
import pl.krakow.uek.knp.easyuekplan.services.OwnService;
import pl.krakow.uek.knp.easyuekplan.utils.ContentType;

import java.util.logging.Logger;

/**
 * Created on: 03.04.13 17:23 <br/>
 *
 * @author Slawomir Wojcicki
 */
@UrlBinding("/own/{ownId}.{$event}")
public class OwnAction extends BaseAction {

  private static final Logger log = Logger.getLogger(OwnAction.class.getName());

  @SpringBean("ownService")
  private OwnService ownService;

  private Integer ownId;
  private Own o;

  /**
   * .create?o.name=test&o.remoteIds=3243&o.remoteIds=6599
   *
   * @return
   */
  public Resolution create() { /*create*/
    if (!isPost()) {
      return METHOD_NOT_ALLOWED;
    }
    try {
      String id = ownService.create(o, getUsername());
      return new StreamingResolution(ContentType.TEXT_PLAIN, id);
    } catch (Exception e) {
      log.warning(e.getMessage());
      return CONFLICT_RESOLUTION;
    }
  }

  public Resolution remrule() {
    if (!isPost()) {
      return METHOD_NOT_ALLOWED;
    }
    if (ownId == null) {
      return INVALID_PARAMETERS_RESOLUTION;
    }
    try {
      ownService.remrule(ownId, o, getUsername());
      return OK;
    } catch (Exception e) {
      logRemruleException(e, o, ownId);
      return CONFLICT_RESOLUTION;
    }
  }

  private void logRemruleException(Exception e, Own o, Integer ownId) {
    if (e == null) {
      log.warning("e is null");
    } else {
      if (e.getClass() == null) {
        log.warning("e.getClass() is null");
      } else {
        log.warning(e.getClass().toString());
      }
      log.warning(e.getMessage());
    }
    log.warning("ownId: " + ownId);
    log.warning("username: " + getUsername());
    if (o == null) {
      log.warning("o is null");
    } else {
      log.warning(o.getPublicKey());
    }
  }

  @DefaultHandler
  public Resolution execute() { /*read*/
    if (!isPost()) {
      return METHOD_NOT_ALLOWED;
    }
    try {
      return new JsonResolution(ownService.getJSON(getUsername()));
    } catch (Exception e) {
      log.warning(e.getMessage());
      return CONFLICT_RESOLUTION;
    }
  }

  public Resolution delete() { /*delete*/
    if (!isPost()) {
      return METHOD_NOT_ALLOWED;
    }
    if (ownId == null) {
      return INVALID_PARAMETERS_RESOLUTION;
    }
    try {
      ownService.delete(ownId, getUsername());
    } catch (Exception e) {
      log.warning(e.getMessage());
      return CONFLICT_RESOLUTION;
    }
    return OK;
  }

  public Resolution distinct() { /*read*/
    if (!isPost()) {
      return METHOD_NOT_ALLOWED;
    }
    if (ownId == null) {
      return INVALID_PARAMETERS_RESOLUTION;
    }
    try {
      return new JsonResolution(ownService.getDistinctRemote(ownId, getUsername()));
    } catch (Exception e) {
      log.warning(e.getMessage());
      return CONFLICT_RESOLUTION;
    }
  }

  public Own getO() {
    return o;
  }

  public void setO(Own o) {
    this.o = o;
  }

  public void setOwnId(Integer ownId) {
    this.ownId = ownId;
  }
}
