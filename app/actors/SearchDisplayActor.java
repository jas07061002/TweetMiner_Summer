package actors;

import actors.SearchDisplayActorMessage.rerender;
import actors.SearchDisplayActorMessage.find_search;
import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import models.Tweet_Object;
import play.libs.Json;
import services.FetchTweets;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletionStage;

/**
 *
 * @author
 * @version
 */
public class SearchDisplayActor extends AbstractActor {

    /**
     *
     */
    public ActorRef websocket;



    /**
     *
     */
    public FetchTweets fetchTweets;



    /**
     *
     */
    public ActorRef out;


    /**
     *
     *
     */
    public SearchDisplayActor(ActorRef out, ActorRef websocket, FetchTweets fetchTweets) {
        this.out = out;
        this.websocket = websocket;
        this.fetchTweets = fetchTweets;
        this.websocket.tell(new SearchRendererActorMessage.start(self()), self());
    }

    /**
     */
    public ArrayList<String> searchKeys = new ArrayList<>();


    /**
     *
     *
     *
     */
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(find_search.class, newSearch -> {
                    searchKeys.add(newSearch.keyword);
                    CompletionStage<Map<String, List<Tweet_Object>>> reply = fetchTweets.FetchTweetsfromAPI(searchKeys, 10);
                    reply.thenAccept(r -> out.tell(Json.toJson(r), self()));
                })
                .match(rerender.class, newRefresh -> {
                    if (searchKeys.size() > 0) {
                        CompletionStage<Map<String, List<Tweet_Object>>> reply = fetchTweets.FetchTweetsfromAPI(searchKeys, 10);
                        reply.thenAccept(r -> out.tell(Json.toJson(r), self()));
                    }
                })
                .build();
    }

    /**
     *
     */
    public static Props props(ActorRef out, ActorRef websocket, FetchTweets fetchTweets) {
        return Props.create(SearchDisplayActor.class, out, websocket, fetchTweets);
    }
}