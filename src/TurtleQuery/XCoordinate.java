package TurtleQuery;

import Commands.TurtleQueriesCommand;
import Main.Turtle;

public class XCoordinate extends TurtleQueriesCommand{
    @Override
    public String executeCommand (Turtle turtle){
        return String.valueOf((turtle.getXCor()));
    }
    
    public String getValue (Turtle turtle){
        return executeCommand(turtle);
    }
}
