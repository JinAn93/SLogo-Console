package AllCommands;

import Commands.TurtleCommand;
import Main.Turtle;


public class IsShowing extends TurtleCommand {

    public IsShowing (Turtle turtle) {
        super(turtle);
    }

    @Override
    public String executeCommand () {
        return String.valueOf((myTurtle.getVisibility()));
    }
}
