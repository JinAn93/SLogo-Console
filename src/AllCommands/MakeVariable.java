package AllCommands;

import Commands.Command;
import Commands.Variable;
import Main.MainBackEnd;


public class MakeVariable extends Command {

    protected static final int NAMEINDEX = 0;
    protected static final int VALUEINDEX = 1;

    @Override
    public String executeCommand () {
        Variable newVar = new Variable();
        newVar.setName(((Variable) myChildren[NAMEINDEX]).getName());
        newVar.setValue(myChildren[VALUEINDEX].getValue());
        MainBackEnd.getVariables().add(newVar);
        return newVar.getValue();
    }
}
