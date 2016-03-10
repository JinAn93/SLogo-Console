package AllCommands;

import CommandTypes.BoolOpCommand;


public class Equal extends BoolOpCommand {

    @Override
    public String executeCommand () {
        if (myChildren[FIRSTCHILD].getValue().equals(myChildren[SECONDCHILD].getValue()))
            return TRUE;
        else
            return FALSE;
    }
}
