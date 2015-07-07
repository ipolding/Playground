import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class GameBoard extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(context().system(), this);


    final Stage primaryStage = new Stage();
    final Circle playingPiece = new Circle(10);

    /* the actor's state is the group of elements on the Stage*/
    Group root;

    @Override
    public void preStart() {
        root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.BLACK);
        root.getChildren().add(playingPiece);

        primaryStage.setScene(scene);
        primaryStage.show();
        log.info("GameBoard has been created");
    }

    public GameBoard() {
        /* the actor has behaviour*/
        receive(ReceiveBuilder
               .match(Display.class, display -> {

//                   root.getChildren().
               })
               .matchAny(o -> log.info("received unknown message")).build()
        );
    }

    static public class Display {
        public final double x;
        public final double y;

        public Display(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
