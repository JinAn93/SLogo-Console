package TurtleQuery;

import Commands.TurtleQueriesCommand;
import Main.Turtle;


public class YCoordinate extends TurtleQueriesCommand {

    public YCoordinate (Turtle turtle) {
        super(turtle);
    }

    @Override
    public String executeCommand () {
        return String.valueOf((myTurtle.getStartYCor()));
    }
}
