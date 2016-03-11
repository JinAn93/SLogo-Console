package Factory;

import java.util.Enumeration;
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

    
    public abstract Operand makeOperand (String operand);

    public abstract Variable makeVar (String variable, List<Variable> variables);

    public abstract UserCommand makeUserCommand (String command, List<UserCommand> commands);

    public abstract Command makeCommand (String commandName, List<SingleTurtle> turtle,
                                  List<StringBuilder> content, List<Variable> variables,
                                  List<UserCommand> userCommands);
    
    public String searchCommand (String str, Enumeration<String> keys) {
        while (keys.hasMoreElements()) {
            String command = (keys.nextElement());
            if (str.matches(myLanguage.getString(command))) {
                return command;
            }
        }
        return null;
    }
}