package AllCommands;

import java.util.List;
import Commands.TurtleCommand;
import Main.SingleTurtle;
import Main.Turtle;


public class YCoordinate extends TurtleCommand {

    public YCoordinate (List<SingleTurtle> turtle) {
        super(turtle);
    }

    @Override
    public String executeCommand () {
        String ret = null;
        for(Turtle aturtle:myTurtle){
        ret = String.valueOf((aturtle.getStartYCor()));
        }
        return ret;
    }
}
