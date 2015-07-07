import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    ActorSystem actorSystem = ActorSystem.create();

    @Override
    public void start(Stage primaryStage) throws Exception {

        ActorRef game = actorSystem.actorOf(Props.create(GameBoard.class)
                .withDispatcher("javafx-dispatcher"), "Game");


        ActorRef playingPiece = actorSystem.actorOf(Props.create(PlayingPiece.class)
                .withDispatcher("javafx-dispatcher"), "PlayingPiece");


        playingPiece.tell(Move.apply(game, 100, Move.Direction.HORIZONTAL), game);
        playingPiece.tell(Move.apply(game, 100, Move.Direction.HORIZONTAL), game);

    }
}
