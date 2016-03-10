package AllCommands;

import java.util.List;
import CommandTypes.TurtleCommand;
import Turtle.*;


public class XCoordinate extends TurtleCommand {

    public XCoordinate (List<SingleTurtle> turtle) {
        super(turtle);
    }

    @Override
    public String executeCommand () {
        return String.valueOf((aturtle.getStartXCor()));
    }
}
