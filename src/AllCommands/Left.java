package AllCommands;

import java.util.List;
import Turtle.SingleTurtle;
import CommandTypes.TurtleCommand;


public class Left extends TurtleCommand {

    public Left (List<SingleTurtle> turtle) {
        super(turtle);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String executeOnSingleTurtle (SingleTurtle t) {
        double changeinHeading = Double.parseDouble(myChildren[FIRSTCHILD].getValue());
        t.setHeading(t.getHeading() - changeinHeading);
        return myChildren[FIRSTCHILD].getValue();
    }
}
