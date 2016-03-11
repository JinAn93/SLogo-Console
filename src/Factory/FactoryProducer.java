package Factory;

import java.util.ResourceBundle;


/**
 * Utilized Abstract Factory Design Pattern. FactoryProducer matches with string to create wanted
 * factory.
 * 
 * @author Jin An
 *
 */
public class FactoryProducer {
    public AbstractFactory getFactory (String choice, ResourceBundle lang) {
        if (choice.equals("Command")) //work on this
            return new CommandFactory(lang);
        if (choice.equals("Operand"))
            return new OperandFactory(lang);
        if (choice.equals("UserCommand"))
            return new UserCommandFactory(lang);
        if (choice.equals("Variable"))
            return new VariableFactory(lang);
        return null;
    }
}
