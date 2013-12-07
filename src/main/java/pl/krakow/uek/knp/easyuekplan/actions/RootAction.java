package pl.krakow.uek.knp.easyuekplan.actions;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

/**
 * Created on: 06.03.13 22:36 <br/>
 *
 * @author Slawomir Wojcicki
 */
@UrlBinding("/")
public class RootAction extends BaseAction {

  @DefaultHandler
  public Resolution execute() {
    return INVALID_PARAMETERS_RESOLUTION;
  }

}
