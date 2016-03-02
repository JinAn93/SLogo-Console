package TurtleQuery;

import Commands.TurtleQueriesCommand;
import Main.Turtle;


public class IsShowing extends TurtleQueriesCommand {

    public IsShowing (Turtle turtle) {
        super(turtle);
    }

    @Override
    public String executeCommand () {
        return String.valueOf((myTurtle.getVisibility()));
    }
}
