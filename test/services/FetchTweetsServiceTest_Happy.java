package services;

import models.Tweet_Object;
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
 * JUnit test cases for FetchTweetsServiceTest_Happy .
 *
 * @author Dhruv
 * @version 1.0.0
 */

public class FetchTweetsServiceTest_Happy {
    /**
     * Consumer key for the Twitter application
     */
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
                .GET("/1.1/search/tweets.json").routeTo(() -> ok().sendResource("result_search_happy.json"))
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
     * Verifies that the testFetchTweetsfromAPI returns correct response to the dummy input for happy emoticon
     */
    @Test
    public void testFetchTweetsfromAPI() throws InterruptedException, ExecutionException {
        FetchTweets FetchTweetService = new FetchTweets(httpService, twitterAuth);
        FetchTweetService.endPoint = "";

        Map<String, List<Tweet_Object>> TestData = FetchTweetService.FetchTweetsfromAPI(Arrays.asList("Montreal", "Cafe"),100).toCompletableFuture().get();
        assertTrue(TestData.get(":-)").size() == 1);
        assertTrue(TestData.get("Montreal").size() == 1);
    }
}