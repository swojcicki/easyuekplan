package pl.krakow.uek.knp.easyuekplan.services;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pl.krakow.uek.knp.easyuekplan.apollo.GroupPlan;
import pl.krakow.uek.knp.easyuekplan.apollo.OwnPlan;
import pl.krakow.uek.knp.easyuekplan.entities.Own;
import pl.krakow.uek.knp.easyuekplan.entities.User;
import pl.krakow.uek.knp.easyuekplan.utils.ICal;
import pl.krakow.uek.knp.easyuekplan.utils.JSON;
import pl.krakow.uek.knp.easyuekplan.utils.Lang;
import pl.krakow.uek.knp.easyuekplan.utils.VCS;
import pl.krakow.uek.knp.easyuekplan.xml.group.Zajecia;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.*;
import java.util.logging.Logger;

/**
 * Created on: 03.04.13 17:34 <br/>
 *
 * @author Slawomir Wojcicki
 */
@Transactional(propagation = Propagation.SUPPORTS)
public class OwnService {

  private static final Logger log = Logger.getLogger(GroupService.class.getName());

  @PersistenceContext
  private EntityManager em;

  private GroupService gs;
  private int expireDays;

  public OwnPlan getPlan(String publicKey) {
    Own own;

    try {
      own = em.createQuery("select o from Own o where o.publicKey like :publicKey", Own.class)
        .setParameter("publicKey", publicKey)
        .getSingleResult();
    } catch (NoResultException e) {
      return null;
    }

    List<Object> cumulative = new LinkedList<Object>();
    for (Integer remoteId : own.getRemoteIds()) {
      GroupPlan plan = gs.getPlan(remoteId);
      cumulative.addAll(plan.getEvents());
    }

    for (Iterator<Object> iterator = cumulative.iterator(); iterator.hasNext(); ) {
      Zajecia zajecia = (Zajecia) iterator.next();
      Calendar expireDate = Calendar.getInstance();
      expireDate.setTime(own.getCreation());
      expireDate.add(Calendar.DATE, expireDays);
      if (!own.isPaid() && zajecia.getTermin().toGregorianCalendar().after(expireDate)) {
        iterator.remove();
        continue;
      }
      for (String delRule : own.getDeleteRules()) {
        String str;
        if (StringUtils.isBlank(zajecia.getPrzedmiot())) {
          str = Lang.replaceSpecialChars("[" + zajecia.getTyp() + "]");
        } else {
          str = Lang.replaceSpecialChars("[" + zajecia.getTyp() + "] " + zajecia.getPrzedmiot());
        }
        if (str.equals(delRule)) {
          iterator.remove();
        }
      }
    }
    return new OwnPlan(own, cumulative);
  }

  public String getJSON(String username) throws Exception {
    List<Own> ownList = em.createQuery("select o from Own o left join o.user u where u.username like :username", Own.class)
      .setParameter("username", username)
      .getResultList();

    JSONArray jsonArray = new JSONArray();
    for (Own own : ownList) {
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("id", own.getId().toString());
      jsonObject.put("name", own.getName());
      jsonObject.put("creation", own.getCreation());
      if (!own.isPaid()) {
        jsonObject.put("expiredDays", calculateExpiredDays(own.getCreation()));
      }
      jsonObject.put("publicKey", own.getPublicKey());
      jsonArray.put(jsonObject);
    }
    return jsonArray.toString();
  }

  public String getDistinctRemote(Integer ownId, String username) throws Exception {
    Own own = em.find(Own.class, ownId);
    if (own == null || !own.getUser().getUsername().equals(username)) {
      throw new SecurityException();
    }

    List<Object> events = new LinkedList<Object>();
    for (Integer remoteId : own.getRemoteIds()) {
      GroupPlan plan = gs.getPlan(remoteId);
      events.addAll(plan.getEvents());
    }

    TreeMap<String, Zajecia> map = new TreeMap<String, Zajecia>();
    for (Object event1 : events) {
      Zajecia zajecia = (Zajecia) event1;
      map.put(zajecia.getPrzedmiot() + zajecia.getTyp(), zajecia);
    }

    JSONArray jsonArray = new JSONArray();
    for (Zajecia event : map.values()) {
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("przedmiot", Lang.replaceSpecialChars(event.getPrzedmiot()));
      jsonObject.put("typ", Lang.replaceSpecialChars(event.getTyp()));
      jsonArray.put(jsonObject);
    }
    return jsonArray.toString();
  }

  private int calculateExpiredDays(Date creation) {
    return (int) ((creation.getTime() - new Date().getTime()) / 1000 / 60 / 60 / 24 + expireDays);
  }

  public String getICal(OwnPlan ownPlan) {
    return new ICal(ownPlan).generate();
  }

  public String getVcs(OwnPlan ownPlan) {
    return new VCS(ownPlan).generate();
  }

  public String getJSON(OwnPlan ownPlan) {
    return new JSON(ownPlan).generate();
  }

  @Transactional(propagation = Propagation.REQUIRED)
  public String create(Own own, String username) {
    User user = em.createQuery("select u from User u where u.username like :username", User.class)
      .setParameter("username", username)
      .getSingleResult();
    own.setUser(user);
    Date creation = new Date();
    own.setCreation(creation);
    own.setPublicKey(DigestUtils.md5Hex(username + creation.getTime() + this.hashCode()));
    em.persist(own);
    return own.getId().toString();
  }

  @Transactional(propagation = Propagation.REQUIRED)
  public void delete(Integer ownId, String username) {
    Own own = em.find(Own.class, ownId);
    if (own != null && own.getUser().getUsername().equals(username)) {
      em.remove(own);
    } else {
      throw new SecurityException();
    }
  }

  @Transactional(propagation = Propagation.REQUIRED)
  public void updatePaid(boolean paid, String publicKey) {
    Own own;

    try {
      own = em.createQuery("select o from Own o where o.publicKey like :publicKey", Own.class)
        .setParameter("publicKey", publicKey)
        .getSingleResult();
    } catch (NoResultException e) {
      throw new SecurityException();
    }
    own.setPaid(paid);
    em.merge(own);
  }

  /*
   * todo remove na rzecz informacji o płatnosci
   */
  @Transactional(propagation = Propagation.REQUIRED)
  public void deleteExpired() {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DATE, -expireDays);
    int removed = em.createQuery("delete from Own o where o.paid = :paid and o.creation < :expireDate")
      .setParameter("paid", false)
      .setParameter("expireDate", calendar.getTime())
      .executeUpdate();
    log.info("Number of removed plans is: " + removed);
  }

  @Transactional(propagation = Propagation.REQUIRED)
  public void remrule(Integer ownId, Own o, String username) {
    Own own = em.find(Own.class, ownId);
    if (own == null || !own.getUser().getUsername().equals(username)) {
      throw new SecurityException();
    }
    own.setDeleteRules(o.getDeleteRules());
    em.merge(own);
  }

  public void setGs(GroupService gs) {
    this.gs = gs;
  }

  public void setExpireDays(int expireDays) {
    this.expireDays = expireDays;
  }
}
