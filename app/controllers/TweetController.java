package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import javax.inject.Inject;
import javax.inject.Singleton;

import models.Tweet_Object;
import play.data.Form;
import play.data.FormFactory;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;
import services.FetchTweets;
import services.FetchUserProfile;
import services.FetchLocationTweets;

/**
 *
 * This controller searches the tweets as per the keywords, displays the user profile, lists the location of the tweet if available according to
 * the latitude and longitude co-ordinates, the hash tags present in the tweet and the number of occurrences of a word in the tweet.
 *
 * @see TweetController
 * @version 1.0
 * @Author Dhruv Jasmine Samiparna Debanjana Bitta
 * @since 2018-07-30
 *
 */

@Singleton
public class TweetController extends Controller {
    public FetchUserProfile fetchUserProfile;
    public FetchLocationTweets fetchLocationTweets;
    public FormFactory UIFactory;
    public FetchTweets fetchTweets;
    public HttpExecutionContext executionContext;
    public List<String> Allsearches = new ArrayList<>();

    /**
     *
     * @version 1.0
     * @param fetchTweets  Fetches Tweet service
     * @param UIFactory    UI factory call
     * @param executionContext  Execution Context
     * @param fetchUserProfile Fetches User Profile Service
     * @param fetchLocationTweets Fetches Location Tweet Service
     * @Author Dhruv Bhalodi
     * @since 2018-07-30
     */


    @Inject
    public TweetController(
            FetchTweets fetchTweets,
            FormFactory UIFactory,
            HttpExecutionContext executionContext,FetchUserProfile fetchUserProfile,FetchLocationTweets fetchLocationTweets){
        this.fetchTweets = fetchTweets;
        this.UIFactory = UIFactory;
        this.executionContext = executionContext;
        this.fetchUserProfile = fetchUserProfile;
        this.fetchLocationTweets = fetchLocationTweets;
    }

    /**
     * Renders the index page of the application
     */

    public CompletionStage<Result> index() {
        return CompletableFuture.supplyAsync(() -> {
            Allsearches.clear();
            Form<String> UIForm = UIFactory.form(String.class);

            return ok(views.html.index.render(UIForm, null));
        });
    }


    /**
     * Retrieves user profile information and latest 10 tweets posted by the user
     * on the UI
     *
     * @param userScreenName  username on Twitter
     * @return user profile information with the latest 10 tweets by the user
     */

    public CompletionStage<Result> userProfile(String userScreenName) {
        return fetchUserProfile
                .userProfile(userScreenName)
                .thenApplyAsync(userUI  -> ok(views.html.userProfile.render(userUI)));
    }

    /**
     * Searches the tweets based on keywords and updates the list of searches every time a new phrase is searched and calls fetch tweet service.
     *
     * @return returns the list of tweet searches on the index page.
     */

    public CompletionStage<Result> search() {

        CompletionStage<Form<String>> searchFormFuture =
                CompletableFuture.supplyAsync(() -> {
                    Form<String> pageform = UIFactory.form(String.class).bindFromRequest();
                    if (!pageform.field("searchString").getValue().get().isEmpty()) {
                        Allsearches.add(pageform.field("searchString").getValue().get());
                    }
                    return pageform;
                }, executionContext.current());

        CompletionStage<Map<String, List<Tweet_Object>>> UIMAP =
                searchFormFuture.thenCompose(MapTweets -> {
                    return fetchTweets.FetchTweetsfromAPI(Allsearches, 10);
                });
        return searchFormFuture.thenCombine(UIMAP, (form, map) -> ok(views.html.index.render(form, map)));
    }

    /**
     * retrieves the list of tweets filtered by the location of the user
     *
     * @param location   Latitude and longitude coordinates of user location
     * @return list of tweets on a specific location and renders it on the view
     */

    public CompletionStage<Result> locationTweets(String location) {
        List<String> locations = new ArrayList<>();
        locations.add(location);
        return fetchLocationTweets
                .FetchLocationTweetsfromAPI(locations)
                .thenApplyAsync(userUI  -> ok(views.html.location.render(userUI)));}

    /**
     * retrieves the list of tweets filtered by the hashtags
     *
     * @param hashtag   input hashtag
     * @return list of tweets based on specific hashtags and render it on the view
     */

    public CompletionStage<Result> HashTagTweets(String hashtag) {
        List<String> hashtags = new ArrayList<>();
        hashtags.add("#" + hashtag);
        return fetchTweets
                .FetchTweetsfromAPI(hashtags, 10)
                .thenApplyAsync(userUI  -> ok(views.html.hashtag.render(userUI))); }

    /**
     * retrieves the list of tweets filtered by the hashtags
     *
     * @param searchWord   input searchword
     * @return list of words in the tweets and the word count based on the occurrence of words in the tweets limited to 100 words
     */
    public CompletionStage<Result> WordStat(String searchWord) {
        List<String> searchWords = new ArrayList<>();
        searchWords.add(searchWord);
        return fetchTweets
                .FetchTweetsfromAPI(searchWords, 100)
               .thenApplyAsync(userUI  -> ok(views.html.wordstatistic.render(userUI))); }


}
