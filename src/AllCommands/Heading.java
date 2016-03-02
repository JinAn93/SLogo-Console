package AllCommands;

import Commands.TurtleCommand;
import Main.Turtle;


public class Heading extends TurtleCommand {

    public Heading (Turtle turtle) {
        super(turtle);
    }

    @Override
    public String executeCommand () {
        return String.valueOf((myTurtle.getHeading()));
    }
}
