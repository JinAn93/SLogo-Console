package AllCommands;

import java.util.List;
import CommandTypes.TurtleCommand;
import Turtle.SingleTurtle;


/**
 * subclass of turtlecommand: serves to return xcoordinate of each turtle.
 * 
 * @author Jin An
 *
 */
public class XCoordinate extends TurtleCommand {

    public XCoordinate (List<SingleTurtle> turtle) {
        super(turtle);
    }

    @Override
    public String executeOnSingleTurtle (SingleTurtle t) {
        return String.valueOf((t.getStartXCor()));
    }
}
