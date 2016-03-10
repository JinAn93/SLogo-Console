package CommandTypes;

import java.util.List;
import java.util.ResourceBundle;
import Turtle.*;
import NodeTypes.*;


public abstract class ControlStructuredCommand extends Command {

    protected String myContent;
    protected String myControlContent;
    protected List<SingleTurtle> myTurtle;
    protected ResourceBundle myLanguage;
    protected List<Variable> myVariableList;
    protected List<UserCommand> myUserCommandList;
    protected static final int FIRSTCHILD = 0;
    protected static final int SECONDCHILD = 1;
    protected static final int NUMREPEATINDEX = 0;
    protected static final String ZERO = "0";
    protected static final String ONE_INDEXDEFAULT = "1";
    protected static final String SPACE = " ";
    protected static final String INSTRUCTION_ERROR = "WRONG COMMAND.";
    protected static final int COMMAND_INDEX = 0;
    protected static final int CONTROL_INDEX = 1;
    protected static final char COLON = ':';
    protected static final int INDEX_COLON = 1;
    protected static final int INDEX_FIRSTCHAR = 0;
}
