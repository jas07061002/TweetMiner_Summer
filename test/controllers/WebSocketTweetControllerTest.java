package controllers;

import akka.actor.ActorSystem;
import akka.stream.Materializer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.webjars.play.WebJarsUtil;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Http;
import play.mvc.Result;
import play.shaded.ahc.org.asynchttpclient.AsyncHttpClient;
import play.shaded.ahc.org.asynchttpclient.BoundRequestBuilder;
import play.shaded.ahc.org.asynchttpclient.DefaultAsyncHttpClient;
import services.FetchTweets;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.fakeRequest;
import static org.hamcrest.Matchers.equalTo;
import java.util.concurrent.ExecutionException;
import static org.hamcrest.Matchers.is;
import play.test.Helpers;
import play.test.WithServer;
import play.shaded.ahc.org.asynchttpclient.ListenableFuture;
import play.shaded.ahc.org.asynchttpclient.ws.WebSocket;
import play.shaded.ahc.org.asynchttpclient.ws.WebSocketUpgradeHandler;

/**
*/

public class WebSocketTweetControllerTest extends WithServer {

    /**
     */
    private AsyncHttpClient HttpClient;

    /**
     */
    @Before
    public void setUpHttpContext() {
        HttpClient = new DefaultAsyncHttpClient();
    }

    /**

     */
    @After
    public void clearHttpContext() throws IOException {
        HttpClient.close();
    }

    /**

     */
    public CompletableFuture<WebSocket> call(AsyncHttpClient client, String url) {
        BoundRequestBuilder requestBuilder;

            requestBuilder = client.prepareGet(url);

        WebSocketUpgradeHandler handler = new WebSocketUpgradeHandler.Builder().build();
        ListenableFuture<WebSocket> future = requestBuilder.execute(handler);
        return future.toCompletableFuture();
    }
    /**

     */
    @Test
    public void index_success() throws InterruptedException, ExecutionException {
        WebSocketTweetController controller = new WebSocketTweetController(new HttpExecutionContext(ForkJoinPool.commonPool()),
                mock(FetchTweets.class),
                mock(WebJarsUtil.class),
                ActorSystem.create(),
                mock(Materializer.class));

        Http.Context.current.set(Helpers.httpContext(fakeRequest("GET", "ws://localhost:" + this.testServer.port() + "/responsive").build()));
        Result result = controller.index().toCompletableFuture().get();
        Http.Context.current.remove();

        assertThat(result.status(), is(equalTo(OK)));
        assertThat(result.contentType().get(), is(equalTo("text/html")));
    }

    /**

     */
    @Test
    public void websocket_success() throws Exception {

        WebSocket socket = call(HttpClient, "ws://localhost:" + this.testServer.port() + "/responsive/WSsocket").get();
        assertThat(true, is(equalTo(socket.isOpen())));
    }


}