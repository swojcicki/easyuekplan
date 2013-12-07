package pl.krakow.uek.knp.easyuekplan.xml.group;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the pl.krakow.uek.knp.easyuekplan.xml.group package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

  private final static QName _DoGodz_QNAME = new QName("", "do-godz");
  private final static QName _Termin_QNAME = new QName("", "termin");
  private final static QName _OdGodz_QNAME = new QName("", "od-godz");
  private final static QName _Sala_QNAME = new QName("", "sala");
  private final static QName _Typ_QNAME = new QName("", "typ");
  private final static QName _Przedmiot_QNAME = new QName("", "przedmiot");
  private final static QName _Dzien_QNAME = new QName("", "dzien");

  /**
   * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.krakow.uek.knp.easyuekplan.xml.group
   */
  public ObjectFactory() {
  }

  /**
   * Create an instance of {@link Nauczyciel }
   */
  public Nauczyciel createNauczyciel() {
    return new Nauczyciel();
  }

  /**
   * Create an instance of {@link Okres }
   */
  public Okres createOkres() {
    return new Okres();
  }

  /**
   * Create an instance of {@link PlanZajec }
   */
  public PlanZajec createPlanZajec() {
    return new PlanZajec();
  }

  /**
   * Create an instance of {@link Zajecia }
   */
  public Zajecia createZajecia() {
    return new Zajecia();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   */
  @XmlElementDecl(namespace = "", name = "do-godz")
  public JAXBElement<String> createDoGodz(String value) {
    return new JAXBElement<String>(_DoGodz_QNAME, String.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   */
  @XmlElementDecl(namespace = "", name = "termin")
  public JAXBElement<XMLGregorianCalendar> createTermin(XMLGregorianCalendar value) {
    return new JAXBElement<XMLGregorianCalendar>(_Termin_QNAME, XMLGregorianCalendar.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   */
  @XmlElementDecl(namespace = "", name = "od-godz")
  public JAXBElement<String> createOdGodz(String value) {
    return new JAXBElement<String>(_OdGodz_QNAME, String.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   */
  @XmlElementDecl(namespace = "", name = "sala")
  public JAXBElement<String> createSala(String value) {
    return new JAXBElement<String>(_Sala_QNAME, String.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   */
  @XmlElementDecl(namespace = "", name = "typ")
  public JAXBElement<String> createTyp(String value) {
    return new JAXBElement<String>(_Typ_QNAME, String.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   */
  @XmlElementDecl(namespace = "", name = "przedmiot")
  public JAXBElement<String> createPrzedmiot(String value) {
    return new JAXBElement<String>(_Przedmiot_QNAME, String.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   */
  @XmlElementDecl(namespace = "", name = "dzien")
  public JAXBElement<String> createDzien(String value) {
    return new JAXBElement<String>(_Dzien_QNAME, String.class, null, value);
  }

}
