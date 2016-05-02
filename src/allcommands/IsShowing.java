package allcommands;

import java.util.List;
import CommandTypes.TurtleCommand;
import Turtle.SingleTurtle;


/**
 * subclass of turtlecommand. return visibility
 *
 * @author Jin An
 *
 */
public class IsShowing extends TurtleCommand {

    public IsShowing (List<SingleTurtle> turtle) {
        super(turtle);
    }

    @Override
    public String executeOnSingleTurtle (SingleTurtle t) {
        return String.valueOf((t.getVisibility()));
    }
}
