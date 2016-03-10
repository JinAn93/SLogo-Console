package Factory;

import java.util.List;
import java.util.ResourceBundle;
import NodeTypes.Command;
import NodeTypes.Operand;
import NodeTypes.UserCommand;
import NodeTypes.Variable;
import Turtle.SingleTurtle;


public abstract class AbstractFactory {
    
    protected ResourceBundle myLanguage;
    
    public AbstractFactory (ResourceBundle lang) {
        myLanguage = lang;
    }

    abstract Operand makeOperand (String operand);

    abstract Variable makeVar (String variable, List<Variable> variables);

    abstract UserCommand makeUserCommand (String command, List<UserCommand> commands);

    abstract Command makeCommand (String commandName, List<SingleTurtle> turtle,
                                  List<StringBuilder> content, List<Variable> variables,
                                  List<UserCommand> userCommands);
}
