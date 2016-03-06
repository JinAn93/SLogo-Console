package AllCommands;

import java.util.List;
import java.util.ResourceBundle;
import Commands.*;
import Main.*;

public class MakeUserInstruction extends Command {

    private String myNewCommandName;
    private String myNewCommand;
    private String myParameters;
    private List<Variable> myVariableList;
    private List<Command> myNewCommandList;
//    protected static final String ONE_INDEXDEFAULT = "1";
//    protected static final String SPACE = " ";
    protected static final int COMMAND_NAME = 0;
    protected static final int PARAMETERS_INDEX = 0;
    protected static final int COMMAND_INDEX = 1;
    protected static final String ZERO = "0";

    
    public MakeUserInstruction (
               List<StringBuilder> ListOfContents,
               List<Variable> variables) {
        System.out.println("To was Created");
        myNewCommandName = myChildren[COMMAND_NAME];
        myNewCommand = ListOfContents.get(COMMAND_INDEX).toString();
        myParameters = ListOfContents.get(PARAMETERS_INDEX).toString();
        myVariableList = variables;
    }

    @Override
    public String executeCommand () {
        UserCommand newCom = new UserCommand(myNewCommand, myParameters);
        
        
    }

}
