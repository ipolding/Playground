import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class GameBoard extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(context().system(), this);

    private final double MOVE_DISTANCE = 5;

    /* the actor's state is the group of elements on the Stage*/
    final Group root = new Group();

    final Stage primaryStage = new Stage();
    final Circle player = new Circle(10, Color.WHITE);
    Scene scene = new Scene(root, 800, 600, Color.BLACK);

    ActorRef player1;

    @Override
    public void preStart() {

        root.getChildren().add(player);

        scene.setOnKeyPressed((keyEvent) -> {
                        log.info("detected {}", keyEvent);

                        switch (keyEvent.getCode()) {
                            case UP: player1.tell(Move.apply(self(), -MOVE_DISTANCE, Move.Direction.VERTICAL), self());break;
                            case DOWN: player1.tell(Move.apply(self(), +MOVE_DISTANCE, Move.Direction.VERTICAL), self());break;
                            case LEFT: player1.tell(Move.apply(self(), -MOVE_DISTANCE, Move.Direction.HORIZONTAL), self());break;
                            case RIGHT: player1.tell(Move.apply(self(), +MOVE_DISTANCE, Move.Direction.HORIZONTAL), self());break;
                        }
                });

        primaryStage.setScene(scene);
        primaryStage.show();
        log.info("GameBoard has been created");

        player1 = getContext().actorOf(Props.create(Player.class)
                .withDispatcher("javafx-dispatcher"), "PlayingPiece");
        log.info("Players have been created");
        log.info("Let the games..BEGIN!!!");
    }

    public GameBoard() {

        receive(ReceiveBuilder
                        .match(Display.class, display -> {
                            log.debug("moving {} to {}, {}", player, display.x, display.y);
                            player.setTranslateX(display.x);
                            player.setTranslateY(display.y);
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
