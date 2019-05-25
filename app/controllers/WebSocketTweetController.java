package controllers;

import actors.SearchDisplayActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.stream.Materializer;
import akka.NotUsed;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.WebSocket;
import akka.stream.javadsl.Flow;
import scala.concurrent.duration.Duration;
import actors.SearchDisplayActorMessage;
import actors.SearchRendererActor;
import actors.SearchRendererActorMessage;
import services.FetchTweets;
import views.html.responsiveTweets;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;
import org.webjars.play.WebJarsUtil;
import play.libs.F.Either;
import play.libs.concurrent.HttpExecutionContext;
import play.libs.streams.ActorFlow;

/**

 */

@Singleton
public class WebSocketTweetController extends Controller {


    /**
     */
    public WebJarsUtil webJarsUtil;

    /**
     */
    public Materializer mtz;

    /**
     */
    public ActorSystem actors;

    /**
     */
    public FetchTweets fetchTweets;

    /**
     */
    public HttpExecutionContext context;


    /**
     */
    public ActorRef refreshActorRef;

    /**

     */
    @Inject
    public WebSocketTweetController(
            HttpExecutionContext context,
            FetchTweets fetchTweets,
            WebJarsUtil webJarsUtil,
            ActorSystem actors,
            Materializer mtz) {
        this.webJarsUtil = webJarsUtil;
        this.context = context;
        this.fetchTweets = fetchTweets;
        this.actors = actors;
        this.mtz = mtz;
        refreshActorRef = actors.actorOf(SearchRendererActor.props(), "Scheduler"); // Scheduler Part.
        actors.scheduler().schedule(Duration.create(0, TimeUnit.SECONDS), Duration.create(5, TimeUnit.SECONDS), refreshActorRef, new SearchRendererActorMessage.render(), actors.dispatcher(), ActorRef.noSender());
    }

    /**

     */
    public WebSocket WSsocket() {

        return WebSocket.json(SearchDisplayActorMessage.find_search.class).acceptOrResult(message -> {
            return
                        CompletableFuture.supplyAsync(() -> {
                            Object flowAsObject = ActorFlow.actorRef(socket ->
                                            SearchDisplayActor.props(socket, refreshActorRef, fetchTweets),
                                    actors, mtz);
                            Flow<SearchDisplayActorMessage.find_search, Object, NotUsed> process =
                                    (Flow<SearchDisplayActorMessage.find_search, Object, NotUsed>) flowAsObject;
                             Either<Result, Flow<SearchDisplayActorMessage.find_search, Object, ?>> renderProcess = Either.Right(process);
                            return renderProcess;
                        });
        });
    }

    /**

     */
    public CompletionStage<Result> index() {
        return CompletableFuture.supplyAsync(() -> {
            return ok(responsiveTweets.render(webJarsUtil));
        }, context.current());
    }



}