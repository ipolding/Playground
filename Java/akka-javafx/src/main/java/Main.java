import akka.actor.ActorSystem;
import akka.actor.Props;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    ActorSystem actorSystem = ActorSystem.create();

    @Override
    public void start(Stage primaryStage) throws Exception {

        actorSystem.actorOf(Props.create(GameBoard.class)
                .withDispatcher("javafx-dispatcher"), "Game");
    }
}