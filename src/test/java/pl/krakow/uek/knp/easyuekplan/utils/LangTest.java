package pl.krakow.uek.knp.easyuekplan.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created on: 26.02.13 16:55 <br/>
 *
 * @author Slawomir Wojcicki
 */
public class LangTest {

  @Test
  public void testReplaceSpecialChars() throws Exception {
    String input = "ąĄćĆęĘłŁńŃóÓśŚżŻźŹ";
    String expected = "aAcCeElLnNoOsSzZzZ";
    String actual = Lang.replaceSpecialChars(input);
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testNullReplaceSpecialChars() throws Exception {
    String input = null;
    String expected = null;
    String actual = Lang.replaceSpecialChars(input);
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testNothingReplaceSpecialChars() throws Exception {
    String input = "aAcCeElLnNoOsSzZzZ";
    String expected = "aAcCeElLnNoOsSzZzZ";
    String actual = Lang.replaceSpecialChars(input);
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testEmptyReplaceSpecialChars() throws Exception {
    String input = "";
    String expected = "";
    String actual = Lang.replaceSpecialChars(input);
    Assert.assertEquals(expected, actual);
  }
}

