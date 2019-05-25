package models;

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

public class modelsTest {

    private User_Object user_Object;

    private Entity_Object entity_Object;

    private Geo_Object Geo_Object;

    private HashTags_Object HashTags_Object;

    private Tweet_Object Tweet_Object;

    private User_Object User_Object;

    private UserTweet_Object UserTweet_Object;
    private List<Tweet_Object> tweetsList;


    @Before
    public void setup(){
        user_Object = new User_Object();
        entity_Object = new Entity_Object();
        Geo_Object = new Geo_Object();
        HashTags_Object = new HashTags_Object();
        Tweet_Object = new Tweet_Object();
        User_Object = new User_Object();
        User_Object.getScreenName();
        tweetsList = new ArrayList<>();
        UserTweet_Object = new UserTweet_Object(User_Object,tweetsList);
        UserTweet_Object.getUserProfile();
        UserTweet_Object.getTweets();
    }

    @Test
    public void testmodel() throws InterruptedException, ExecutionException {

    }
}
