package AllCommands;

import Commands.TurtleCommand;
import Main.Turtle;


public class IsPenDown extends TurtleCommand {

    public IsPenDown (Turtle turtle) {
        super(turtle);
    }

    @Override
    public String executeCommand () {
        return String.valueOf((myTurtle.getPen()));
    }
}
