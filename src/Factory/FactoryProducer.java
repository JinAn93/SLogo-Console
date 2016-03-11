package Factory;

import java.util.ResourceBundle;
import BackEndMain.StrConstant;


/**
 * Utilized Abstract Factory Design Pattern. FactoryProducer matches with string to create wanted
 * factory.
 * 
 * @author Jin An
 *
 */
public class FactoryProducer {
    public AbstractFactory getFactory (String choice, ResourceBundle lang) {
        if (choice.equals(StrConstant.COMMAND))
            return new CommandFactory(lang);
        if (choice.equals(StrConstant.OPERAND))
            return new OperandFactory(lang);
        if (choice.equals(StrConstant.USERCOMMAND))
            return new UserCommandFactory(lang);
        if (choice.equals(StrConstant.VARIABLE))
            return new VariableFactory(lang);
        return null;
    }
}
