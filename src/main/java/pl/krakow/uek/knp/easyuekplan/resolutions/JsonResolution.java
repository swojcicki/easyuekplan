package pl.krakow.uek.knp.easyuekplan.resolutions;

import net.sourceforge.stripes.action.StreamingResolution;
import pl.krakow.uek.knp.easyuekplan.utils.ContentType;

/**
 * Created on: 06.03.13 12:12 <br/>
 *
 * @author Slawomir Wojcicki
 */
public class JsonResolution extends StreamingResolution {

  public JsonResolution(String json) {
    super(ContentType.JSON, json);
    super.setCharacterEncoding("UTF-8");
//    super.setLastModified() todo
  }

}
