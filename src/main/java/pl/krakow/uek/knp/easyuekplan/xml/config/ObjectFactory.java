package pl.krakow.uek.knp.easyuekplan.xml.config;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the pl.krakow.uek.knp.easyuekplan.xml.config package.
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

  private final static QName _TeacherUrl_QNAME = new QName("", "teacher-url");
  private final static QName _GroupUrl_QNAME = new QName("", "group-url");

  /**
   * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.krakow.uek.knp.easyuekplan.xml.config
   */
  public ObjectFactory() {
  }

  /**
   * Create an instance of {@link Config }
   */
  public Config createConfig() {
    return new Config();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   */
  @XmlElementDecl(namespace = "", name = "teacher-url")
  public JAXBElement<String> createTeacherUrl(String value) {
    return new JAXBElement<String>(_TeacherUrl_QNAME, String.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   */
  @XmlElementDecl(namespace = "", name = "group-url")
  public JAXBElement<String> createGroupUrl(String value) {
    return new JAXBElement<String>(_GroupUrl_QNAME, String.class, null, value);
  }

}
