package AllCommands;

import Commands.MathOpCommand;


public class Minus extends MathOpCommand {

    @Override
    public String executeCommand () {
        double minus = (-1) * Double.parseDouble(myChildren[0].getValue());
        return Double.toString(minus);
    }
}
