package Commands;

import java.io.Console;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.ResourceBundle;
import Main.MainBackEnd;
import Main.Turtle;


public class CommandFactory {
    public Command makeInstruction (String str, Turtle turtle, ResourceBundle language) {
        Enumeration<String> keys = language.getKeys();
        String command = null;
        while (keys.hasMoreElements()) {
            command = (keys.nextElement());
            if (str.matches(language.getString(command))){
                break;
            }
        }
        command = "AllCommands." + command;
        try {
            Class<?> clas = Class.forName(command);
            Constructor<?> constructors = null;
            try {
                constructors = clas.getDeclaredConstructor();
            }
            catch (NoSuchMethodException | SecurityException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Command com = null;
            if(constructors.getParameterCount() == 0){
                try {
                    com = (Command) clas.newInstance();
                }
                catch (InstantiationException | IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            else{
                try {
                    com = (Command) clas.newInstance();
                }
                catch (InstantiationException | IllegalAccessException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                try {
                    Console c = (Console) constructors.newInstance(turtle);
                }
                catch (InstantiationException | IllegalAccessException | IllegalArgumentException
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
