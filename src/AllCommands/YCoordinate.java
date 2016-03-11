package AllCommands;

import java.util.List;
import CommandTypes.TurtleCommand;
import Turtle.*;

/**
 * Subclass of TurtleCommand: serves to return y coordinate of each turtle.
 * @author Jin An
 *
 */
public class YCoordinate extends TurtleCommand {

    public YCoordinate (List<SingleTurtle> turtle) {
        super(turtle);
    }

    @Override
    public String executeOnSingleTurtle (SingleTurtle t) {
        return String.valueOf((t.getStartYCor()));
    }
}
