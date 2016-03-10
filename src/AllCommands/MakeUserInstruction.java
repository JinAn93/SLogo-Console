package AllCommands;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import Error_Checking.ErrorObject;
import NodeTypes.*;
import Turtle.SingleTurtle;
import Error_Checking.VariableException;
import BackEndMain.*;


public class MakeUserInstruction extends Command {

    private String myNewCommand;
    private List<String> myParameters;
    private List<Variable> myVariableList;
    private List<SingleTurtle> myTurtle;
    private List<UserCommand> myUserCommandList;
    private ResourceBundle myLanguage;
    private static final String DEFINE_SUCCESS = "1";
    private static final String DEFINE_FAIL = "0";
    private static final String SPACE = " ";
    private static final int COMMAND_NAME = 0;
    private static final int PARAMETERS_INDEX = 1;
    private static final int COMMAND_INDEX = 0;
    private static final int COLON_INDEX = 1;

    public MakeUserInstruction (List<SingleTurtle> turtles,
                                List<StringBuilder> ListOfContents,
                                ResourceBundle lang,
                                List<Variable> variables,
                                List<UserCommand> commands) {
        myTurtle = turtles;
        myNewCommand = ListOfContents.get(COMMAND_INDEX).toString();
        myLanguage = lang;
        myParameters = Arrays.asList(ListOfContents.get(PARAMETERS_INDEX).toString().split(SPACE));
        myVariableList = variables;
        myUserCommandList = commands;
        System.out.println("To is created");
    }

    @Override
    public String executeCommand () {
        System.out.println("Executing MakeUserINstruction!");

        String commandName = ((UserCommand) myChildren[COMMAND_NAME]).getUserCommandName();
        UserCommand newCom =
                new UserCommand(myTurtle, commandName, myNewCommand, myLanguage, myParameters,
                                myUserCommandList);
        UserCommand existCheck = isAlreadyExist(newCom);
        if (existCheck != null) {
            existCheck.setCommand(myNewCommand, myParameters);
        }
        else {
            MainBackEnd.getUserCommands().add(newCom);
        }
        return DEFINE_SUCCESS;

    }

    private UserCommand isAlreadyExist (UserCommand newCom) {
        if (myUserCommandList.isEmpty())
            return null;
        for (UserCommand command : myUserCommandList) {
            if ((command.getUserCommandName().equals(newCom.getUserCommandName()))) {
                System.out.println("Found it!");
                return command;
            }
        }
        return null;
    }
}
