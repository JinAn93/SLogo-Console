package Factory;

import java.util.List;
import java.util.ResourceBundle;
import BackEndMain.MainBackEnd;
import NodeTypes.Command;
import NodeTypes.Operand;
import NodeTypes.UserCommand;
import NodeTypes.Variable;
import Turtle.SingleTurtle;


/**
 * subclass of abstractfactory: It checks whether the command is already defined. If not, it creates
 * new user-defined command
 * 
 * @author Jin An
 *
 */
public class UserCommandFactory extends AbstractFactory {

    public UserCommandFactory (ResourceBundle lang) {
        super(lang);
    }

    @Override
    public UserCommand makeUserCommand (String command) {
        if (!MainBackEnd.getUserCommands().isEmpty()) {
            for (UserCommand ucommand : MainBackEnd.getUserCommands()) {
                if (ucommand.getUserCommandName().equals(command)) {
                    return ucommand;
                }
            }
        }
        System.out.println(command + " was created");
        UserCommand ucom = new UserCommand();
        ucom.setUserCommandName(command);
        ucom.setUserCommand(true);
        return ucom;
    }

    @Override
    public Command makeCommand (String Name, List<SingleTurtle> turtle, List<StringBuilder> content) {
        return null;
    }

    @Override
    public Operand makeOperand (String operand) {
        return null;
    }

    @Override
    public Variable makeVar (String variable) {
        return null;
    }
}
