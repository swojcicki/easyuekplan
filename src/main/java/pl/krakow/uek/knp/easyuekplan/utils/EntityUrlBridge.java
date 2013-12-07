package pl.krakow.uek.knp.easyuekplan.utils;

import javax.xml.bind.JAXB;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

/**
 * Created on: 18.05.12 17:18 <br/>
 *
 * @author Slawomir Wojcicki
 */
public class EntityUrlBridge<T> {

  private static final Logger log = Logger.getLogger(EntityUrlBridge.class.getName());

  private URL url;
  private Class<T> clazz;

  public EntityUrlBridge(String urlString, Class<T> clazz) {
    this.clazz = clazz;
    try {
      this.url = new URL(urlString);
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }

  public T create() {
    try {
      return JAXB.unmarshal(url, clazz);
    } catch (Exception e) {
      log.warning("Unmarshaling URL faild: " + url);
      throw new RuntimeException(e);
    }
  }
}
