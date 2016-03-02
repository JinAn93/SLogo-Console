package AllCommands;

import Commands.TurtleCommand;
import Main.Turtle;


public class Penup extends TurtleCommand {

    public Penup (Turtle turtle) {
        super(turtle);
    }

    @Override
    public String executeCommand () {
        myTurtle.setPen(PENUP);
        return Integer.toString(PENUP);
    }
}
