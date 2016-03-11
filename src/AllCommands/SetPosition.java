package AllCommands;

import java.util.List;
import Turtle.SingleTurtle;
import CommandTypes.TurtleCommand;


/**
 * subclass of turtlecommand: serves to set each turtle's position.
 * 
 * @author Jin An
 *
 */
public class SetPosition extends TurtleCommand {

    public SetPosition (List<SingleTurtle> turtle) {
        super(turtle);
    }

    @Override
    public String executeOnSingleTurtle (SingleTurtle t) {
        double EndX = Double.parseDouble(myChildren[FIRSTCHILD].getValue());
        double EndY = Double.parseDouble(myChildren[SECONDCHILD].getValue());
        t.setEndXYCor(EndX, EndY);
        return Double.toString(Math.sqrt(Math.pow(EndX, 2) + Math.pow(EndY, 2)));
    }

}
