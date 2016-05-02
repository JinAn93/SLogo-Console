package allcommands;

import java.util.List;
import CommandTypes.TurtleCommand;
import Turtle.SingleTurtle;


/**
 * subclass of TurtleCommand: for each turtle, rotate turtle based on heading
 *
 * @author Jin An
 *
 */
public class Left extends TurtleCommand {

    public Left (List<SingleTurtle> turtle) {
        super(turtle);
    }

    @Override
    public String executeOnSingleTurtle (SingleTurtle t) {
        double changeinHeading = Double.parseDouble(myChildren[FIRSTCHILD].getValue());
        t.setHeading(t.getHeading() - changeinHeading);
        return myChildren[FIRSTCHILD].getValue();
    }
}
