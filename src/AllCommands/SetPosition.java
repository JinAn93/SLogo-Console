package AllCommands;

import java.util.List;
import Turtle.SingleTurtle;
import CommandTypes.TurtleCommand;

public class SetPosition extends TurtleCommand{

    public SetPosition (List<SingleTurtle> turtle) {
        super(turtle);
    }

    @Override
    public String executeCommand () {
        double EndX = Double.parseDouble(myChildren[FIRSTCHILD].getValue());
        double EndY = Double.parseDouble(myChildren[SECONDCHILD].getValue()); 
        aturtle.setEndXYCor(EndX, EndY);
        return Double.toString(Math.sqrt(Math.pow(EndX, 2) + Math.pow(EndY,2)));
    }

}
