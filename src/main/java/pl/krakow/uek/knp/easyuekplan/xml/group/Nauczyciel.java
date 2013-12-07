package pl.krakow.uek.knp.easyuekplan.xml.group;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType>
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="moodle" type="{http://www.w3.org/2001/XMLSchema}short" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
  "value"
})
@XmlRootElement(name = "nauczyciel")
public class Nauczyciel {

  @XmlValue
  protected String value;
  @XmlAttribute
  protected Short moodle;

  /**
   * Gets the value of the value property.
   *
   * @return possible object is
   *         {@link String }
   */
  public String getValue() {
    return value;
  }

  /**
   * Sets the value of the value property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setValue(String value) {
    this.value = value;
  }

  /**
   * Gets the value of the moodle property.
   *
   * @return possible object is
   *         {@link Short }
   */
  public Short getMoodle() {
    return moodle;
  }

  /**
   * Sets the value of the moodle property.
   *
   * @param value allowed object is
   *              {@link Short }
   */
  public void setMoodle(Short value) {
    this.moodle = value;
  }

}
