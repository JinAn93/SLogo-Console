package AllCommands;

import java.util.List;
import CommandTypes.TurtleCommand;
import Turtle.*;


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
