package hw3.api;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class get token from common.properties file
 */
public class TokenReader extends Properties {

    private static TokenReader token;

    public static TokenReader getToken() {
        if (token == null) {
            token = new TokenReader();
            try {
                token.load(new FileInputStream(
                        String.format("%s/%s", System.getProperty("user.dir"), "common.properties")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return token;
    }

    public String replacePlaceholder(String input) {
        return input.replace("{token}", (CharSequence) token);
    }
}
