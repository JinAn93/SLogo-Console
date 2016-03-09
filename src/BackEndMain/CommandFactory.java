package BackEndMain;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;
import NodeTypes.*;
import Turtle.*;


public class CommandFactory {
    private ResourceBundle myLanguage;
    private static final int INDEX_COLON = 1;

    public CommandFactory (ResourceBundle lang) {
        myLanguage = lang;
    }

    public Command makeInstr (String commandName,
                              List<SingleTurtle> turtle,
                              List<StringBuilder> content,
                              List<Variable> variables,
                              List<UserCommand> commands) {
        System.out.println("Hmm..");
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

    public Operand makeOperand (String operand) {
        if (operand == null) {
            System.out.println(operand + " was not created");
            return null;
        }

        Operand op = new Operand();
        op.setValue(operand);
        op.setOperand(true);
        System.out.println(operand + " was created");
        return op;
    }

    public Variable makeVariable (String variable, List<Variable> variables) {
        if (variable == null) {
            System.out.println(variable + " is not created");
            return null;
        }

        if (variables != null) {
            for (Variable var : variables) {
                if (var.getName().equals(variable.substring(INDEX_COLON))) {
                    return var;
                }
            }
        }
        System.out.println(variable + " was created");
        Variable newVar = new Variable();
        newVar.setName(variable.substring(INDEX_COLON));
        newVar.setVariable(true);
        return newVar;
    }

    public UserCommand makeCommand (String command, List<UserCommand> commands) {
        if (command == null) {
            return null;
        }

        if (commands != null) {
            for (UserCommand ucommand : commands) {
                if (ucommand.getUserCommandName().equals(command)) {
                    return ucommand;
                }
            }
        }
        System.out.println(command + "was created");
        UserCommand ucom = new UserCommand();
        ucom.setUserCommandName(command);
        ucom.setUserCommand(true);
        return ucom;
    }

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
