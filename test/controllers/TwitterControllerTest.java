package controllers;

import models.Tweet_Object;
import models.User_Object;
import models.UserTweet_Object;
import models.Entity_Object;
import models.Geo_Object;
import models.HashTags_Object;
import org.junit.Before;
import org.junit.Test;
import play.data.Form;
import play.data.Form.Field;
import play.data.FormFactory;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Result;
import services.FetchTweets;
import services.FetchLocationTweets;
import services.FetchUserProfile;
import services.TwitterAuth2_0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.contentAsString;

public class TwitterControllerTest {

    private FetchUserProfile fetchUserProfile = mock(FetchUserProfile.class);

    private FetchTweets fetchTweets = mock(FetchTweets.class);

    private FormFactory UIFactory = mock(FormFactory.class);

    private FetchLocationTweets fetchLocationTweets = mock(FetchLocationTweets.class);

    private User_Object user_Object = mock(User_Object.class);

    private User_Object user_Object2 = new User_Object();

    private Entity_Object entity_Object = mock(Entity_Object.class);

    private Geo_Object Geo_Object = mock(Geo_Object.class);

    private HashTags_Object HashTags_Object = mock(HashTags_Object.class);

    private Tweet_Object Tweet_Object = mock(Tweet_Object.class);

    private User_Object User_Object = mock(User_Object.class);

    private UserTweet_Object UserTweet_Object = mock(UserTweet_Object.class);

    private Form<String> stringForm = mock(Form.class);

    private Field field = mock(Field.class);

    private HttpExecutionContext executionContext = new HttpExecutionContext(ForkJoinPool.commonPool());

    private List<Tweet_Object> tweetsList;

    @Before
    public void setup(){

        User_Object userObject1 = new User_Object();
        userObject1.screen_name = "UserObject1";

        User_Object userObject2 = new User_Object();
        userObject1.screen_name = "UserObject2";

        Tweet_Object tweet_montreal = new Tweet_Object();
        tweet_montreal.created_at = "created at";
        tweet_montreal.full_text = "Montreal Cafe";
        tweet_montreal.user = userObject1;

        Tweet_Object tweet_toronto = new Tweet_Object();
        tweet_toronto.created_at = "created at";
        tweet_toronto.full_text = "Toronto Cafe";
        tweet_toronto.user = userObject1;

        tweetsList = new ArrayList<>();
        tweetsList.add(tweet_montreal);
        tweetsList.add(tweet_toronto);
    }

    @Test
    public void testIndex() throws InterruptedException, ExecutionException {

        TweetController controller = new TweetController(fetchTweets,
                UIFactory, executionContext, fetchUserProfile, fetchLocationTweets);

        Result Searchresult = controller.index().toCompletableFuture().get();

        assertThat(Searchresult.status(), is(equalTo(OK)));
    }


    @Test
    public void testuserProfileController() throws InterruptedException, ExecutionException {

        TweetController controller_profile = new TweetController(fetchTweets,
                UIFactory, executionContext, fetchUserProfile, fetchLocationTweets);

        when(fetchUserProfile.userProfile("UserObject1"))
                .thenReturn(CompletableFuture.supplyAsync(() -> UserTweet_Object));
        when(UserTweet_Object.getUserProfile()).thenReturn(user_Object);
        when(user_Object.getScreenName()).thenReturn("UserObject1");

        try {
        Result result = controller_profile.userProfile("UserObject1").toCompletableFuture().get();

        assertThat(result.status(), is(equalTo(OK)));
        }
        catch (Exception s){
        }

    }


    @Test
    public void testSearchController() throws InterruptedException, ExecutionException {

        TweetController controller_search = new TweetController(fetchTweets,
                UIFactory, executionContext, fetchUserProfile, fetchLocationTweets);

        Map<String, List<Tweet_Object>> searchResult = new HashMap<>();
        searchResult.put("cafe", tweetsList);

        when(UIFactory.form(String.class)).thenReturn(stringForm);
        when(stringForm.bindFromRequest()).thenReturn(stringForm);
        when(stringForm.field("searchString")).thenReturn(field);
        when(field.getValue()).thenReturn(Optional.of("cafe"));
        when(fetchTweets.FetchTweetsfromAPI(any(List.class), any(Integer.class)))
                .thenReturn(CompletableFuture.supplyAsync(() -> searchResult));
        try {
            Result result = controller_search.search().toCompletableFuture().get();
            assertThat(result.status(), is(equalTo(OK)));
        }
        catch (Exception s){
        }
    }

    @Test
    public void testLocationTweetController() throws InterruptedException, ExecutionException {

        TweetController controller_search = new TweetController(fetchTweets,
                UIFactory, executionContext, fetchUserProfile, fetchLocationTweets);

        Map<String, List<Tweet_Object>> searchResult = new HashMap<>();
        searchResult.put("cafe", tweetsList);

        when(UIFactory.form(String.class)).thenReturn(stringForm);
        when(stringForm.bindFromRequest()).thenReturn(stringForm);
        when(stringForm.field("searchString")).thenReturn(field);
        when(field.getValue()).thenReturn(Optional.of("cafe"));
        when(fetchLocationTweets.FetchLocationTweetsfromAPI(any(List.class)))
                .thenReturn(CompletableFuture.supplyAsync(() -> searchResult));
        try {
            Result result = controller_search.locationTweets("cafe").toCompletableFuture().get();
        assertThat(result.status(), is(equalTo(OK)));
        }
        catch (Exception s){
        }
    }

    @Test
    public void testHashTagController() throws InterruptedException, ExecutionException {

        TweetController controller_search = new TweetController(fetchTweets,
                UIFactory, executionContext, fetchUserProfile, fetchLocationTweets);

        Map<String, List<Tweet_Object>> searchResult = new HashMap<>();
        searchResult.put("cafe", tweetsList);

        when(UIFactory.form(String.class)).thenReturn(stringForm);
        when(stringForm.bindFromRequest()).thenReturn(stringForm);
        when(stringForm.field("searchString")).thenReturn(field);
        when(field.getValue()).thenReturn(Optional.of("cafe"));
        when(fetchTweets.FetchTweetsfromAPI(any(List.class), any(Integer.class)))
                .thenReturn(CompletableFuture.supplyAsync(() -> searchResult));
            try {
            Result result = controller_search.HashTagTweets("cafe").toCompletableFuture().get();
            assertThat(result.status(), is(equalTo(OK)));
            }
            catch (Exception s){
            }
    }

    @Test
    public void testWordstatController() throws InterruptedException, ExecutionException {

        TweetController controller_search = new TweetController(fetchTweets,
                UIFactory, executionContext, fetchUserProfile, fetchLocationTweets);

        Map<String, List<Tweet_Object>> searchResult = new HashMap<>();
        searchResult.put("cafe", tweetsList);

        when(UIFactory.form(String.class)).thenReturn(stringForm);
        when(stringForm.bindFromRequest()).thenReturn(stringForm);
        when(stringForm.field("searchString")).thenReturn(field);
        when(field.getValue()).thenReturn(Optional.of("cafe"));
        when(fetchTweets.FetchTweetsfromAPI(any(List.class), any(Integer.class)))
                .thenReturn(CompletableFuture.supplyAsync(() -> searchResult));
                try {
        Result result = controller_search.WordStat("Montreal").toCompletableFuture().get();
        assertThat(result.status(), is(equalTo(OK)));
                }
                catch (Exception s){
                }
    }
}
