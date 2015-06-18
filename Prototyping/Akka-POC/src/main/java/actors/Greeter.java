package actors;

import akka.actor.UntypedActor;
import messages.Greet;
import messages.Greeting;
import messages.WhoToGreet;

/**
 * Created by Ian.Polding on 04/02/2015.
 */

/* Actors can be considered as message listeners
*  Inheriting from Actor gives access to lots of methods
* */
public class Greeter extends UntypedActor {

    String greeting = "";

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof WhoToGreet) {
            greeting = "hello," + ((WhoToGreet) message).who;
        } else if (message instanceof Greet) {
             /* Actors can send messages to other Actors*/

            /* Tell is a method used to send a message to an actor*/
            /* Here, this actor is replying to the message sender*/
            getSender().tell(new Greeting(greeting), getSelf());
        } else unhandled(message); // error handling method inherited from UntypedActor

    }
}
