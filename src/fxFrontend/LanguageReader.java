package fxFrontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * @author davidyan
 */
public class LanguageReader {
    private static final String FOLDER = "languagefiles/";
    private static final String SUFFIX = ".properties";
    private static final String LOAD_FAIL = "Could not load lang file: %s";
    Properties myProperties;
    private InputStream myFileStream;

    public void load (String language) throws IOException {
        String filename = FOLDER + language + SUFFIX;
        myFileStream = getClass().getClassLoader().getResourceAsStream(filename);
        if (myFileStream == null) {
            throw new FileNotFoundException(String.format(LOAD_FAIL, filename));
        }
        myProperties = new Properties();
        myProperties.load(myFileStream);
    }

    public String getString (String key) {
        return myProperties.getProperty(key);
    }

}
