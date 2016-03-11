package Factory;

import java.util.List;
import java.util.ResourceBundle;
import NodeTypes.Command;
import NodeTypes.Operand;
import NodeTypes.UserCommand;
import NodeTypes.Variable;
import Turtle.SingleTurtle;


public class OperandFactory extends AbstractFactory {
    public OperandFactory (ResourceBundle lang) {
        super(lang);
    }

    @Override
    public Operand makeOperand (String operand) {
        Operand op = new Operand();
        op.setValue(operand);
        op.setOperand(true);
        System.out.println(operand + " was created");
        return op;
    }

    @Override
    public Variable makeVar (String variable, List<Variable> variables) {
        return null;
    }

    @Override
    public UserCommand makeUserCommand (String command, List<UserCommand> commands) {
        return null;
    }

    @Override
    public Command makeCommand (String commandName, List<SingleTurtle> turtle,
                         List<StringBuilder> content, List<Variable> variables,
                         List<UserCommand> userCommands) {
        return null;
    }
}
