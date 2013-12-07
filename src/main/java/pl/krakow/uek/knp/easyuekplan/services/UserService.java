package pl.krakow.uek.knp.easyuekplan.services;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pl.krakow.uek.knp.easyuekplan.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 * Created on: 05.04.13 14:24 <br/>
 *
 * @author Slawomir Wojcicki
 */
@Transactional(propagation = Propagation.REQUIRED)
public class UserService implements UserDetailsService {

  @PersistenceContext
  private EntityManager em;

  @Transactional(propagation = Propagation.SUPPORTS)
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
    try {
      return em.createQuery("select u from User u where u.username = :username", User.class)
        .setParameter("username", username).getSingleResult();
    } catch (UsernameNotFoundException e) {
      return new User();
    } catch (NoResultException e) {
      return new User();
    }
  }

  @Transactional(propagation = Propagation.SUPPORTS)
  public User loadUserByEmail(String email) {
    try {
      return em.createQuery("select u from User u where u.email = :email", User.class)
        .setParameter("email", email).getSingleResult();
    } catch (UsernameNotFoundException e) {
      return null;
    } catch (NoResultException e) {
      return null;
    }
  }

  public void create(User user) {
    String shaPassword = DigestUtils.shaHex(user.getPassword());
    user.setPassword(shaPassword);
    em.persist(user);
  }

  public String createNewPassword(String username) {
    String newPassword = RandomStringUtils.randomAlphanumeric(8);
    User loadUser = (User) loadUserByUsername(username);
    loadUser.setPassword(DigestUtils.shaHex(newPassword));
    em.merge(loadUser);
    return newPassword;
  }
}
