package actors;

import actors.TweetActorProtocol.search;
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

public class TweetActor extends AbstractActor {
    public FetchTweets fetchTweets;
    public ActorRef out;
    public TweetActor(ActorRef out, FetchTweets fetchTweets) {
        this.out = out;
        this.fetchTweets = fetchTweets;
    }

    public ArrayList<String> searchKeys = new ArrayList<>();

    public static Props props(ActorRef out, FetchTweets fetchTweets) {
        return Props.create(TweetActor.class, out, fetchTweets);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(search.class, newSearch -> {
                    searchKeys.add(newSearch.keyword);
                    CompletionStage<Map<String, List<Tweet_Object>>> reply = fetchTweets.FetchTweetsfromAPI(searchKeys, 10);
                    reply.thenAccept(r -> out.tell(Json.toJson(r), self()));
                })
                .build();
    }
}
