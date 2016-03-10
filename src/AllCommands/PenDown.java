package AllCommands;

import java.util.List;
import CommandTypes.TurtleCommand;
import Turtle.*;


public class PenDown extends TurtleCommand {

    public PenDown (List<SingleTurtle> turtle) {
        super(turtle);   
    }

    @Override
    public String executeCommand () {
        System.out.println("Put your pen down!");
        for (SingleTurtle aturtle : myTurtle) {
            aturtle.setPen(PENDOWN);
        }
        return Integer.toString(PENDOWN);
    }
}
