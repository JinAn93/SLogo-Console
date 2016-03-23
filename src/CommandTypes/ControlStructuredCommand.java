package CommandTypes;

import java.util.List;
import java.util.ResourceBundle;
import NodeTypes.Command;
import NodeTypes.UserCommand;
import NodeTypes.Variable;
import Turtle.SingleTurtle;


/**
 * ControlStructuredCommand class is a subclass of command and super class of specific commands (If,
 * repeat..). It has protected variables that are used multiple times in subclass.
 *
 * @author Jin An
 *
 */
public abstract class ControlStructuredCommand extends Command {

    protected String myContent;
    protected String myControlContent;
    protected List<SingleTurtle> myTurtle;
    protected ResourceBundle myLanguage;
    protected List<Variable> myVariableList;
    protected List<UserCommand> myUserCommandList;
    protected static final int FALSE = 0;
    protected static final int NUMREPEATINDEX = 0;
    protected static final int ERROR = -1;
    protected static final int COMMAND_INDEX = 0;
    protected static final int CONTROL_INDEX = 1;
    protected static final int INDEX_COLON = 1;
    protected static final int INDEX_FIRSTCHAR = 0;
    protected static final char COLON = ':';
}
