package utils;

import setup.PropertyFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties extends Properties {

    private Properties currentProps = new Properties();
    String propFile;

    protected void setPropertyFile(PropertyFile propertyFile) {
        propFile = propertyFile.getFileType();
    }

    /**
     * Read properties
     *
     * @return
     * @throws IOException
     */
    private Properties getCurrentProps() throws IOException {
        FileInputStream in = new FileInputStream(String.format("%s/%s", System.getProperty("user.dir"), propFile));
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
