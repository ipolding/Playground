import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;
import javafx.scene.Group;
import javafx.scene.shape.Circle;

public class PlayingPiece extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(context().system(), this);

    private Circle playingPiece = new Circle(10);

    public PlayingPiece() {

        receive(ReceiveBuilder
               .match(Move.class, move -> {
                   switch (move.direction) {
                       case VERTICAL: playingPiece.setCenterX(playingPiece.getCenterX() + move.length);
                       case HORIZONTAL: playingPiece.setCenterY(playingPiece.getCenterY() + move.length);
                   }
                   move.gameBoard.tell(new GameBoard.Display(playingPiece), self());
               })
               .matchAny(o -> log.info("received unknown message")).build()
        );
    }
}