package pl.krakow.uek.knp.easyuekplan.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created on: 04.04.13 20:27 <br/>
 *
 * @author Slawomir Wojcicki
 */
@Entity
public class User implements Serializable, UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(unique = true, nullable = false)
  private String username;

  @Column(nullable = false)
  private String password;

  private String email;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Transient
  public boolean isAccountNonExpired() {
    return true;
  }

  @Transient
  public boolean isAccountNonLocked() {
    return true;
  }

  @Transient
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Transient
  public boolean isEnabled() {
    return true;
  }

  @Transient
  public Collection<GrantedAuthority> getAuthorities() {
    return new ArrayList<GrantedAuthority>();
  }
}
