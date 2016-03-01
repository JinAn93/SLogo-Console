package Commands;

import java.util.ResourceBundle;


public class MathOpCommand extends Command {

    public static final int FIRSTCHILD = 0;
    public static final int SECONDCHILD = 1;
    
    public String getValue () {
        return executeCommand();
    }

    @Override
    public void setChildren (Node[] kids) {
    }

    @Override
    public Node[] getChildren () {
        return null;
    }
}
