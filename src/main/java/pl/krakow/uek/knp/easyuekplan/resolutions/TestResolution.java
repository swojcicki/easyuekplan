package pl.krakow.uek.knp.easyuekplan.resolutions;

import net.sourceforge.stripes.action.StreamingResolution;
import pl.krakow.uek.knp.easyuekplan.utils.ContentType;

/**
 * Created on: 06.07.13 15:14 <br/>
 *
 * @author Slawomir Wojcicki
 */
public class TestResolution extends StreamingResolution {

  public TestResolution() {
    super(ContentType.TEXT_PLAIN, "This is test content");
    super.setCharacterEncoding("UTF-8");
  }
}
