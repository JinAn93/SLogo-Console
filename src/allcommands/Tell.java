package allcommands;

import java.util.Arrays;
import java.util.List;
import Turtle.SingleTurtle;
import BackEndMain.StrConstant;
import CommandTypes.MultipleTurtleCommand;


/**
 * One demonstration of multipleturtle command. It takes in the list of turtle index that is being
 * told. Then, those turtles are set active and others are inactive.
 * 
 * @author Jin An
 *
 */
public class Tell extends MultipleTurtleCommand {

    public Tell (List<SingleTurtle> turtle, List<StringBuilder> ListOfContents) {
        myTurtle = turtle;
        myTurtleIndex =
                Arrays.asList(ListOfContents.get(FIRSTCHILD).toString().split(StrConstant.SPACE));
    }

    @Override
    public String executeCommand () {
        int returnIndex = 0;
        for (int i = 0; i < myTurtle.size(); i++) {
            boolean isIntheList = myTurtleIndex.contains((i + ""));
            myTurtle.get(i).setActive(isIntheList);
            returnIndex = i;
        }
        return Integer.toString(returnIndex);
    }
}
