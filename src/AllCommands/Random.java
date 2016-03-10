package AllCommands;

import CommandTypes.MathOpCommand;

public class Random extends MathOpCommand{

    @Override
    public String executeCommand () {
        double max = Double.parseDouble(myChildren[FIRSTCHILD].getValue());
        return Double.toString(Math.random() * max);
    }
}
