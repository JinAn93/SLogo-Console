package AllCommands;

import Commands.TurtleCommand;
import Main.Turtle;


public class XCoordinate extends TurtleCommand {

    public XCoordinate (Turtle turtle) {
        super(turtle);
    }

    @Override
    public String executeCommand () {
        return String.valueOf((myTurtle.getStartXCor()));
    }
}
