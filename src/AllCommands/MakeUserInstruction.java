package AllCommands;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import Commands.*;
import Error_Checking.ErrorObject;
import Error_Checking.VariableException;
import Main.*;


public class MakeUserInstruction extends Command {

    private String myNewCommandName;
    private String myNewCommand;
    private List<String> myParameters;
    private List<Variable> myVariableList;
    private static final String DEFINE_SUCCESS = "1";
    private static final String DEFINE_FAIL = "0";
    private static final String SPACE = " ";
    private static final int COMMAND_NAME = 0;
    private static final int PARAMETERS_INDEX = 0;
    private static final int COMMAND_INDEX = 1;
    private static final int COLON_INDEX = 1;

    public MakeUserInstruction (List<StringBuilder> ListOfContents, List<Variable> variables) {
        System.out.println("To was Created");
        myNewCommandName = myChildren[COMMAND_NAME].getValue();
        myNewCommand = ListOfContents.get(COMMAND_INDEX).toString();
        myParameters = Arrays.asList(ListOfContents.get(PARAMETERS_INDEX).toString().split(SPACE));
        myVariableList = variables;
    }

    @Override
    public String executeCommand () {
        try {
            if (parameterCheck(myParameters)) {
                throw new VariableException();
            }
            UserCommand newCom = new UserCommand(myNewCommandName, myNewCommand, myParameters);
            UserCommand existCheck = isAlreadyExist(newCom);
            if (existCheck != null) {
                existCheck.setCommand(myNewCommand, myParameters);
            }
            else {
                MainBackEnd.getUserCommands().add(newCom);
            }
            return DEFINE_SUCCESS;
        }
        catch (VariableException e) {
            new ErrorObject(VARIABLE_ERROR).displayError();
            return DEFINE_FAIL;
        }
    }

    private UserCommand isAlreadyExist (UserCommand newCom) {
        for (UserCommand command : MainBackEnd.getUserCommands()) {
            if ((command.getUserCommandName().equals(newCom.getUserCommandName())))
                return command;
        }
        return null;
    }

    private boolean parameterCheck (List<String> parameters) {
        int countValidParameter = 0;
        for (int i = 0; i < parameters.size(); i++) {
            for (Variable var : MainBackEnd.getVariables()) {
                if (var.getName().equals(parameters.get(i).substring(COLON_INDEX))){
                    countValidParameter++;                    
                }
            }
        }
        if(countValidParameter == parameters.size())
            return true;
        else
            return false;
    }
}
