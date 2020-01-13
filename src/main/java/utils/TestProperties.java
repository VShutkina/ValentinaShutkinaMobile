package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties extends Properties {

    protected static TestProperties testProperties;

    public static TestProperties getTestProperties() {
        if (testProperties == null) {
            testProperties = new TestProperties();
            try {
                testProperties.load(new FileInputStream("src/main/resources/test.properties"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return testProperties;
    }
}
