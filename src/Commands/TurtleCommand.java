package Commands;

import java.util.List;
import Main.SingleTurtle;
import Main.Turtle;


public abstract class TurtleCommand extends Command {

    protected static final int FIRSTCHILD = 0;
    protected static final int PENUP = 0;
    protected static final int PENDOWN = 1;
    protected List<SingleTurtle> myTurtle;

    public TurtleCommand (List<SingleTurtle> turtle) {
        myTurtle = turtle;
    }
}
