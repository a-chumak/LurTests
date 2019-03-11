package libs;

/*
 *  That class provides static methods for getting values from Config and UI mapping files
 */

import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class ConfigData {

    public static String uiMappingFile = "src/UIMapping.properties";    //class variable added (path to the file)
    public static String cfgFile = "src/config.properties";    //class variable added (path to the file)

    /*
     * Return value from .properties file
     */
    public static String getValueFromFile(String key, String fileName) {

        Properties p = new Properties(); //The Properties class represents a persistent set of properties. The Properties can be saved to a stream or loaded from a stream. Each key and its corresponding value in the property list is a string.

        // Create stream for reading from file
        FileInputStream cfg = null; //A FileInputStream obtains input bytes
        try {
            cfg = new FileInputStream(fileName);
            p.load(cfg);
            cfg.close();
        } catch (FileNotFoundException e) {
            Assert.fail("File not found exception");
        } catch (IOException e) {
            Assert.fail("IO exception");
        }
        // from a file in a file system. FileInputStream is meant for reading streams of raw bytes such as image data. For reading streams of characters, consider using FileReader.
        // Load Properties from input stream


        // Return value for the property
        String propertyValue = "";
        try {

            propertyValue = new String(p.getProperty(key).getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return propertyValue;
    }

    /*
     * Return value from UI mapping file. Note, please, that returned value is
     * String. We should take care of value's type by himself when will use
     * config data value in the test.
     */
    public static String getUiMappingValue(String key) {

        return (getValueFromFile(key, uiMappingFile));
    }

    /*
     * Return value from config file. Note, please, that returned value is
     * String. We should take care of value's type by himself when will use
     * config data value in the test.
     */
    public static String getCfgValue(String key) {

        //class variable added (path to the file)

        return (getValueFromFile(key, cfgFile));
    }

    /*
     * Return By class with finding method and target for WebElement from UI mapping file
     */
    public static By ui(String key) {
        // Get WebElement's locator from UI mapping file and divide it to
        // finding method and target
        key = key.replaceAll(" ", "");
        String[] partsOfLocator = new String[2];
        partsOfLocator = getValueFromFile(key, uiMappingFile).split("\"");
        String findMethod = partsOfLocator[0].substring(0,
                partsOfLocator[0].length() - 1);
        String target = partsOfLocator[1];

        // Return By class with appropriate method and target
        By by = findMethod(findMethod, target);
        return by;
    }

    public static String iPath(String key) {

        String[] partsOfLocator;

        partsOfLocator = getValueFromFile(key, uiMappingFile).split("\"");

        // Return By class with appropriate method and target
        return partsOfLocator[1];
    }

    private static By findMethod (String findMethod, String target) {

        // Return By class with appropriate method and target
        if (findMethod.equals("xpath"))
            return By.xpath(target);
        else if (findMethod.equals("id"))
            return By.id(target);
        else if (findMethod.equals("name"))
            return By.name(target);
        else if (findMethod.equals("linkText"))
            return By.linkText(target);
        else if (findMethod.equals("tagName"))
            return By.tagName(target);
        else if (findMethod.equals("className"))
            return By.className(target);
        else if (findMethod.equals("cssSelector"))
            return By.cssSelector(target);
        else
            return By.partialLinkText(target);
    }

}
