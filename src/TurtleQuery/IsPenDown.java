package TurtleQuery;

import Commands.TurtleQueriesCommand;
import Main.Turtle;


public class IsPenDown extends TurtleQueriesCommand {

    private Turtle myTurtle;

    public IsPenDown (Turtle turtle) {
        super(turtle);
    }

    @Override
    public String executeCommand () {
        return String.valueOf((myTurtle.getPen()));
    }
}
