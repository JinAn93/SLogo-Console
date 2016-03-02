package AllCommands;

import Commands.TurtleQueriesCommand;
import Main.Turtle;


public class IsPenDown extends TurtleQueriesCommand {

    public IsPenDown (Turtle turtle) {
        super(turtle);
    }

    @Override
    public String executeCommand () {
        return String.valueOf((myTurtle.getPen()));
    }
}
