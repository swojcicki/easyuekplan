package pl.krakow.uek.knp.easyuekplan.xml.teacher;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


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
 *         &lt;element ref="{}okres" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}zajecia" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="typ" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="idcel" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="nazwa" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="od" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="do" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
  "okres",
  "zajecia"
})
@XmlRootElement(name = "plan-zajec")
public class PlanZajec {

  protected List<Okres> okres;
  protected List<Zajecia> zajecia;
  @XmlAttribute
  protected String typ;
  @XmlAttribute
  protected Short id;
  @XmlAttribute
  protected Short idcel;
  @XmlAttribute
  protected String nazwa;
  @XmlAttribute
  @XmlSchemaType(name = "date")
  protected XMLGregorianCalendar od;
  @XmlAttribute(name = "do")
  @XmlSchemaType(name = "date")
  protected XMLGregorianCalendar _do;

  /**
   * Gets the value of the okres property.
   * <p/>
   * <p/>
   * This accessor method returns a reference to the live list,
   * not a snapshot. Therefore any modification you make to the
   * returned list will be present inside the JAXB object.
   * This is why there is not a <CODE>set</CODE> method for the okres property.
   * <p/>
   * <p/>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getOkres().add(newItem);
   * </pre>
   * <p/>
   * <p/>
   * <p/>
   * Objects of the following type(s) are allowed in the list
   * {@link Okres }
   */
  public List<Okres> getOkres() {
    if (okres == null) {
      okres = new ArrayList<Okres>();
    }
    return this.okres;
  }

  /**
   * Gets the value of the zajecia property.
   * <p/>
   * <p/>
   * This accessor method returns a reference to the live list,
   * not a snapshot. Therefore any modification you make to the
   * returned list will be present inside the JAXB object.
   * This is why there is not a <CODE>set</CODE> method for the zajecia property.
   * <p/>
   * <p/>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getZajecia().add(newItem);
   * </pre>
   * <p/>
   * <p/>
   * <p/>
   * Objects of the following type(s) are allowed in the list
   * {@link Zajecia }
   */
  public List<Zajecia> getZajecia() {
    if (zajecia == null) {
      zajecia = new ArrayList<Zajecia>();
    }
    return this.zajecia;
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
   * Gets the value of the id property.
   *
   * @return possible object is
   *         {@link Short }
   */
  public Short getId() {
    return id;
  }

  /**
   * Sets the value of the id property.
   *
   * @param value allowed object is
   *              {@link Short }
   */
  public void setId(Short value) {
    this.id = value;
  }

  /**
   * Gets the value of the idcel property.
   *
   * @return possible object is
   *         {@link Short }
   */
  public Short getIdcel() {
    return idcel;
  }

  /**
   * Sets the value of the idcel property.
   *
   * @param value allowed object is
   *              {@link Short }
   */
  public void setIdcel(Short value) {
    this.idcel = value;
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

}
