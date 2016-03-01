package MathCommands;

import java.util.ResourceBundle;
import Commands.MathOpCommand;
import Commands.Node;


public class Remainder extends MathOpCommand {
    private Node[] myChildren;

    @Override
    public String executeCommand () {
        double remainder = Double.parseDouble(myChildren[FIRSTCHILD].getValue());
        remainder = remainder % Double.parseDouble(myChildren[SECONDCHILD].getValue());
        return Double.toString(remainder);
    }

    @Override
    public Node[] getChildren () {
        return myChildren;
    }
    
    @Override
    public void setChildren (Node[] kids){
        myChildren = kids;
    }

}
