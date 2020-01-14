package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties extends Properties {

    private static final String PROPERTIES_PATH = "src/main/resources/test.properties";
    private Properties currentProps = new Properties();

    /**
     * Read properties
     *
     * @return
     * @throws IOException
     */
    private Properties getCurrentProps() throws IOException {
        FileInputStream in = new FileInputStream(PROPERTIES_PATH);
        currentProps.load(in);
        in.close();
        return currentProps;
    }

    /**
     * Get property value
     *
     * @param propKey
     * @return
     * @throws IOException
     */
    protected String getProp(String propKey) throws IOException {
        if (!currentProps.containsKey(propKey)) {
            currentProps = getCurrentProps();
        }
        return currentProps.getProperty(propKey, null);
    }
}
