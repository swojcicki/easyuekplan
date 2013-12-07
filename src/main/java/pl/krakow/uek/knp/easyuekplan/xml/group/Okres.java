package pl.krakow.uek.knp.easyuekplan.xml.group;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType>
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="od" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="do" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="nazwa" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="wybrany" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
  "value"
})
@XmlRootElement(name = "okres")
public class Okres {

  @XmlValue
  protected String value;
  @XmlAttribute
  @XmlSchemaType(name = "date")
  protected XMLGregorianCalendar od;
  @XmlAttribute(name = "do")
  @XmlSchemaType(name = "date")
  protected XMLGregorianCalendar _do;
  @XmlAttribute
  protected String nazwa;
  @XmlAttribute
  protected String wybrany;

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
   * Gets the value of the od property.
   *
   * @return possible object is
   *         {@link XMLGregorianCalendar }
   */
  public XMLGregorianCalendar getOd() {
    return od;
  }

  /**
   * Sets the value of the od property.
   *
   * @param value allowed object is
   *              {@link XMLGregorianCalendar }
   */
  public void setOd(XMLGregorianCalendar value) {
    this.od = value;
  }

  /**
   * Gets the value of the do property.
   *
   * @return possible object is
   *         {@link XMLGregorianCalendar }
   */
  public XMLGregorianCalendar getDo() {
    return _do;
  }

  /**
   * Sets the value of the do property.
   *
   * @param value allowed object is
   *              {@link XMLGregorianCalendar }
   */
  public void setDo(XMLGregorianCalendar value) {
    this._do = value;
  }

  /**
   * Gets the value of the nazwa property.
   *
   * @return possible object is
   *         {@link String }
   */
  public String getNazwa() {
    return nazwa;
  }

  /**
   * Sets the value of the nazwa property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setNazwa(String value) {
    this.nazwa = value;
  }

  /**
   * Gets the value of the wybrany property.
   *
   * @return possible object is
   *         {@link String }
   */
  public String getWybrany() {
    return wybrany;
  }

  /**
   * Sets the value of the wybrany property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setWybrany(String value) {
    this.wybrany = value;
  }

}
