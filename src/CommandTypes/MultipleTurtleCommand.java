package CommandTypes;

import java.util.List;
import java.util.ResourceBundle;
import NodeTypes.Command;
import Turtle.SingleTurtle;


/**
 * MultipleTurtleCommand is the super class of Ask, ID, Tell commands and subclass of TurtleCommand.
 * It will use the TurtleManager object to find out the active turtles and execute accordingly.
 * 
 * @author Jin An
 *
 */
public abstract class MultipleTurtleCommand extends Command {

    protected List<SingleTurtle> myTurtle;
    protected List<String> myTurtleIndex;
    protected String myTurtleCommands;
    protected ResourceBundle myLanguage;
}
