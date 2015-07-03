import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;

public class Game extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(context().system(), this);

    public Game() {
        receive(ReceiveBuilder
               .match(Start.class, start -> {
                   log.info("Received message {}", start.getClass());
               })
               .matchAny(o -> log.info("received unknown message")).build()
        );
    }

    static public class Start {}
}
