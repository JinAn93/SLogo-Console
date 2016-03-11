package CommandTypes;

import java.util.List;
import Turtle.SingleTurtle;

public abstract class DisplayCommand extends TurtleCommand{

    public DisplayCommand (List<SingleTurtle> turtle) {
        super(turtle);
    }
}
