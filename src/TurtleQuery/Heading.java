package TurtleQuery;

import Commands.TurtleQueriesCommand;
import Main.Turtle;


public class Heading extends TurtleQueriesCommand {
    private Turtle myTurtle;

    public Heading (Turtle turtle) {
        super(turtle);
    }

    @Override
    public String executeCommand () {
        return String.valueOf((myTurtle.getHeading()));
    }
}
