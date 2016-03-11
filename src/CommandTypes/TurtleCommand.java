package CommandTypes;

import java.util.List;
import NodeTypes.*;
import Turtle.*;


public abstract class TurtleCommand extends Command {

    protected static final int FIRSTCHILD = 0;
    protected static final int SECONDCHILD = 1;
    protected static final int PENUP = 0;
    protected static final int PENDOWN = 1;
    protected List<SingleTurtle> myTurtle;
    
    public TurtleCommand (List<SingleTurtle> turtle) {
        myTurtle = turtle;
    }
    
    public String executeCommand () {
        System.out.println("Execute Me!");
        TurtleManager turtleManager = new TurtleManager(myTurtle);
        List<Integer> activeTurtleID = turtleManager.findActiveTurtles();
        String returnValue = null;
        for(Integer activeIndex : activeTurtleID){
            returnValue = executeOnSingleTurtle(myTurtle.get(activeIndex));
        }
        return returnValue;
    }
    
    public String executeOnSingleTurtle(SingleTurtle t){
        return null;
    }
}
