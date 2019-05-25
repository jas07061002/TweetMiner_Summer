package services;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.inject.Inject;
import models.Tweet_Object;
import models.User_Object;
import models.UserTweet_Object;
import play.libs.Json;
import play.libs.ws.WSBodyReadables;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;

/**
 * Service to fetch user profile information and the last ten tweets of the user by making service call to Twitter API .
 * @author Dhruv Bhalodi
 * @version 1.0.0
 */
public class FetchUserProfile {
    /**
     * Web service client httpService
     */
    public final WSClient httpService;
    /**
     *authenticate token to access Twitter API
     */
    public final TwitterAuth2_0 twitterAuth;

    public static CompletionStage<String> tokenAuth;
    /**
     * url of Twitter API
     */
    public String endPoint = "https://api.twitter.com";

    /**
     * Create Fetch user profile service
     *
     * @param httpService  HttpService Client
     * @param twitterAuth TwitterAuth2_0 service provides authentication token for  Twitter API
     */
    @Inject
    public FetchUserProfile(WSClient httpService, TwitterAuth2_0 twitterAuth) {
        this.httpService = httpService;
        this.twitterAuth = twitterAuth;
        tokenAuth = twitterAuth.get_Auth_2_0_AccessToken();
    }
    /**
     * It fetches the token to access Twitter API and returns user profile with the ten last tweets of the user and creates the
     * UserTweet_Object
     *
     * @param screen_name  User screen name for Twitter
     *
     * @return  returns UserTweet_Object that combines user profile information
     * and their ten last tweets
     */
    public CompletionStage<UserTweet_Object> userProfile(String screen_name) {

        return tokenAuth.thenCompose(token -> fetchUserProfile(token, screen_name)).thenCombine(tokenAuth.thenCompose(token -> UserTweets(token, screen_name)),
                (user,tweets) -> new UserTweet_Object(user,tweets));
    }

    /**
     * Retrieves user profile information via Twitter API asynchronously
     *
     * @param accessToken token to authenticate API requests
     * @param screen_name  Username for Twitter
     * @return returns  UserTweet object
     */
    private CompletionStage<User_Object> fetchUserProfile(String accessToken, String screen_name){

        return
                CompletableFuture.supplyAsync(() ->
                        httpService
                                .url(endPoint + "/1.1/users/show.json")
                                .addHeader("Authorization", "Bearer " + accessToken)
                                .addQueryParameter("tweet_mode", "extended")
                                .addQueryParameter("screen_name", screen_name))
                        .thenCompose(WSRequest::get)
                        .thenApply(JSNode -> JSNode.getBody(WSBodyReadables.instance.json()))
                        .thenApply(JNode -> Json.fromJson(JNode, User_Object.class));
    }
    /**
     * Retrieves the latest 10 tweets from the Twitter API
     *
     * @param accessToken token used to authorize Twitter API requests
     * @param screen_name Username for Twitter
     * @return  returns the list of the latest 10 tweets
     */
    private CompletionStage<List<Tweet_Object>> UserTweets(String accessToken, String screen_name){

        return
                CompletableFuture.supplyAsync(() ->
                        httpService
                                .url(endPoint + "/1.1/statuses/user_timeline.json")
                                .addHeader("Authorization", "Bearer " + accessToken)
                                .addQueryParameter("tweet_mode", "extended")
                                .addQueryParameter("screen_name", screen_name))
                        .thenCompose(WSRequest::get)
                        .thenApply(WRresponse -> WRresponse.getBody(WSBodyReadables.instance.json()))
                        .thenApply(JSNode -> StreamSupport.stream(JSNode.spliterator(), false)
                                .map(JNode -> Json.fromJson(JNode, Tweet_Object.class))
                                .limit(10)
                                .collect(Collectors.toList()));
    }
}
