package services;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.inject.Inject;
import com.google.inject.Singleton;
import models.Tweet_Object;
import play.libs.Json;
import play.libs.ws.WSBodyReadables;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
/**
 *
 * Service to fetch the latest 10 tweets based on location .
 * @author Jasmine Kalra
 * @version 1.0.0
 */
@Singleton
public class FetchLocationTweets {
    /**
     * Web service client httpService
     */
    public final WSClient httpService;
    /**
     * authentication token for Twitter API
     */
    public final TwitterAuth2_0 twitterAuth;

    public static CompletionStage<String> AuthToken;
    /**
     * url for the Twitter API
     */
    public String endPoint = "https://api.twitter.com";
    /**
     * Create Fetch Location Tweets service
     * @param httpService  httpService web service client
     * @param twitterAuth Twitter Authentication service
     */
    @Inject
    public FetchLocationTweets(WSClient httpService, TwitterAuth2_0 twitterAuth) {
        this.httpService = httpService;
        this.twitterAuth = twitterAuth;
        AuthToken = twitterAuth.get_Auth_2_0_AccessToken();
    }
    /**
     * Retrieves the latest 10 tweets for a location when clicked upon the location
     *
     * @param location search input
     * @return returns mapkey where key is the location and value is the list of tweets corresponding to that location
     */
    public CompletionStage<Map<String, List<Tweet_Object>>> FetchLocationTweetsfromAPI(List<String> location) {

        return location.stream()
                .map(locationword -> AuthToken.thenCompose(Authtoken2_0 -> FetchLocationTweetsfromAPI(Authtoken2_0, locationword)))
                .reduce((search, tweetObject) -> search.thenCombine(tweetObject, (MapKey, MapValues) -> {
                    MapKey.putAll(MapValues);
                    return MapKey;
                })).get();
    }
    /**
     * Retrieves the latest 10 tweets for a location when clicked upon the location
     *
     * @param Authtoken2_0 authentication token for Twitter API
     * @param location search input
     * @return returns mapkey where key is the location and value is the list of tweets corresponding to that location
     */
    public CompletionStage<Map<String, List<Tweet_Object>>> FetchLocationTweetsfromAPI(String Authtoken2_0, String location){
        String[] paramArray = location.split(":");

        return CompletableFuture
                .supplyAsync(() -> httpService.url(endPoint + "/1.1/search/tweets.json")
                        .addHeader("Authorization", "Bearer " + Authtoken2_0)
                        .addQueryParameter("tweet_mode", "extended")
                        .addQueryParameter("geocode", paramArray[0] + ",100mi")
                        .addQueryParameter("count", "1000")
                        .addQueryParameter("q", paramArray[1] + " -filter:retweets"))
                .thenCompose(WSRequest::get)
                .thenApply(WRresponse -> WRresponse.getBody(WSBodyReadables.instance.json()).get("statuses"))
                .thenApply(JSNode -> StreamSupport.stream(JSNode.spliterator(), true)
                        .map(JNode -> Json.fromJson(JNode, Tweet_Object.class))
                        .collect(Collectors.toList()))
                .thenApply(tweetObject -> {
                    Map<String, List<Tweet_Object>> m = new LinkedHashMap<>();
                    List<Tweet_Object> twlist = new ArrayList<>();
                    int i = 1;
                    for(Tweet_Object tw : tweetObject) {
                        if(tw.geo != null && !(tw.geo.coordinates.isEmpty()) && i < 11) {
                            tw.geo.LatLong = tw.geo.coordinates.get(0).toString() + "," + tw.geo.coordinates.get(1).toString();
                            tw.geo.SearchTerm = ":" + paramArray[1];
                            twlist.add(tw);
                            i++;
                        }
                    }
                    m.put(location, twlist);
                    return m;
                });
    }
}
