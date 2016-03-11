package CommandTypes;

import java.util.List;
import NodeTypes.*;
import Turtle.*;


/**
 * TurtleCommand is a subclass of command and super class of all commands involved with
 * turtle (forward, right turn..) It has protected final variables that are used multiple times in
 * subclasses.
 * 
 * @author Jin An
 *
 */
public abstract class TurtleCommand extends Command {

    protected static final int FIRSTCHILD = 0;
    protected static final int SECONDCHILD = 1;
    protected static final int PENUP = 0;
    protected static final int PENDOWN = 1;
    protected List<SingleTurtle> myTurtle;

    public TurtleCommand (List<SingleTurtle> turtle) {
        myTurtle = turtle;
    }

    /**
     * When the executeCommand method is called, it goes through the Turtle Manager and get the ids
     * for active turtles. Then, it executes the commands for all active turtles
     */
    public String executeCommand () {
        TurtleManager turtleManager = new TurtleManager(myTurtle);
        List<Integer> activeTurtleID = turtleManager.findActiveTurtles();
        String returnValue = null;
        for (Integer activeIndex : activeTurtleID) {
            returnValue = executeOnSingleTurtle(myTurtle.get(activeIndex));
        }
        return returnValue;
    }

    /**
     * This will be overrided by subclasses.
     * 
     * @param t
     * @return
     */
    public String executeOnSingleTurtle (SingleTurtle t) {
        return null;
    }
}
