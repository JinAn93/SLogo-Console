package AllCommands;

import Commands.TurtleCommand;
import Main.Turtle;


public class PenDown extends TurtleCommand {
    
    public PenDown (Turtle turtle) {
        super(turtle);
    }

    @Override
    public String executeCommand () {
        myTurtle.setPen(PENDOWN);
        return Integer.toString(PENDOWN);
    }
}
