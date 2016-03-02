package Commands;

import java.util.List;
import java.util.ResourceBundle;
import Main.Turtle;

public abstract class UserDefinedCommand extends Command {

    protected Node[] myChildren;
    protected String myContent;
    protected Turtle myTurtle;
    protected ResourceBundle myLanguage;
    protected List<Variable> myVariableList;
    protected static final int FIRSTCHILD = 0;
    protected static final int SECONDCHILD = 1;
    protected static final int numRepeatIndex = 0;
    
    
    public String getValue () {
        return executeCommand();
    }

    @Override
    public void setChildren (Node[] kids) {
        myChildren = kids;
    }

    @Override
    public Node[] getChildren () {
        return myChildren;
    }
}
