package TurtleCommand;

import Commands.Node;
import Commands.TurtleCommand;
import Main.Turtle;


public class Right extends TurtleCommand {

    private Turtle myTurtle;
    public final int NUMBEROFCHILDREN = 1;
    private Node[] children = new Node[NUMBEROFCHILDREN];
    
    public Right (Turtle turtle) {
        super(turtle);
        myTurtle = turtle;
    }

    @Override
    public String executeCommand(){
        myTurtle.setHeading(myTurtle.getHeading() + Double.parseDouble(children[0].getValue()));
        return children[0].getValue();
    }
    
    @Override
    public void setChildren (Node[] kids){
        for (int i=0; i<kids.length; i++){
            children[i] = kids[i];
        }
    }
}
