package TurtleCommand;

import java.util.ResourceBundle;
import Commands.Node;
import Commands.TurtleCommand;
import Main.Turtle;


public class Right extends TurtleCommand {

    private Turtle myTurtle;
    private Node[] myChildren;
    
    public Right (Turtle turtle) {
        super(turtle);
        myTurtle = turtle;
    }

    @Override
    public String executeCommand(){
        myTurtle.setHeading(myTurtle.getHeading() + Double.parseDouble(myChildren[FIRSTCHILD].getValue()));
        return myChildren[FIRSTCHILD].getValue();
    }
    
    @Override
    public void setChildren (Node[] kids){
        myChildren = kids;
    }
    
    @Override
    public Node[] getChildren (){
        return myChildren;
    }
}
