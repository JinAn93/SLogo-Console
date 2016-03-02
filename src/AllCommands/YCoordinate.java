package AllCommands;

import Commands.TurtleCommand;
import Main.Turtle;


public class YCoordinate extends TurtleCommand {

    public YCoordinate (Turtle turtle) {
        super(turtle);
    }

    @Override
    public String executeCommand () {
        return String.valueOf((myTurtle.getStartYCor()));
    }
}
