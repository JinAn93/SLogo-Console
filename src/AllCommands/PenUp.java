package AllCommands;

import java.util.List;
import CommandTypes.TurtleCommand;
import Turtle.*;


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
