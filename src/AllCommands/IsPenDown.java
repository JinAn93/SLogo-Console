package AllCommands;

import java.util.List;
import CommandTypes.TurtleCommand;
import Turtle.*;


public class IsPenDown extends TurtleCommand {

    public IsPenDown (List<SingleTurtle> turtle) {
        super(turtle);
    }

    @Override
    public String executeCommand () {
        String ret = null;
        for(Turtle aturtle:myTurtle){
        ret = String.valueOf((aturtle.getPen()));
        }
        return ret;
    }
}
