package AllCommands;

import Commands.TurtleCommand;
import Main.Turtle;


public class Pendown extends TurtleCommand {
    
    public Pendown (Turtle turtle) {
        super(turtle);
    }

    @Override
    public String executeCommand () {
        myTurtle.setPen(PENDOWN);
        return Integer.toString(PENDOWN);
    }
}
