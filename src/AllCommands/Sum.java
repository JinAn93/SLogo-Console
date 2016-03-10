package AllCommands;

import CommandTypes.MathOpCommand;


public class Sum extends MathOpCommand {

    @Override
    public String executeCommand () {
        double firstValue = Double.parseDouble(myChildren[FIRSTCHILD].getValue());
        double secondValue = Double.parseDouble(myChildren[SECONDCHILD].getValue());
        System.out.println("The sum result is : " + (firstValue + secondValue));
        return Double.toString(firstValue + secondValue);
    }
}
