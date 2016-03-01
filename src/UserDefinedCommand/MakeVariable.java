package UserDefinedCommand;

import Commands.Node;
import Commands.UserDefinedCommand;
import Commands.Variable;
import Main.MainBackEnd;


public class MakeVariable extends UserDefinedCommand {

    private Node[] myChildren;
    private static final int NAME = 0;
    private static final int VALUE = 1;
    
    public String executeCommand () {
        Variable newVar = new Variable();
        newVar.setName(((Variable)myChildren[NAME]).getName());
        newVar.setValue(myChildren[VALUE].getValue());
        MainBackEnd.getVariables().add(newVar);
        return myChildren[VALUE].getValue();
    }

    public Node[] getChildren () {
        return myChildren;
    }

    public void setChildren (Node[] kids) {
        myChildren = kids;
    }

}
