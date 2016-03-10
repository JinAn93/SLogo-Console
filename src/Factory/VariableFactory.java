package Factory;

import java.util.List;
import java.util.ResourceBundle;
import NodeTypes.Command;
import NodeTypes.Operand;
import NodeTypes.UserCommand;
import NodeTypes.Variable;
import Turtle.SingleTurtle;


public class VariableFactory extends AbstractFactory {

    public VariableFactory (ResourceBundle lang) {
        super(lang);
    }

    @Override
    public Variable makeVar (String variable, List<Variable> variables) {
        System.out.println(variable + " was created");
        Variable newVar = new Variable();
        newVar.setName(variable);
        newVar.setVariable(true);
        return newVar;
    }

    @Override
    Operand makeOperand (String operand) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    UserCommand makeUserCommand (String command, List<UserCommand> commands) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    Command makeCommand (String commandName, List<SingleTurtle> turtle,
                         List<StringBuilder> content, List<Variable> variables,
                         List<UserCommand> userCommands) {
        // TODO Auto-generated method stub
        return null;
    }

}
