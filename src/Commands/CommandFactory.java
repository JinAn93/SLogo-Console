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
    
    public CommandFactory (ResourceBundle lang){
        myLanguage = lang;
    }
    
    public Command makeInstruction (String str,
                                    Turtle turtle,
                                    String content,
                                    List<Variable> variables) {
        Enumeration<String> keys = myLanguage.getKeys();
        String command = null;
        while (keys.hasMoreElements()) {
            command = (keys.nextElement());
            if (str.matches(myLanguage.getString(command))) {
                break;
            }
        }
        command = "AllCommands." + command;
        try {
            Class<?> clas = Class.forName(command);
            Constructor<?>[] constructors = null;
            try {
                constructors = clas.getDeclaredConstructors();
            }
            catch (SecurityException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Command com = null;
            if (constructors[0].getParameterCount() == 0) {
                try {
                    com = (Command) clas.newInstance();
                }
                catch (InstantiationException | IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            else if (constructors[0].getParameterCount() == 1) {
                Class<?>[] parameterTypes = constructors[0].getParameterTypes();
                if (parameterTypes[0].getSimpleName().equals("Turtle")) {
                    try {
                        com = (Command) constructors[0].newInstance(turtle);
                    }
                    catch (InstantiationException | IllegalAccessException
                            | IllegalArgumentException
                            | InvocationTargetException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
            else if (constructors[0].getParameterCount() == 4){
                try {
                    com = (Command) constructors[0].newInstance(turtle, content, myLanguage, variables);
                }
                catch (InstantiationException | IllegalAccessException
                        | IllegalArgumentException
                        | InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            return com;
        }

        catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
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
        newVar.setName(variable);
        newVar.setVariable(true);
        return newVar; // Throw Error
    }
}
