import akka.actor.ActorRef;

public class Move {

    public final ActorRef gameBoard;
    public final double length;
    public final Direction direction;

    private Move(ActorRef gameBoard, double length, Direction direction) {
        this.gameBoard = gameBoard;
        this.length = length;
        this.direction = direction;
    }

    public static Move apply(ActorRef gameBoard, double length, Direction direction) {
        return new Move(gameBoard, length, direction);
    }

    public enum Direction {
        HORIZONTAL,
        VERTICAL;
    }
}