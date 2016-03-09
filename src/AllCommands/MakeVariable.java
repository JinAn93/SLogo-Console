package AllCommands;

import NodeTypes.*;
import BackEndMain.*;


public class MakeVariable extends Command {

    protected static final int NAMEINDEX = 0;
    protected static final int VALUEINDEX = 1;

    @Override
    public String executeCommand () {
        Variable newVar = new Variable();
        newVar.setName(((Variable) myChildren[NAMEINDEX]).getName());
        newVar.setValue(myChildren[VALUEINDEX].getValue());
        System.out.println("Variable Name is " + newVar.getName() + " Variable value is " + newVar.getValue());
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
        if(MainBackEnd.getVariables() == null)
            return null;
        for (Variable var : MainBackEnd.getVariables()) {
            if ((var.getName().equals(newVar.getName())))
                return var;
        }
        return null;
    }
}
