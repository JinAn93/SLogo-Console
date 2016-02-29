package Commands;

import Main.Turtle;

public class TurtleCommand extends Command {

    private Turtle myTurtle;
    
    public TurtleCommand(Turtle turtle){
        myTurtle = turtle;
    }
    
    public String executeCommand (Turtle turtle){
        return null;
    }
    
    public String getValue(Turtle turtle){
        return executeCommand(turtle);
    }
}
