package Commands;

import Main.MainBackEnd;
import MathCommands.*;
import TurtleQuery.*;


public class CommandFactory {
    public Command makeInstruction (String command) {
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
            return new XCoordinate();
        }

        if (command.matches(MainBackEnd.getLanguage().getString("YCoordinate"))) {
            return new YCoordinate();
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
