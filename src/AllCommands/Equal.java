package AllCommands;

import CommandTypes.BoolOpCommand;


/**
 * Subclass of BoolOpCommand: compares two children and return true if equal.
 * 
 * @author Jin An
 *
 */
public class Equal extends BoolOpCommand {

    @Override
    public String executeCommand () {
        if (myChildren[FIRSTCHILD].getValue().equals(myChildren[SECONDCHILD].getValue()))
            return TRUE;
        else
            return FALSE;
    }
}
