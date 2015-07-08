import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;

public class Player extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(context().system(), this);

    private int xPosition;
    private int yPosition;

    public Player() {

        receive(ReceiveBuilder
               .match(Move.class, move -> {
                   switch (move.direction) {
                       case VERTICAL: yPosition += move.length;break;
                       case HORIZONTAL: xPosition += move.length;break;
                   }
                   log.debug("Player has been told to move {} {}", move.length, move.direction);
                   move.gameBoard.tell(new GameBoard.Display(xPosition, yPosition), self());
               })
               .matchAny(o -> log.info("received unknown message")).build()
        );
    }
}