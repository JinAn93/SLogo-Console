package AllCommands;

import Commands.TurtleCommand;
import Main.Turtle;


public class Forward extends TurtleCommand {

    public Forward (Turtle turtle) {
        super(turtle);
    }

    @Override
    public String executeCommand () {
        System.out.println("He");
        double moveBy = Double.parseDouble(myChildren[FIRSTCHILD].getValue());
        double radian = Math.toRadians(myTurtle.getHeading());
        myTurtle.setEndXCor(myTurtle.getStartXCor() + (moveBy * (Math.cos(radian))));
        myTurtle.setEndYCor(myTurtle.getStartYCor() + (moveBy * (Math.sin(radian))));
        return Double.toString(moveBy);
    }
}
