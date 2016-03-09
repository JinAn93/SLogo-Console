package AllCommands;

import java.util.List;
import CommandTypes.TurtleCommand;
import Turtle.*;


public class IsShowing extends TurtleCommand {

    public IsShowing (List<SingleTurtle> turtle) {
        super(turtle);
    }

    @Override
    public String executeCommand () {
        String ret = null;
        for (Turtle aturtle : myTurtle) {
            ret = String.valueOf((aturtle.getVisibility()));
        }
        return ret;
    }
}
