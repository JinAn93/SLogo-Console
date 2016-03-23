package Factory;

import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;
import NodeTypes.Command;
import NodeTypes.Operand;
import NodeTypes.UserCommand;
import NodeTypes.Variable;
import Turtle.SingleTurtle;


/**
 * Utilized Abstract Factory Design Pattern to create different nodes. (Operand, Variable,
 * UserCommand, and Built-in Commands). It also contains searchCommand method which goes through the
 * names of commands and return the appropriate command name (in resourcebundle) that matches the
 * input
 *
 * @author Jin An
 *
 */
public abstract class AbstractFactory {

    protected ResourceBundle myLanguage;

    public AbstractFactory (ResourceBundle lang) {
        myLanguage = lang;
    }

    public abstract Operand makeOperand (String operand);

    public abstract Variable makeVar (String variable);

    public abstract UserCommand makeUserCommand (String command);

    public abstract Command makeCommand (String Name, List<SingleTurtle> turtle,
                                         List<StringBuilder> content);

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
