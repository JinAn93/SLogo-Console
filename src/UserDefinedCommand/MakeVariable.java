package UserDefinedCommand;

import Commands.UserDefinedCommand;
import Commands.Variable;
import Main.MainBackEnd;


public class MakeVariable extends UserDefinedCommand {

    @Override
    public String executeCommand () {
        Variable newVar = new Variable();
        newVar.setName(((Variable) myChildren[NAME]).getName());
        newVar.setValue(myChildren[VALUE].getValue());
        MainBackEnd.getVariables().add(newVar);
        return myChildren[VALUE].getValue();
    }
}
