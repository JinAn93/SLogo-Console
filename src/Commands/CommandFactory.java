package Commands;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;
import Main.MainBackEnd;
import Main.Turtle;


public class CommandFactory {
    private ResourceBundle myLanguage;
    private static final int INDEX_COLON = 1;

    public CommandFactory (ResourceBundle lang) {
        myLanguage = lang;
    }

    public Command makeInstruction (String commandName, List<Turtle> turtle,
                                    List<StringBuilder> content, List<Variable> variables) {

        String commandStr = "AllCommands." + searchCommand(commandName, myLanguage.getKeys());
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

            else if (constructors[0].getParameterCount() == 4) {
                try {
                    command = (Command) constructors[0].newInstance(turtle, content, myLanguage,
                                                                    variables);
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

    public Variable makeVariable (String variable) {
        if (variable == null) {
            System.out.println(variable + " is not created");
            return null;
        }

        for (Variable var : MainBackEnd.getVariables()) {
            if (var.getName().equals(variable)) {
                System.out.println(variable + " was created");
                return var;
            }
        }

        Variable newVar = new Variable();
        newVar.setName(variable.substring(INDEX_COLON));
        newVar.setVariable(true);
        return newVar; // Throw Error
    }

    private String searchCommand (String str, Enumeration<String> keys) {
        while (keys.hasMoreElements()) {
            String command = (keys.nextElement());
            if (str.matches(myLanguage.getString(command))) {
                return command;
            }
        }
        return null;
    }
}
