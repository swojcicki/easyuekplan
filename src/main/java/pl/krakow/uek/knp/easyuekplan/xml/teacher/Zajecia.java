package pl.krakow.uek.knp.easyuekplan.xml.teacher;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element ref="{}termin"/>
 *         &lt;element ref="{}dzien"/>
 *         &lt;element ref="{}od-godz"/>
 *         &lt;element ref="{}do-godz"/>
 *         &lt;element ref="{}przedmiot"/>
 *         &lt;element ref="{}typ"/>
 *         &lt;element ref="{}sala"/>
 *         &lt;element ref="{}grupa"/>
 *         &lt;element ref="{}uwagi" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
  "termin",
  "dzien",
  "odGodz",
  "doGodz",
  "przedmiot",
  "typ",
  "sala",
  "grupa",
  "uwagi"
})
@XmlRootElement(name = "zajecia")
public class Zajecia {

  @XmlElement(required = true)
  @XmlSchemaType(name = "date")
  protected XMLGregorianCalendar termin;
  @XmlElement(required = true)
  protected String dzien;
  @XmlElement(name = "od-godz", required = true)
  protected String odGodz;
  @XmlElement(name = "do-godz", required = true)
  protected String doGodz;
  @XmlElement(required = true)
  protected String przedmiot;
  @XmlElement(required = true)
  protected String typ;
  @XmlElement(required = true)
  protected String sala;
  @XmlElement(required = true)
  protected String grupa;
  protected String uwagi;

  /**
   * Gets the value of the termin property.
   *
   * @return possible object is
   *         {@link XMLGregorianCalendar }
   */
  public XMLGregorianCalendar getTermin() {
    return termin;
  }

  /**
   * Sets the value of the termin property.
   *
   * @param value allowed object is
   *              {@link XMLGregorianCalendar }
   */
  public void setTermin(XMLGregorianCalendar value) {
    this.termin = value;
  }

  /**
   * Gets the value of the dzien property.
   *
   * @return possible object is
   *         {@link String }
   */
  public String getDzien() {
    return dzien;
  }

  /**
   * Sets the value of the dzien property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setDzien(String value) {
    this.dzien = value;
  }

  /**
   * Gets the value of the odGodz property.
   *
   * @return possible object is
   *         {@link String }
   */
  public String getOdGodz() {
    return odGodz;
  }

  /**
   * Sets the value of the odGodz property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setOdGodz(String value) {
    this.odGodz = value;
  }

  /**
   * Gets the value of the doGodz property.
   *
   * @return possible object is
   *         {@link String }
   */
  public String getDoGodz() {
    return doGodz;
  }

  /**
   * Sets the value of the doGodz property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setDoGodz(String value) {
    this.doGodz = value;
  }

  /**
   * Gets the value of the przedmiot property.
   *
   * @return possible object is
   *         {@link String }
   */
  public String getPrzedmiot() {
    return przedmiot;
  }

  /**
   * Sets the value of the przedmiot property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setPrzedmiot(String value) {
    this.przedmiot = value;
  }

  /**
   * Gets the value of the typ property.
   *
   * @return possible object is
   *         {@link String }
   */
  public String getTyp() {
    return typ;
  }

  /**
   * Sets the value of the typ property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setTyp(String value) {
    this.typ = value;
  }

  /**
   * Gets the value of the sala property.
   *
   * @return possible object is
   *         {@link String }
   */
  public String getSala() {
    return sala;
  }

  /**
   * Sets the value of the sala property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setSala(String value) {
    this.sala = value;
  }

  /**
   * Gets the value of the grupa property.
   *
   * @return possible object is
   *         {@link String }
   */
  public String getGrupa() {
    return grupa;
  }

  /**
   * Sets the value of the grupa property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setGrupa(String value) {
    this.grupa = value;
  }

  /**
   * Gets the value of the uwagi property.
   *
   * @return possible object is
   *         {@link String }
   */
  public String getUwagi() {
    return uwagi;
  }

  /**
   * Sets the value of the uwagi property.
   *
   * @param value allowed object is
   *              {@link String }
   */
  public void setUwagi(String value) {
    this.uwagi = value;
  }

}
