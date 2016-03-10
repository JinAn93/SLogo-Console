package CommandTypes;

import NodeTypes.*;


public abstract class BoolOpCommand extends Command {
    protected static final int FIRSTCHILD = 0;
    protected static final int SECONDCHILD = 1;
    protected static final String TRUE = "1";
    protected static final String FALSE = "0";
}
