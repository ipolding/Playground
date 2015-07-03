import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;

public class Player extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(context().system(), this);

    @Override
    public void preStart() {
        self().tell(new Play(), self());
    }

    public Player() {
        receive(ReceiveBuilder
               .match(Play.class, play -> {
                   log.info("Received message {}. The game has started", play.getClass());
               })
               .matchAny(o -> log.info("received unknown message")).build()
        );
    }

    static public class Play {}
}
