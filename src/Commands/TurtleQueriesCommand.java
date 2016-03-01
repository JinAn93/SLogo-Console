package Commands;

import java.util.ResourceBundle;
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

    @Override
    public void setChildren (Node[] kids, ResourceBundle parameters) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Node[] getChildren () {
        // TODO Auto-generated method stub
        return null;
    }
}
