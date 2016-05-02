package allcommands;

import java.util.List;
import CommandTypes.TurtleCommand;
import Turtle.SingleTurtle;


/**
 * subclass of TurtleCommand: serves to set each turtle's pen property to up and return 0 (penup).
 *
 * @author Jin An
 *
 */
public class PenUp extends TurtleCommand {

    public PenUp (List<SingleTurtle> turtle) {
        super(turtle);
    }

    @Override
    public String executeOnSingleTurtle (SingleTurtle t) {
        t.setPen(PENUP);
        return Integer.toString(PENUP);
    }
}
