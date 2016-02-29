package TurtleQuery;

import Commands.TurtleQueriesCommand;
import Main.Turtle;


public class YCoordinate extends TurtleQueriesCommand {
    private Turtle myTurtle;

    public YCoordinate (Turtle turtle) {
        super(turtle);
    }

    @Override
    public String executeCommand () {
        return String.valueOf((myTurtle.getYCor()));
    }
}
