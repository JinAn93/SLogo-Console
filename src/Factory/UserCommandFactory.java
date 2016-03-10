package Factory;

import java.util.List;
import java.util.ResourceBundle;
import NodeTypes.Command;
import NodeTypes.Operand;
import NodeTypes.UserCommand;
import NodeTypes.Variable;
import Turtle.SingleTurtle;

public class UserCommandFactory extends AbstractFactory{

    public UserCommandFactory (ResourceBundle lang) {
        super(lang);
    }

    @Override
    UserCommand makeUserCommand (String command, List<UserCommand> commands) {
        if (command == null) {
            return null;
        }

        if (!commands.isEmpty()) {
            for (UserCommand ucommand : commands) {
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
    Command makeCommand (String commandName,
                         List<SingleTurtle> turtle,
                         List<StringBuilder> content,
                         List<Variable> variables,
                         List<UserCommand> userCommands) {
        return null;
    }

    @Override
    Operand makeOperand (String operand) {
        return null;
    }

    @Override
    Variable makeVar (String variable, List<Variable> variables) {
        return null;
    }
}
