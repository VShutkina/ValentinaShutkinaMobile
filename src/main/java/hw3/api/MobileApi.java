package hw3.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

import java.io.File;
import java.nio.charset.Charset;
import java.util.HashMap;

import static io.restassured.http.ContentType.JSON;
import static io.restassured.http.Method.POST;
import static org.hamcrest.Matchers.lessThan;

/**
 * This class describes REAST API for integration with EPAM Mobile Cloud
 */
public class MobileApi {

    private static final String baseUrl = "https://mobilecloud.epam.com/automation/api/";
    private String path = "";
    private File multipart;
    private Method method = POST;
    private ContentType contentType = JSON;
    private Charset charset = Charset.defaultCharset();
    private HashMap<String, String> params = new HashMap<String, String>();

    private MobileApi() {
    }

    // Request builder for work with mobile cloud
    public static RequestBuilder with() {
        MobileApi api = new MobileApi();
        return new RequestBuilder(api);
    }

    public static ResponseSpecification successResponse() {
        return new ResponseSpecBuilder()
                .expectContentType(JSON)
                .expectResponseTime(lessThan(2000L))
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }

    public static RequestSpecification baseRequestConfiguration(String token) {
        // token = TokenReader.getToken().getProperty("token");
        return new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setRelaxedHTTPSValidation()
                .addHeader("Authorization", String.format("Bearer %s", token))
                .build();

    }

    public static class RequestBuilder {
        MobileApi mobileApi;

        public RequestBuilder(MobileApi mobileApi) {
            this.mobileApi = mobileApi;
        }

        public RequestBuilder method(Method method) {
            mobileApi.method = method;
            return this;
        }

        public RequestBuilder path(String path) {
            mobileApi.path = path;
            return this;
        }

        public RequestBuilder multipart(File file) {
            mobileApi.multipart = file;
            return this;
        }

        public RequestBuilder contentType(ContentType contentType) {
            mobileApi.contentType = contentType;
            return this;
        }

        public Response callApi(String token) {
            RequestSpecification spec = baseRequestConfiguration(token);
            if (mobileApi.multipart != null) {
                spec.multiPart("file", mobileApi.multipart);
            } else {
                spec.contentType(mobileApi.contentType.withCharset(mobileApi.charset.name()));
            }
            return RestAssured.with()
                    .queryParams(mobileApi.params)
                    .spec(spec)
                    .log().all()
                    .request(mobileApi.method, String.format("%s%s", baseUrl, mobileApi.path))
                    .prettyPeek();
        }
    }
}
