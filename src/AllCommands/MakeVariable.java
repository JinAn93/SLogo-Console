package AllCommands;

import Commands.UserDefinedCommand;
import Commands.Variable;
import Main.MainBackEnd;


public class MakeVariable extends UserDefinedCommand {

    @Override
    public String executeCommand () {
        Variable newVar = new Variable();
        newVar.setName(((Variable) myChildren[FIRSTCHILD]).getName());
        newVar.setValue(myChildren[SECONDCHILD].getValue());
        MainBackEnd.getVariables().add(newVar);
        return newVar.getValue();
    }
}
