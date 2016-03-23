package AllCommands;

import java.util.List;
import CommandTypes.TurtleCommand;
import Turtle.SingleTurtle;


/**
 * subclass of turtlecommand: returns heading of particular turtle
 *
 * @author Jin An
 *
 */
public class Heading extends TurtleCommand {

    public Heading (List<SingleTurtle> turtle) {
        super(turtle);
    }

    @Override
    public String executeOnSingleTurtle (SingleTurtle t) {
        return String.valueOf((t.getHeading()));
    }
}
