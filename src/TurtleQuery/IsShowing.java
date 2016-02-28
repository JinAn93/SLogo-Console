package TurtleQuery;

import Commands.TurtleQueriesCommand;
import Main.Turtle;

public class IsShowing extends TurtleQueriesCommand{
    @Override
    public String executeCommand (Turtle turtle){
        return String.valueOf((turtle.getVisibility()));
    }
    
    public String getValue (Turtle turtle){
        return executeCommand(turtle);
    }
}
