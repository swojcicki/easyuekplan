package pl.krakow.uek.knp.easyuekplan.xml.config;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}group-url"/>
 *         &lt;element ref="{}teacher-url"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
  "groupUrl",
  "teacherUrl"
})
@XmlRootElement(name = "config")
public class Config {

  @XmlElement(name = "group-url", required = true)
  protected String groupUrl;
  @XmlElement(name = "teacher-url", required = true)
  protected String teacherUrl;

  /**
   * Gets the value of the groupUrl property.
   *
   * @return possible object is
   *         {@link String }
   */
  public String getGroupUrl() {
    return groupUrl;
  }

  /**
   * Sets the value of the groupUrl property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setGroupUrl(String value) {
    this.groupUrl = value;
  }

  /**
   * Gets the value of the teacherUrl property.
   *
   * @return possible object is
   *         {@link String }
   */
  public String getTeacherUrl() {
    return teacherUrl;
  }

  /**
   * Sets the value of the teacherUrl property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setTeacherUrl(String value) {
    this.teacherUrl = value;
  }

}
