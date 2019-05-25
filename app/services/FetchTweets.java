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
import java.util.*;
import static java.util.Comparator.reverseOrder;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 *
 * Service to fetch the latest 10 tweets based on search phrase.
 * @author Bitta Rani Rana
 * @version 1.0.0
 */

@Singleton
public class FetchTweets {
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
     * Create Fetch Tweets service
     * @param httpService  httpService web service client
     * @param twitterAuth Twitter Authentication service
     */
    @Inject
    public FetchTweets(WSClient httpService, TwitterAuth2_0 twitterAuth) {
        this.httpService = httpService;
        this.twitterAuth = twitterAuth;
        AuthToken = twitterAuth.get_Auth_2_0_AccessToken();
    }

    /**
     * Retrieves the latest 10 tweets for each search input
     *
     * @param searchTerm search input
     * @param limitoftweet limits the number of tweets to be fetched and displayed on the view
     * @return returns a mapkey where key is the search input and value is the list of the latest 10 tweets with the search input
     */
    public CompletionStage<Map<String, List<Tweet_Object>>> FetchTweetsfromAPI(List<String> searchTerm, int limitoftweet) {

        return searchTerm.stream()
                .map(Searchword -> AuthToken.thenCompose(Authtoken2_0 -> FetchTweetsfromAPI(Authtoken2_0, Searchword, limitoftweet)))
                .reduce((search, tweetObject) -> search.thenCombine(tweetObject, (MapKey, MapValues) -> {
                    MapKey.putAll(MapValues);
                    return MapKey;
                })).get();
    }

