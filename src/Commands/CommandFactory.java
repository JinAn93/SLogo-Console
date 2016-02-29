package Commands;

import java.util.ResourceBundle;
import Main.Turtle;
import MathCommands.*;
import TurtleCommand.*;
import TurtleQuery.*;


public class CommandFactory {
    public Command makeInstruction (String command, Turtle turtle, ResourceBundle language) {
        Command ret;

        if (command.matches(language.getString("Sum"))) {
            return new Sum();
        }

        if (command.matches(language.getString("Product"))) {
            return new Product();
        }

        if (command.matches(language.getString("Difference"))) {
            return new Difference();
        }

        if (command.matches(language.getString("Remainder"))) {
            return new Remainder();
        }

        if (command.matches(language.getString("Minus"))) {
            return new Minus();
        }

        if (command.matches(language.getString("XCoordinate"))) {
            return new XCoordinate(turtle);
        }

        if (command.matches(language.getString("YCoordinate"))) {
            return new YCoordinate(turtle);
        }

        if (command.matches(language.getString("Heading"))) {
            return new Heading(turtle);
        }
        
        if (command.matches(language.getString("IsPenDown"))) {
            return new IsPenDown(turtle);
        }
        
        if (command.matches(language.getString("IsShowing"))) {
            return new IsShowing(turtle);
        }
        
        if (command.matches(language.getString("Forward"))) {
            return new Forward(turtle);
        }
        
        if(command.matches(language.getString("Right"))){
            return new Right(turtle);
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
