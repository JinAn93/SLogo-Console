package CommandTypes;

import NodeTypes.Command;


/**
 * MahtOpCommand is a subclass of Command and super class of math commands (sum, product, random..)
 * It contains protected final variables that are used multiple times in subclasses.
 *
 * @author Jin An
 *
 */
public abstract class MathOpCommand extends Command {

    protected static final int MINUS = -1;
}
