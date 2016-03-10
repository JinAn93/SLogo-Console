package AllCommands;

import java.util.List;
import CommandTypes.TurtleCommand;
import Turtle.*;


public class YCoordinate extends TurtleCommand {

    public YCoordinate (List<SingleTurtle> turtle) {
        super(turtle);
    }

    @Override
    public String executeCommand () {
        return String.valueOf((aturtle.getStartYCor()));
    }
}
