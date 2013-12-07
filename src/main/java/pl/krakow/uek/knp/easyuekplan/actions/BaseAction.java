package pl.krakow.uek.knp.easyuekplan.actions;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.ErrorResolution;
import net.sourceforge.stripes.action.Resolution;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import pl.krakow.uek.knp.easyuekplan.utils.RestSuccess;

import javax.servlet.http.HttpServletResponse;

/**
 * Created on: 17.05.12 22:38 <br/>
 *
 * @author Slawomir Wojcicki
 */
public class BaseAction implements ActionBean {

  public static final ErrorResolution CONFLICT_RESOLUTION = new ErrorResolution(HttpServletResponse.SC_CONFLICT);
  public static final ErrorResolution INVALID_PARAMETERS_RESOLUTION = new ErrorResolution(HttpServletResponse.SC_BAD_REQUEST, "Invalid parameters.");
  public static final ErrorResolution UNAUTHORIZED = new ErrorResolution(HttpServletResponse.SC_UNAUTHORIZED);
  public static final ErrorResolution METHOD_NOT_ALLOWED = new ErrorResolution(HttpServletResponse.SC_METHOD_NOT_ALLOWED);

  public static final Resolution OK = new RestSuccess();

  private ActionBeanContext context;
  private boolean gc = false;

  public boolean isGc() {
    return gc;
  }

  public void setGc(boolean gc) {
    this.gc = gc;
  }

  public void setContext(ActionBeanContext context) {
    this.context = context;
  }

  public ActionBeanContext getContext() {
    return context;
  }

  protected String getMethod() {
    return context.getRequest().getMethod();
  }

  protected boolean isPost() {
    return getMethod().equals("POST");
  }

  protected String getUsername() {
    final SecurityContext securityContext = SecurityContextHolder.getContext();
    if (securityContext == null) {
      return StringUtils.EMPTY;
    }
    Authentication auth = securityContext.getAuthentication();
    if (auth == null) {
      return StringUtils.EMPTY;
    }
    return auth.getName(); //get logged in username
  }
}
