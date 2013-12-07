package pl.krakow.uek.knp.easyuekplan.utils;

import junit.framework.Assert;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * Created on: 05.04.13 21:24 <br/>
 *
 * @author Slawomir Wojcicki
 */
public class ShaTest {

  @Test
  public void testSha() {
    String expected = "7288edd0fc3ffcbe93a0cf06e3568e28521687bc";
    String input = "test123";
    String actual = DigestUtils.shaHex(input);
    Assert.assertEquals(expected, actual);
  }
}
