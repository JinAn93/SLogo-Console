package AllCommands;

import java.util.List;
import CommandTypes.TurtleCommand;
import Turtle.*;


public class Heading extends TurtleCommand {

    public Heading (List<SingleTurtle> turtle) {
        super(turtle);
    }

    @Override
    public String executeCommand () {
        return String.valueOf((aturtle.getHeading()));
    }
}
