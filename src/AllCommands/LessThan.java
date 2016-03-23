package AllCommands;

import CommandTypes.BoolOpCommand;


/**
 * subclass of boolopcommand: returns 1 if less than 0 if not.
 *
 * @author Jin An
 *
 */
public class LessThan extends BoolOpCommand {

    @Override
    public String executeCommand () {
        if (Double.parseDouble(myChildren[FIRSTCHILD].getValue()) < Double
                .parseDouble((myChildren[SECONDCHILD].getValue()))) {
            return TRUE;
        }
        else {
            return FALSE;
        }
    }
}
