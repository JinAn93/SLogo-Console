package AllCommands;

import java.util.List;
import Turtle.SingleTurtle;
import CommandTypes.DisplayCommand;


/**
 * SetPenSize serves to set each turtle's pen size to the value of input. We can use the commented
 * line if we fully implement the TurtlePen object into turtle. It is demonstrated in
 * SingleTurtle/Turtlepen Class
 * 
 * @author Jin An
 *
 */
public class SetPenSize extends DisplayCommand {

    public SetPenSize (List<SingleTurtle> turtle) {
        super(turtle);
    }

    @Override
    public String executeOnSingleTurtle (SingleTurtle t) {
        String newPenSize = myChildren[FIRSTCHILD].getValue();
        // t.getTurtlePen().setPenSize(Double.parseDouble(newPenSize));
        t.setPenWidth(Double.parseDouble(newPenSize));
        return newPenSize;
    }

}
