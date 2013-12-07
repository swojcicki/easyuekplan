package pl.krakow.uek.knp.easyuekplan.utils;

import net.sourceforge.stripes.config.Configuration;
import net.sourceforge.stripes.localization.LocalizationBundleFactory;

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Created on: 18.07.13 20:33 <br/>
 *
 * @author Slawomir Wojcicki
 */
public class EmptyLocalizationBundleFactory implements LocalizationBundleFactory {

  private static ResourceBundle EMPTY = new ListResourceBundle() {

    protected Object[][] getContents() {
      return new Object[0][];
    }
  };

  public void init(Configuration configuration) throws Exception {
  }

  public ResourceBundle getErrorMessageBundle(Locale locale) throws MissingResourceException {
    return EMPTY;
  }

  public ResourceBundle getFormFieldBundle(Locale locale) throws MissingResourceException {
    return EMPTY;
  }
}
