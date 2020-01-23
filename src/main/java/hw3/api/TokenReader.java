package hw3.api;

import java.util.Properties;

/**
 * This class get token from common.properties file
 */
public class TokenReader extends Properties {

    private static String token;

    public static String getToken() {
        if (token == null) {
            token = System.getenv("TOKEN");

            //        if (token == null) {
//            token = new TokenReader();
//            try {
//                token.load(new FileInputStream(
//                        String.format("%s/%s", System.getProperty("user.dir"), "common.properties")));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return token;
        }
        return token;
    }

    public String replacePlaceholder(String input) {
        return input.replace("{token}", (CharSequence) token);
    }
}
