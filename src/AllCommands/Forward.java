package AllCommands;

import java.util.List;
import CommandTypes.TurtleCommand;
import Turtle.*;


public class Forward extends TurtleCommand {

    public Forward (List<SingleTurtle> turtle) {
        super(turtle);
    }

    @Override
    public String executeCommand () {
        double moveBy = 0;
        System.out.println("execute forward");
        for (SingleTurtle aturtle : myTurtle) {
            moveBy = Double.parseDouble(myChildren[FIRSTCHILD].getValue());
            double radian = Math.toRadians(aturtle.getHeading());
            double xCorMovement = aturtle.getStartXCor() + (moveBy * (Math.cos(radian)));
            double yCorMovement = aturtle.getStartYCor() + (moveBy * (Math.sin(radian)));
            aturtle.setEndXYCor(xCorMovement,yCorMovement);
            System.out.println("We are moving by : '" + moveBy + "'");

        }
        return Double.toString(moveBy);
    }
}
