package Commands;

import Main.MainBackEnd;
import Main.Turtle;
import MathCommands.*;
import TurtleCommand.*;
import TurtleQuery.*;


public class CommandFactory {
    public Command makeInstruction (String command, Turtle turtle) {
        Command ret;

        if (command.matches(MainBackEnd.getLanguage().getString("Sum"))) {
            return new Sum();
        }

        if (command.matches(MainBackEnd.getLanguage().getString("Product"))) {
            return new Product();
        }

        if (command.matches(MainBackEnd.getLanguage().getString("Difference"))) {
            return new Difference();
        }

        if (command.matches(MainBackEnd.getLanguage().getString("Remainder"))) {
            return new Remainder();
        }

        if (command.matches(MainBackEnd.getLanguage().getString("Minus"))) {
            return new Remainder();
        }

        if (command.matches(MainBackEnd.getLanguage().getString("XCoordinate"))) {
            return new XCoordinate(turtle);
        }

        if (command.matches(MainBackEnd.getLanguage().getString("YCoordinate"))) {
            return new YCoordinate(turtle);
        }

        if (command.matches(MainBackEnd.getLanguage().getString("Heading"))) {
            return new Heading(turtle);
        }
        
        if (command.matches(MainBackEnd.getLanguage().getString("IsPenDown"))) {
            return new IsPenDown(turtle);
        }
        
        if (command.matches(MainBackEnd.getLanguage().getString("IsShowing"))) {
            return new IsShowing(turtle);
        }
        
        if (command.matches(MainBackEnd.getLanguage().getString("Forward"))) {
            return new Forward(turtle);
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

}
