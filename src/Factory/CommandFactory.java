package Factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.ResourceBundle;
import BackEndMain.StrConstant;
import NodeTypes.Command;
import NodeTypes.Operand;
import NodeTypes.UserCommand;
import NodeTypes.Variable;
import Turtle.SingleTurtle;


/**
 * CommandFactory is subclass of abstractFactory. It returns the command object that matches the
 * name. It returns null if no match.
 *
 * @author Jin An
 *
 */
public class CommandFactory extends AbstractFactory {

    public CommandFactory (ResourceBundle lang) {
        super(lang);
    }

    @Override
    public Command makeCommand (String Name, List<SingleTurtle> turtle, List<StringBuilder> content) {
        String commandStr = StrConstant.ALLCOMMANDS + searchCommand(Name, myLanguage.getKeys());
        Class<?> clas = null;
        Constructor<?>[] constructors = null;
        Command command = null;
        int numParam;
        try {
            clas = Class.forName(commandStr);
            constructors = clas.getDeclaredConstructors();
            numParam = constructors[0].getParameterCount();
            if (numParam == 0) {
                try {
                    command = (Command) clas.newInstance();
                }
                catch (InstantiationException | IllegalAccessException e) {
                    return null;
                }
            }

            else if (numParam == 1) {
                try {
                    command = (Command) constructors[0].newInstance(turtle);
                }
                catch (InstantiationException | IllegalAccessException
                        | IllegalArgumentException | InvocationTargetException e) {
                    return null;
                }

            }

            else if (numParam == 3) {
                try {
                    command = (Command) constructors[0].newInstance(turtle, content, myLanguage);
                }
                catch (InstantiationException | IllegalAccessException
                        | IllegalArgumentException | InvocationTargetException e) {
                    return null;
                }
            }
        }

        catch (ClassNotFoundException | SecurityException e) {
            return null;
        }
        return command;
    }

    @Override
    public Operand makeOperand (String operand) {
        return null;
    }

    @Override
    public Variable makeVar (String variable) {
        return null;
    }

    @Override
    public UserCommand makeUserCommand (String command) {
        return null;
    }
}
