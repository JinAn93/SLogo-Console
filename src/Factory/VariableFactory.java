package Factory;

import java.util.List;
import java.util.ResourceBundle;
import NodeTypes.Command;
import NodeTypes.Operand;
import NodeTypes.UserCommand;
import NodeTypes.Variable;
import Turtle.SingleTurtle;


/**
 * Subclass of abstractfactory. It creates variable node.
 *
 * @author Jin An
 *
 */
public class VariableFactory extends AbstractFactory {

    public VariableFactory (ResourceBundle lang) {
        super(lang);
    }

    @Override
    public Variable makeVar (String variable) {
        Variable newVar = new Variable();
        newVar.setName(variable);
        newVar.setVariable(true);
        return newVar;
    }

    @Override
    public Operand makeOperand (String operand) {
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
