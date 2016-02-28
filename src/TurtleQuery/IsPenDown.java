package TurtleQuery;

import Commands.TurtleQueriesCommand;
import Main.Turtle;

public class IsPenDown extends TurtleQueriesCommand{
    @Override
    public String executeCommand (Turtle turtle){
        return String.valueOf((turtle.getPen()));
    }
    
    public String getValue (Turtle turtle){
        return executeCommand(turtle);
    }
}
