package AllCommands;

import java.util.List;
import CommandTypes.TurtleCommand;
import Turtle.SingleTurtle;


/**
 * subclass of turtlecommand: serves to set each turtle's position.
 *
 * @author Jin An
 *
 */
public class SetPosition extends TurtleCommand {

    private static final int SQUARE = 2;

    public SetPosition (List<SingleTurtle> turtle) {
        super(turtle);
    }

    @Override
    public String executeOnSingleTurtle (SingleTurtle t) {
        double EndX = Double.parseDouble(myChildren[FIRSTCHILD].getValue());
        double EndY = Double.parseDouble(myChildren[SECONDCHILD].getValue());
        t.setEndXYCor(EndX, EndY);
        return Double.toString(Math.sqrt(Math.pow(EndX, SQUARE) + Math.pow(EndY, SQUARE)));
    }

}
