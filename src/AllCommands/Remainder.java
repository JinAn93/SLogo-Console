package AllCommands;

import CommandTypes.MathOpCommand;


public class Remainder extends MathOpCommand {

    @Override
    public String executeCommand () {
        double remainder = Double.parseDouble(myChildren[FIRSTCHILD].getValue());
        remainder = remainder % Double.parseDouble(myChildren[SECONDCHILD].getValue());
        return Double.toString(remainder);
    }
}
