package TurtleQuery;

import Commands.TurtleQueriesCommand;
import Main.Turtle;


public class IsShowing extends TurtleQueriesCommand {

    private Turtle myTurtle;

    public IsShowing (Turtle turtle) {
        super(turtle);
        myTurtle = turtle;
    }

    @Override
    public String executeCommand () {
        return String.valueOf((myTurtle.getVisibility()));
    }
}
    