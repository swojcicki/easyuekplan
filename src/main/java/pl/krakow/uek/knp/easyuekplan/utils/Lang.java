package pl.krakow.uek.knp.easyuekplan.utils;

/**
 * Created on: 17.05.12 21:02 <br/>
 *
 * @author Slawomir Wojcicki
 */
public class Lang {

  public static String replaceSpecialChars(String string) {
    if (string == null) {
      return null;
    }
    string = string.replace("ą", "a");
    string = string.replace("Ą", "A");
    string = string.replace("ć", "c");
    string = string.replace("Ć", "C");
    string = string.replace("ę", "e");
    string = string.replace("Ę", "E");
    string = string.replace("ł", "l");
    string = string.replace("Ł", "L");
    string = string.replace("ń", "n");
    string = string.replace("Ń", "N");
    string = string.replace("ó", "o");
    string = string.replace("Ó", "O");
    string = string.replace("ś", "s");
    string = string.replace("Ś", "S");
    string = string.replace("ż", "z");
    string = string.replace("Ż", "Z");
    string = string.replace("ź", "z");
    string = string.replace("Ź", "Z");
    return string;
  }
}
