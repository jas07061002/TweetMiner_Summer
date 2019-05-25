package actors;

import akka.actor.ActorRef;

/**

 */

public class SearchRendererActorMessage {

    /**

     */
    public static class start {
        /**
         */
        public final ActorRef searchActor;

        /**

         */
        public start(ActorRef searchActor) {
            this.searchActor = searchActor;
        }
    }

    /**

     */
    public static class render {
    }
}
