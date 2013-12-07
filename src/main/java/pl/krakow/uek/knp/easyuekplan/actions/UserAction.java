package pl.krakow.uek.knp.easyuekplan.actions;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.HandlesEvent;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.integration.spring.SpringBean;
import org.apache.commons.lang3.StringUtils;
import pl.krakow.uek.knp.easyuekplan.entities.User;
import pl.krakow.uek.knp.easyuekplan.services.UserService;
import pl.krakow.uek.knp.easyuekplan.utils.Mailer;

/**
 * Created on: 04.04.13 17:46 <br/>
 *
 * @author Slawomir Wojcicki
 */
@UrlBinding("/user/{$event}")
public class UserAction extends BaseAction {

  @SpringBean("userService")
  private UserService userService;

  private User u;

  @DefaultHandler
  public Resolution execute() {
    return INVALID_PARAMETERS_RESOLUTION;
  }

  public Resolution register() { /*create*/
    if (!isPost()) {
      return METHOD_NOT_ALLOWED;
    }
    if (u == null) {
      return INVALID_PARAMETERS_RESOLUTION;
    }
    if (StringUtils.isBlank(u.getUsername())) {
      return INVALID_PARAMETERS_RESOLUTION;
    }
    if (StringUtils.isBlank(u.getPassword())) {
      return INVALID_PARAMETERS_RESOLUTION;
    }
    try {
      userService.create(u);
      return OK;
    } catch (Exception e) {
      return CONFLICT_RESOLUTION; //already exists
    }
  }

  @HandlesEvent("new-password")
  public Resolution resetPassword() {
    if (u == null || u.getEmail() == null) {
      return INVALID_PARAMETERS_RESOLUTION;
    }
    u = userService.loadUserByEmail(u.getEmail());
    if (u == null) {
      return CONFLICT_RESOLUTION;
    }
    String newPassword = userService.createNewPassword(u.getUsername());

    Mailer.send("easyuekplan@gmail.com", u.getEmail(),
      "Nowe hasło easyuekplan.pl",
      "Hasło zostało zmienione.\n" +
        "Użytkownik: " + u.getUsername() + "\n" +
        "Hasło: " + newPassword + "\n" +
        "Adres: : http://easyuekplan.pl/\n" +
        "\n--\n" +
        "Pozdrawiamy\n" +
        "Zespół easyuekplan.pl"
    );
    return OK;
  }

  public User getU() {
    return u;
  }

  public void setU(User u) {
    this.u = u;
  }

}
