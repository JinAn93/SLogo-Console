package CommandTypes;

import NodeTypes.*;


/**
 * BoolOpCommand is a subclass of Command and superclass of specific commands (equal, if..). It has
 * protected final variables that are used multiple times in subclasses.
 * 
 * @author Jin An
 *
 */
public abstract class BoolOpCommand extends Command {
    protected static final String TRUE = "1";
    protected static final String FALSE = "0";
}
