package Factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;
import NodeTypes.*;
import Turtle.*;


public class CommandFactory extends AbstractFactory {
    
    public CommandFactory (ResourceBundle lang) {
        super(lang);
    }

    public Command makeCommand (String commandName, List<SingleTurtle> turtle,
                                List<StringBuilder> content, List<Variable> variables,
                                List<UserCommand> commands) {
        String commandStr = "AllCommands." + searchCommand(commandName, myLanguage.getKeys()); // String
        System.out.println("I will be creating: " + commandStr);
        Class<?> clas = null;
        Constructor<?>[] constructors = null;
        Command command = null;
        try {
            clas = Class.forName(commandStr);
            constructors = clas.getDeclaredConstructors();
            if (constructors[0].getParameterCount() == 0) {
                try {
                    command = (Command) clas.newInstance();
                }
                catch (InstantiationException | IllegalAccessException e) {
                    return null;
                }
            }

            else if (constructors[0].getParameterCount() == 1) {
                try {
                    command = (Command) constructors[0].newInstance(turtle);
                }
                catch (InstantiationException | IllegalAccessException
                        | IllegalArgumentException | InvocationTargetException e) {
                    return null;
                }

            }

            else if (constructors[0].getParameterCount() == 5) {
                try {
                    command = (Command) constructors[0].newInstance(turtle, content, myLanguage,
                                                                    variables, commands);
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
    public Variable makeVar (String variable, List<Variable> variables) {
        return null;
    }

    @Override
    public UserCommand makeUserCommand (String command, List<UserCommand> commands) {
        return null;
    }
}
