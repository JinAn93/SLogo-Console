package AllCommands;

import BackEndMain.MainBackEnd;
import NodeTypes.Command;
import NodeTypes.Variable;


/**
 * MakeVariable serves to create user-defined variable. If the variable already exists, it replaces
 * the pre-existing variable.
 *
 * @author Jin An
 *
 */
public class MakeVariable extends Command {

    protected static final int NAMEINDEX = 0;
    protected static final int VALUEINDEX = 1;

    @Override
    public String executeCommand () {
        Variable newVar = new Variable();
        newVar.setName(((Variable) myChildren[NAMEINDEX]).getName());
        newVar.setValue(myChildren[VALUEINDEX].getValue());
        Variable existCheck = isAlreadyExist(newVar);
        if (existCheck != null) {
            existCheck.setValue(newVar.getValue());
        }
        else {
            MainBackEnd.getVariables().add(newVar);
        }
        return newVar.getValue();
    }

    private Variable isAlreadyExist (Variable newVar) {
        if (MainBackEnd.getVariables().isEmpty()) {
            return null;
        }
        for (Variable var : MainBackEnd.getVariables()) {
            if ((var.getName().equals(newVar.getName()))) {
                return var;
            }
        }
        return null;
    }
}
