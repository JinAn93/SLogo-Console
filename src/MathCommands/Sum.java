package MathCommands;

import Commands.*;


public class Sum extends MathOpCommand {

    @Override
    public String executeCommand () {
        double firstValue = Double.parseDouble(myChildren[FIRSTCHILD].getValue());
        double secondValue = Double.parseDouble(myChildren[SECONDCHILD].getValue());
        return Double.toString(firstValue + secondValue);
    }
}
