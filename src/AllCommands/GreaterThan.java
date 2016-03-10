package AllCommands;

import CommandTypes.BoolOpCommand;

public class GreaterThan extends BoolOpCommand{

    @Override
    public String executeCommand () {
        if (Double.parseDouble(myChildren[FIRSTCHILD].getValue()) > Double.parseDouble((myChildren[SECONDCHILD].getValue())))
            return TRUE;
        else
            return FALSE;
    }
}
