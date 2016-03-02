package AllCommands;

import Commands.TurtleQueriesCommand;
import Main.Turtle;


public class Heading extends TurtleQueriesCommand {

    public Heading (Turtle turtle) {
        super(turtle);
    }

    @Override
    public String executeCommand () {
        return String.valueOf((myTurtle.getHeading()));
    }
}
