package AllCommands;

import CommandTypes.MathOpCommand;


public class Sine extends MathOpCommand {

    @Override
    public String executeCommand () {
        double radian = Math.toRadians(Double.parseDouble(myChildren[FIRSTCHILD].getValue()));
        return Double.toString(Math.sin(radian));
    }
}
