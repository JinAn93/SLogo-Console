package Factory;

import java.util.List;
import java.util.ResourceBundle;
import NodeTypes.Command;
import NodeTypes.Operand;
import NodeTypes.UserCommand;
import NodeTypes.Variable;
import Turtle.SingleTurtle;


/**
 * subclass of abstractFactory. It creates Operand object which extends Node.
 *
 * @author Jin An
 *
 */
public class OperandFactory extends AbstractFactory {
    public OperandFactory (ResourceBundle lang) {
        super(lang);
    }

    @Override
    public Operand makeOperand (String operand) {
        Operand op = new Operand();
        op.setValue(operand);
        op.setOperand(true);
        return op;
    }

    @Override
    public Variable makeVar (String variable) {
        return null;
    }

    @Override
    public UserCommand makeUserCommand (String command) {
        return null;
    }

    @Override
    public Command makeCommand (String Name, List<SingleTurtle> turtle, List<StringBuilder> content) {
        return null;
    }
}
