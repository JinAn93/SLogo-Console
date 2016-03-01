package Commands;

import java.util.ResourceBundle;
import Main.MainBackEnd;
import Main.Turtle;
import MathCommands.*;
import TurtleCommand.*;
import TurtleQuery.*;
import UserDefinedCommand.MakeVariable;


public class CommandFactory {
    public Command makeInstruction (String command, Turtle turtle, ResourceBundle language) {

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

        if (command.matches(language.getString("Quotient"))) {
            return new Quotient();
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

        if (command.matches(language.getString("Right"))) {
            return new Right(turtle);
        }

        if (command.matches(language.getString("PenUp"))) {
            return new Penup(turtle);
        }

        if (command.matches(language.getString("PenDown"))) {
            return new Pendown(turtle);
        }

        if (command.matches(language.getString("MakeVariable"))) {
            return new MakeVariable();
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
        
        Variable newVar = new Variable ();
        newVar.setName(variable);
        newVar.setVariable(true);
        return newVar; //Throw Error
    }
}
