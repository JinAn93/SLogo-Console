package Commands;

import java.util.ResourceBundle;
import Main.Turtle;

public class TurtleCommand extends Command {

    private Turtle myTurtle;
    public static final int FIRSTCHILD = 0;
    
    public TurtleCommand(Turtle turtle){
        myTurtle = turtle;
    }
    
    public String executeCommand (Turtle turtle){
        return null;
    }
    
    public String getValue(Turtle turtle){
        return executeCommand(turtle);
    }

    @Override
    public void setChildren (Node[] kids) {
    }

    @Override
    public Node[] getChildren () {
        return null;
    }
}
