package pl.krakow.uek.knp.easyuekplan.utils;

import net.sourceforge.stripes.action.Resolution;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on: 04.04.13 22:33 <br/>
 *
 * @author Slawomir Wojcicki
 */
public class RestSuccess implements AuthenticationSuccessHandler, LogoutSuccessHandler, Resolution {

  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
    response.setStatus(HttpServletResponse.SC_OK);
  }

  public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
    response.setStatus(HttpServletResponse.SC_OK);
  }

  public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    response.setStatus(HttpServletResponse.SC_OK);
  }
}
