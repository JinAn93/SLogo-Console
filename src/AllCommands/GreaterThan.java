package AllCommands;

import CommandTypes.BoolOpCommand;


/**
 * subclass of BoolOpCommand: returns boolean based on comparison between two children
 *
 * @author Jin An
 *
 */
public class GreaterThan extends BoolOpCommand {

    @Override
    public String executeCommand () {
        if (Double.parseDouble(myChildren[FIRSTCHILD].getValue()) > Double
                .parseDouble((myChildren[SECONDCHILD].getValue()))) {
            return TRUE;
        }
        else {
            return FALSE;
        }
    }
}
