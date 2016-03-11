package Factory;

import java.util.ResourceBundle;

public class FactoryProducer {
    public AbstractFactory getFactory(String choice, ResourceBundle lang){
        if(choice.equals("Command"))
            return new CommandFactory(lang);
        if(choice.equals("Operand"))
            return new OperandFactory(lang);
        if (choice.equals("UserCommand"))
            return new UserCommandFactory(lang);
        if (choice.equals("Variable"))
            return new VariableFactory(lang);
        return null;
    }
}
