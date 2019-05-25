package services;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import javax.inject.Inject;
import javax.inject.Singleton;

import play.libs.ws.WSBodyReadables;
import play.libs.ws.WSClient;

/**
 * Service that authenticates the connection to the Twitter API
 * @author Dhruv Bhalodi
 * @version 1.0.0
 */

@Singleton
public class TwitterAuth2_0 {

    /**
     * Consumer key for the Twitter application
     */
    public static final String TWITTER_AUTH_2_0_CONSUMERKEY = "2uiozTAH7aMj7zf3BfrXvajw0";
    /**
     * Consumer secret for the Twitter application
     */
    public static final String TWITTER_AUTH_2_0_CONSUMERSECRET = "8yeB9yu6bGG18CZu5fK23dQK6FgK2H2OJyA0uoY0Mv4LiTTnhP";
    /**
     * Web service client
     */
    private final WSClient httpService;
    @Inject
    public TwitterAuth2_0(WSClient wsClient) {
        this.httpService = wsClient;
    }
    /**
     * url of Twitter API
     */
    public String endPoint = "https://api.twitter.com";

    /**
     * Encoding scheme for API requests
     */
    public String utfEncoding = "UTF-8";


    /**
     * Retrieves authentication token to access Twitter API requests
     *
     * @return returns the authentication token to access the Twitter API
     */
    public CompletionStage<String> get_Auth_2_0_AccessToken() {
        byte[] EncodedRequest ;
        String Utf8ConsumerKey = TWITTER_AUTH_2_0_CONSUMERKEY;
        String Utf8ConsumerSecret = TWITTER_AUTH_2_0_CONSUMERSECRET;
        String fullEncodedKey = Utf8ConsumerKey + ":" + Utf8ConsumerSecret;
        EncodedRequest = Base64.getEncoder().encode(fullEncodedKey.getBytes());
        return CompletableFuture
                .supplyAsync(() -> httpService.url(endPoint + "/oauth2/token")
                        .addHeader("User-Agent", "SOEN-6441")
                        .addHeader("Authorization",	"Basic " + new String(EncodedRequest))
                        .addHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8")
                        .addHeader("Content-Length", "29"))
                .thenCompose(r -> r.post("grant_type=client_credentials"))
                .thenApply((r) -> r.getBody(WSBodyReadables.instance.json()).get("access_token").asText());
    }


}