    /**
     * Retrieves the final emoticon for the search result limit to 10 tweets and the word counts of the words in the tweets limit to 100 tweets
     *
     * @param Authtoken2_0  authentication token for twitter API
     * @param Searchword search input
     * @param limitoftweet limits the number of tweets to be fetched and displayed on the view
     * @return returns a mapkey where key is the search input and value is the final emoticon of the search (happy sad or neutral)
     */
    public CompletionStage<Map<String, List<Tweet_Object>>> FetchTweetsfromAPI(String Authtoken2_0, String Searchword, int limitoftweet){
        String[] paramArray = Searchword.split("--");
        return CompletableFuture
                .supplyAsync(() -> httpService.url(endPoint + "/1.1/search/tweets.json")
                        .addHeader("Authorization", "Bearer " + Authtoken2_0)
                        .addQueryParameter("tweet_mode", "extended" )
                        .addQueryParameter("count", "100")
                        .addQueryParameter("q", paramArray[0] + " -filter:retweets"))

                .thenCompose(WSRequest::get)
                .thenApply(WRresponse -> WRresponse.getBody(WSBodyReadables.instance.json()).get("statuses"))
                .thenApply(JSNode -> StreamSupport.stream(JSNode.spliterator(), true)
                        .map(JNode -> Json.fromJson(JNode, Tweet_Object.class))
                        .collect(Collectors.toList()))
                .thenApply(tweetObject -> {
                    Map<String, List<Tweet_Object>> m = new LinkedHashMap<>();
                    List<String> textList = new ArrayList<>();
                    List<Tweet_Object> Limit10Tweets = new ArrayList<>();
                    int limit = 1;
                    for(Tweet_Object tw : tweetObject) {

                        if(tw.geo != null) {
                            tw.geo.LatLong = tw.geo.coordinates.get(0).toString() + "," + tw.geo.coordinates.get(1).toString();
                            tw.geo.SearchTerm = ":" + paramArray[0];
                        }

                        if(limit < 11){
                            Limit10Tweets.add(tw);
                        }
                        textList.add(tw.full_text);

                        limit++;
                    }


                    // Check SENTIMENT START
                    Map<String, Long> wordCounter = textList.stream()
                            .map(w -> w.split("\\s+"))
                            .flatMap(Arrays::stream)
                            .collect(groupingBy(identity(), counting()));


                    int happyOneCount =0;

                    if(wordCounter.containsKey(":-)")) {
                        happyOneCount = (wordCounter.get(":-)")).intValue();
                    }

                    Set<String> hset = wordCounter.keySet()
                            .stream()
                            .filter(s -> s.startsWith(":)"))
                            .collect(Collectors.toSet());
                    System.out.println("******"+hset.toString());

                    int happyTwoCount = 0;

                    for(String emo : hset){
                        if(wordCounter.containsKey(emo)) {
                            System.out.println("test1 "+emo);
                            int happySetCount = (wordCounter.get(emo)).intValue();
                            System.out.println("test2 "+happySetCount);
                            happyTwoCount = happyTwoCount+happySetCount;
                        }
                    }
                    int happyCount = happyOneCount+happyTwoCount;

                    int sadOneCount = 0;
                    if(wordCounter.containsKey(":-(")) {
                        sadOneCount =(wordCounter.get(":-(")).intValue();
                    }

                    Set<String> sset = wordCounter.keySet()
                            .stream()
                            .filter(s -> s.startsWith(":("))
                            .collect(Collectors.toSet());

                    int sadTwoCount = 0;

                    for(String emo : sset){
                        if(wordCounter.containsKey(emo)) {
                            int sadSetCount = (wordCounter.get(emo)).intValue();
                            sadTwoCount = sadTwoCount+sadSetCount;
                        }
                    }

                    int sadCount = sadOneCount+sadTwoCount;

                    int neuOneCount = 0;
                    if(wordCounter.containsKey(":-|")) {
                        neuOneCount = (wordCounter.get(":-|")).intValue();
                    }

                    Set<String> nset = wordCounter.keySet()
                            .stream()
                            .filter(s -> s.startsWith(":|"))
                            .collect(Collectors.toSet());

                    int neuTwoCount = 0;

                    for(String emo : nset){
                        if(wordCounter.containsKey(emo)) {
                            int newSetCount = (wordCounter.get(emo)).intValue();
                            neuTwoCount = neuTwoCount+newSetCount;
                        }
                    }

                    int neuCount = neuOneCount+neuTwoCount;

                    //Percentage calculation
                    int totalEmoticon = happyCount+sadCount+neuCount;



                    int happyPercentage = 0;
                    int sadPercentage = 0;
                    int neutralPercentage = 0;

                    if(totalEmoticon!=0) {
                        happyPercentage = (int)((happyCount*100.0f)/totalEmoticon) ;
                        sadPercentage = (int)((sadCount*100.0f)/totalEmoticon);
                        neutralPercentage = (int)((neuCount*100.0f)/totalEmoticon);
                    }


                    String emoResult = null;

                    if(happyPercentage>70) {
                        emoResult = "  :-) "+happyPercentage+"%";
                    }
                    if(sadPercentage>70){
                        emoResult = "  :-( "+sadPercentage+"%";
                    }
                    if(happyPercentage<70 && sadPercentage<70){
                        emoResult = "  :-| "+neutralPercentage+"%";
                    }
                    // Check SENTIMENT END

                    // WORD STAT START
                    if(limitoftweet == 100) {
                        Map<String, Long> wordCount = textList.stream()
                                .map(w -> w.split("\\s+"))
                                .flatMap(Arrays::stream)
                                .collect(groupingBy(identity(), counting()));

                        Map<String, List<Tweet_Object>> sortedMap = new LinkedHashMap<String, List<Tweet_Object>>();

                        wordCount.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                                .forEachOrdered(c -> {
                                    Tweet_Object tempObjSingle = new Tweet_Object();
                                    tempObjSingle.WordStat = c.getValue();
                                    List<Tweet_Object> tempObj = new ArrayList<>();
                                    tempObj.add(tempObjSingle);
                                    sortedMap.put(c.getKey(), tempObj);
                                });

                        return sortedMap;
                    }
                    // WORD START END
                    m.put(paramArray[0] + " -- " + emoResult, Limit10Tweets);
                    return m;
                });
    }



}
