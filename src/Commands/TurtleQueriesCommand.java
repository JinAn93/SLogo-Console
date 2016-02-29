package Commands;

import Main.Turtle;

public class TurtleQueriesCommand extends Command {

    private Turtle myTurtle;
    
    public TurtleQueriesCommand(Turtle turtle){
        myTurtle = turtle;
    }
    
    public String executeCommand (Turtle turtle){
        return null;
    }
    
    public String getValue(Turtle turtle){
        return executeCommand(turtle);
    }
}
