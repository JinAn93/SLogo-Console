package MathCommands;

import java.util.ResourceBundle;
import Commands.MathOpCommand;
import Commands.Node;


public class Quotient extends MathOpCommand {

    private Node[] myChildren;
    
    @Override
    public String executeCommand () {
        double quotient = Double.parseDouble(myChildren[FIRSTCHILD].getValue());
        quotient /= Double.parseDouble(myChildren[SECONDCHILD].getValue());
        return Double.toString(quotient);
    }
    
    @Override
    public void setChildren (Node[] kids){
        myChildren = kids;
    }
    
    @Override
    public Node[] getChildren () {
        return myChildren;
    }
}
