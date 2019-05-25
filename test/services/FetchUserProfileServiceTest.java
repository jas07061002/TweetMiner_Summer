package services;

import models.Tweet_Object;
import models.UserTweet_Object;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import play.libs.ws.WSClient;
import play.routing.RoutingDsl;
import play.server.Server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.*;

import java.util.concurrent.ExecutionException;

import static junit.framework.TestCase.assertTrue;
import static play.mvc.Results.ok;
/**
 * JUnit test cases for FetchUserProfileService .
 *
 * @author Dhruv
 * @version 1.0.0
 */

public class FetchUserProfileServiceTest {

    public TwitterAuth2_0 twitterAuth;
    /**
     * Web service client httpService
     */
    public WSClient httpService;
    /**
     * Twitter server test instance
     */
    private Server Twitterserver;
    /**
     * Initialize the test environment.
     * Setup mocks and the responses
     */
    @Before
    public void setupData() {

        Twitterserver = Server.forRouter((components) -> RoutingDsl.fromComponents(components)
                .POST("/oauth2/token").routeTo(() -> ok().sendResource("authtoken.json"))
                .GET("/1.1/users/show.json").routeTo(() -> ok().sendResource("user.json"))
                .GET("/1.1/statuses/user_timeline.json").routeTo(() -> ok().sendResource("result_tweets.json"))
                .build());
        httpService = play.test.WSTestClient.newClient(Twitterserver.httpPort());
        twitterAuth = new TwitterAuth2_0(httpService);
        twitterAuth.endPoint = "";
    }

    /**
     * Tears down the test setup.
     *
     * @throws IOException
     */
    @After
    public void tearDownData() throws IOException {
        try {
            httpService.close();
        } finally {
            Twitterserver.stop();
        }
    }

    /**
     * Tests FetchUserTweetService with dummy data.
     * Sets dummy user profile and tweets that should be returned from mocks,
     * calls FetchUserTweetService to retrieve a user profile information and verifies that the result
     * is correct equal to mock data.
     */
    @Test
    public void testFetchTweetsfromAPI() throws InterruptedException, ExecutionException {
        FetchUserProfile FetchUserTweetService = new FetchUserProfile(httpService, twitterAuth);
        FetchUserTweetService.endPoint = "";

        UserTweet_Object TestData = FetchUserTweetService.userProfile("testSname").toCompletableFuture().get();
        assertTrue(TestData.userProfile.followers_count == 123123);
    }
}