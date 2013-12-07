package pl.krakow.uek.knp.easyuekplan.resolutions;

import net.sourceforge.stripes.action.StreamingResolution;
import pl.krakow.uek.knp.easyuekplan.utils.ContentType;

/**
 * Created on: 06.03.13 20:07 <br/>
 *
 * @author Slawomir Wojcicki
 */
public class CalResolution extends StreamingResolution {

  public CalResolution(boolean gc, String cal, String name) {
    super(ContentType.TEXT_CALENDAR, cal);
    super.setCharacterEncoding("UTF-8");
//    super.setLastModified()todo
    if (!gc) {
      super.setFilename(new StringBuilder().append(name).append(".ics").toString());
    }
  }

}
