package Commands;

import java.util.List;
import java.util.ResourceBundle;
import Main.Turtle;


public abstract class ControlStructuredCommand extends Command {

    protected String myContent;
    protected Turtle myTurtle;
    protected ResourceBundle myLanguage;
    protected List<Variable> myVariableList;
    protected static final int FIRSTCHILD = 0;
    protected static final int SECONDCHILD = 1;
    protected static final int NUMREPEATINDEX = 0;
}
