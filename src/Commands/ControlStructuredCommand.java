package Commands;

import java.util.List;
import java.util.ResourceBundle;
import Main.Turtle;


public abstract class ControlStructuredCommand extends Command {

    protected String myContent;
    protected String myControlContent;
    protected List<Turtle> myTurtle;
    protected ResourceBundle myLanguage;
    protected List<Variable> myVariableList;
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
    protected static final String PARAMETER_ERROR = "WRONG PARAMETER.";
    protected static final String VARIABLE_ERROR = "WRONG VARIABLE SYNTAX.";
    protected static final int INDEX_COLON = 1;
    protected static final int INDEX_FIRSTCHAR = 0;
}
