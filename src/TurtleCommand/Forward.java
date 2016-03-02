package TurtleCommand;

import Commands.Node;
import Commands.TurtleCommand;
import Main.Turtle;


public class Forward extends TurtleCommand {
    private Node[] myChildren;
//    private Turtle myTurtle;

    public Forward (Turtle turtle) {
        super(turtle);
//        myTurtle = turtle;
        System.out.println(myTurtle);
    }

    @Override
    public String executeCommand () {
        System.out.println(this.myTurtle);
        double moveBy = Double.parseDouble(myChildren[FIRSTCHILD].getValue());
        double radian = Math.toRadians(myTurtle.getHeading());
        myTurtle.setEndXCor(myTurtle.getStartXCor() + (moveBy * (Math.cos(radian))));
        myTurtle.setEndYCor(myTurtle.getStartYCor() + (moveBy * (Math.sin(radian))));
        return myChildren[FIRSTCHILD].getValue();
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
