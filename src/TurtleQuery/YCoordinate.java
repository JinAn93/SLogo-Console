package TurtleQuery;

import Commands.TurtleQueriesCommand;
import Main.Turtle;

public class YCoordinate extends TurtleQueriesCommand{
    @Override
    public String executeCommand (Turtle turtle){
        return String.valueOf((turtle.getYCor()));
    }
    
    public String getValue (Turtle turtle){
        return executeCommand(turtle);
    }
}
