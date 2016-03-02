package AllCommands;

import Commands.TurtleCommand;
import Main.Turtle;


public class PenUp extends TurtleCommand {

    public PenUp (Turtle turtle) {
        super(turtle);
    }

    @Override
    public String executeCommand () {
        myTurtle.setPen(PENUP);
        return Integer.toString(PENUP);
    }
}
