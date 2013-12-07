package pl.krakow.uek.knp.easyuekplan.actions;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

/**
 * Created on: 06.07.13 13:53 <br/>
 *
 * @author Slawomir Wojcicki
 */
@UrlBinding("/status")
public class StatusAction extends BaseAction {

  @DefaultHandler
  public Resolution execute() {
    return OK;
  }
}
