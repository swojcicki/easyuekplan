package pl.krakow.uek.knp.easyuekplan.resolutions;

import net.sourceforge.stripes.action.StreamingResolution;
import pl.krakow.uek.knp.easyuekplan.utils.ContentType;

/**
 * Created on: 15.03.13 13:37 <br/>
 *
 * @author Slawomir Wojcicki
 */
public class VcsResolution extends StreamingResolution {

  public VcsResolution(String vcs, String name) {
    super(ContentType.TEXT_VCALENDAR, vcs);
    super.setCharacterEncoding("UTF-8");
//    super.setLastModified() todo
    super.setFilename(new StringBuilder().append(name).append(".vcs").toString());
  }
}
