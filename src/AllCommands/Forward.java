package AllCommands;

import java.util.List;
import CommandTypes.TurtleCommand;
import Turtle.*;


/**
 * subclass of TurtleCommand: it serves to change Turtle's position (for each active turtle)
 * depending on the angle of heading.
 * 
 * @author Jin An
 *
 */
public class Forward extends TurtleCommand {

    public Forward (List<SingleTurtle> turtle) {
        super(turtle);
    }

    @Override
    public String executeOnSingleTurtle (SingleTurtle t) {
        double moveBy = 0;
        moveBy = Double.parseDouble(myChildren[FIRSTCHILD].getValue());
        double radian = Math.toRadians(t.getHeading());
        double xCorMovement = t.getStartXCor() + (moveBy * (Math.cos(radian)));
        double yCorMovement = t.getStartYCor() + (moveBy * (Math.sin(radian)));
        t.setEndXYCor(xCorMovement, yCorMovement);
        return Double.toString(moveBy);
    }
}
