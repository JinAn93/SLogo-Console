package TurtleCommand;

import Commands.Node;
import Commands.TurtleCommand;
import Main.Turtle;


public class Forward extends TurtleCommand {
    public final int NUMBEROFCHILDREN = 1;
    private Node[] children = new Node[NUMBEROFCHILDREN];
    private Turtle myTurtle;

    public Forward (Turtle turtle) {
        super(turtle);
        myTurtle = turtle;
    }

    @Override
    public String executeCommand () {
        double moveBy = Double.parseDouble(children[0].getValue());
        double radian = Math.toRadians(myTurtle.getHeading());
        myTurtle.setXCor(myTurtle.getXCor() + (moveBy * (Math.cos(radian))));
        myTurtle.setYCor(myTurtle.getYCor() + (moveBy * (Math.sin(radian))));
        return children[0].getValue();
    }
    
    @Override
    public void setChildren (Node[] kids) {
        for (int i = 0; i < kids.length; i++) {
            children[i] = kids[i];
        }
    }
    
    @Override
    public Node[] getChildren(){
        return children;
    }
}
