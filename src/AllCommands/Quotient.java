package AllCommands;

import CommandTypes.MathOpCommand;


public class Quotient extends MathOpCommand {

    @Override
    public String executeCommand () {
        double quotient = Double.parseDouble(myChildren[FIRSTCHILD].getValue());
        quotient /= Double.parseDouble(myChildren[SECONDCHILD].getValue());
        return Double.toString(quotient);
    }
}
