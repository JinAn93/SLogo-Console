package Commands;

import java.util.ResourceBundle;


public class MathOpCommand extends Command {

    public String getValue () {
        return executeCommand();
    }

    @Override
    public void setChildren (Node[] kids, ResourceBundle parameters) {
    }

    @Override
    public Node[] getChildren () {
        return null;
    }
}
