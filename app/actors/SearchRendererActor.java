package actors;

import actors.SearchDisplayActorMessage.rerender;
import actors.SearchRendererActorMessage.render;
import actors.SearchRendererActorMessage.start;
import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

/**

 */

public class SearchRendererActor extends AbstractActor {

    /**
     */
    public static Props props() {
        return Props.create(SearchRendererActor.class);
    }


    /**

     */
    @Override
    public Receive createReceive() {
        Set<ActorRef> searchDisplayActors = new HashSet<>();
        return receiveBuilder()
                .match(start.class, p -> {
                    searchDisplayActors.add(p.searchActor);
                })
                .match(render.class, p -> {
                    for (ActorRef actorRef : searchDisplayActors) {
                        actorRef.tell(new rerender(), getSelf());
                    }
                })
                .build();
    }
}