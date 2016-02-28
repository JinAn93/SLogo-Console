package TurtleQuery;

import Commands.TurtleQueriesCommand;
import Main.Turtle;

public class Heading extends TurtleQueriesCommand{
    @Override
    public String executeCommand (Turtle turtle){
        return String.valueOf((turtle.getHeading()));
    }
    
    public String getValue (Turtle turtle){
        return executeCommand(turtle);
    }
}
