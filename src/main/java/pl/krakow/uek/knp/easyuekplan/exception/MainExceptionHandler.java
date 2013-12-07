package pl.krakow.uek.knp.easyuekplan.exception;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ErrorResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.controller.StripesConstants;
import net.sourceforge.stripes.exception.DefaultExceptionHandler;
import net.sourceforge.stripes.exception.StripesServletException;
import pl.krakow.uek.knp.easyuekplan.utils.Mailer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

/**
 * Created on: 07.07.13 22:11 <br/>
 *
 * @author Slawomir Wojcicki
 */
public class MainExceptionHandler extends DefaultExceptionHandler {

  private static final Logger log = Logger.getLogger(MainExceptionHandler.class.getName());

  public Resolution handleGeneric(Exception exc, HttpServletRequest request, HttpServletResponse response) throws StripesServletException {

    ActionBean bean = (ActionBean) request.getAttribute(StripesConstants.REQ_ATTR_ACTION_BEAN);

    if (bean != null && !bean.getContext().getValidationErrors().isEmpty()) {
      request.setAttribute(StripesConstants.REQ_ATTR_ACTION_BEAN, null);
      return new ErrorResolution(HttpServletResponse.SC_BAD_REQUEST, "Invalid parameters.");
    }

    String subject;
    if (exc.getMessage() != null) {
      log.warning(exc.getMessage());
      subject = exc.getMessage();
    } else {
      log.warning(exc.getClass().getName());
      subject = exc.getClass().getName();
    }
    String message = "Unhandled exception in exception handler.";
    Mailer.send("easyuekplan@gmail.com", "slawek.wojcicki@gmail.com", message, subject);
    throw new StripesServletException(message, exc);
  }
}
