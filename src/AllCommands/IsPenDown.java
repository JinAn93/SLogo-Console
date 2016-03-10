package AllCommands;

import java.util.List;
import CommandTypes.TurtleCommand;
import Turtle.*;


public class IsPenDown extends TurtleCommand {

    public IsPenDown (List<SingleTurtle> turtle) {
        super(turtle);
    }

    @Override
    public String executeCommand () {
        return String.valueOf((aturtle.getPen()));
    }
}
