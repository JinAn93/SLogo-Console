package allcommands;

import java.util.List;
import CommandTypes.TurtleCommand;
import Turtle.SingleTurtle;


/**
 * subclass of turtlecommand: returns 1 if pen down 0 if pen up
 *
 * @author Jin An
 *
 */
public class IsPenDown extends TurtleCommand {

    public IsPenDown (List<SingleTurtle> turtle) {
        super(turtle);
    }

    @Override
    public String executeOnSingleTurtle (SingleTurtle t) {
        return String.valueOf((t.getPen()));
    }
}
