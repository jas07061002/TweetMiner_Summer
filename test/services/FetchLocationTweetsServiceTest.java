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
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.*;

import static junit.framework.TestCase.assertTrue;
import static play.mvc.Results.ok;
import services.TwitterAuth2_0;

/**
 * JUnit test cases for FetchLocationTweetsServiceTest .
 *
 * @author Jasmine Kalra
 * @version 1.0.0
 */

public class FetchLocationTweetsServiceTest {

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
     * Verifies that the testFetchLocationTweetsfromAPI returns correct response to the test input .
     */

    @Test
    public void testFetchLocationTweetsfromAPI() throws InterruptedException, ExecutionException {
        FetchLocationTweets FetchLocation = new FetchLocationTweets(httpService, twitterAuth);
        FetchLocation.endPoint = "";

        Map<String, List<Tweet_Object>> TestData = FetchLocation.FetchLocationTweetsfromAPI(Arrays.asList("45,-47:Montreal")).toCompletableFuture().get();
        assertTrue(TestData.get("45,-47:Montreal").size() == 3);
    }
}