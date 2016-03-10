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
        double EndX = 0, EndY = 0;
        for(SingleTurtle aturtle : myTurtle){
            EndX = Double.parseDouble(myChildren[FIRSTCHILD].getValue());
            EndY = Double.parseDouble(myChildren[SECONDCHILD].getValue());
            aturtle.setEndXYCor(EndX, EndY);
        }
        // TODO Auto-generated method stub
        return Double.toString(Math.sqrt(Math.pow(EndX, 2) + Math.pow(EndY,2)));
    }

}
