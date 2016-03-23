package AllCommands;

import java.util.List;
import CommandTypes.TurtleCommand;
import Turtle.SingleTurtle;


/**
 * subclass of turtleCommand: serves to set pendown for each turtle. return 1 (pendown).
 *
 * @author Jin An
 *
 */
public class PenDown extends TurtleCommand {

    public PenDown (List<SingleTurtle> turtle) {
        super(turtle);
    }

    @Override
    public String executeOnSingleTurtle (SingleTurtle t) {
        t.setPen(PENDOWN);
        return Integer.toString(PENDOWN);
    }
}
