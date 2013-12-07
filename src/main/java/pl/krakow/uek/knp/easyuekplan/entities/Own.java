package pl.krakow.uek.knp.easyuekplan.entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created on: 07.04.13 20:36 <br/>
 *
 * @author Slawomir Wojcicki
 */
@Entity
public class Own implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(unique = true, nullable = false)
  private String name;

  @Column(unique = true, nullable = false)
  private String publicKey;

  @Column
  private Date creation;

  @Column
  private boolean paid;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(nullable = false, updatable = false)
  private User user;

  @ElementCollection(fetch = FetchType.LAZY)
  @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
  @JoinTable(
    name = "Remote",
    joinColumns = @JoinColumn(name = "own_id"),
    uniqueConstraints = {@UniqueConstraint(columnNames = {"own_id", "remote_id"})}
  )
  @Column(name = "remote_id")
  private Set<Integer> remoteIds;


  @ElementCollection(fetch = FetchType.LAZY)
  @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
  @JoinTable(
    name = "DelRule",
    joinColumns = @JoinColumn(name = "own_id"),
    uniqueConstraints = {@UniqueConstraint(columnNames = {"own_id", "del_rule_id"})}
  )
  @Column(name = "del_rule_id")
  private Set<String> deleteRules;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPublicKey() {
    return publicKey;
  }

  public void setPublicKey(String publicKey) {
    this.publicKey = publicKey;
  }

  public Date getCreation() {
    return creation;
  }

  public void setCreation(Date creation) {
    this.creation = creation;
  }

  public boolean isPaid() {
    return paid;
  }

  public void setPaid(boolean paid) {
    this.paid = paid;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Set<Integer> getRemoteIds() {
    return remoteIds;
  }

  public void setRemoteIds(Set<Integer> remoteIds) {
    this.remoteIds = remoteIds;
  }

  public Set<String> getDeleteRules() {
    return deleteRules;
  }

  public void setDeleteRules(Set<String> deleteRules) {
    this.deleteRules = deleteRules;
  }
}
