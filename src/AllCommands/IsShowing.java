package AllCommands;

import java.util.List;
import CommandTypes.TurtleCommand;
import Turtle.*;


public class IsShowing extends TurtleCommand {

    public IsShowing (List<SingleTurtle> turtle) {
        super(turtle);
    }

    @Override
    public String executeOnSingleTurtle (SingleTurtle t) {
        return String.valueOf((t.getVisibility()));
    }
}
