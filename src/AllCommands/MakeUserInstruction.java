package AllCommands;

import java.util.List;
import java.util.ResourceBundle;
import Commands.*;
import Main.*;

public class MakeUserInstruction extends Command {


    protected String myNewCommand;
    protected String myParameters;
    protected ResourceBundle myLanguage;
    protected List<Variable> myVariableList;
    protected List<Command> myNewCommandList;
//    protected static final int FIRSTCHILD = 0;
//    protected static final int SECONDCHILD = 1;
//    protected static final String ONE_INDEXDEFAULT = "1";
//    protected static final String SPACE = " ";
    protected static final int PARAMETERS_INDEX = 0;
    protected static final int COMMAND_INDEX = 1;
    protected static final String ZERO = "0";

    
    public MakeUserInstruction (
               List<StringBuilder> ListOfContents,
               ResourceBundle lang,
               List<Variable> variables) {
        System.out.println("To was Created");
        myNewCommand = ListOfContents.get(COMMAND_INDEX).toString();
        myParameters = ListOfContents.get(PARAMETERS_INDEX).toString();
        myLanguage = lang;
        myVariableList = variables;
    }

    @Override
    public String executeCommand () {
        UserCommand newCom = new UserCommand();
        
    }

}
