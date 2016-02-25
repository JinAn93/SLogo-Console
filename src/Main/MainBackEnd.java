package Main;
import java.util.ResourceBundle;
import java.util.Stack;
import CommandExecutors.*;
import Commands.CommandFactory;
import Commands.CommandInterface;
import MathCommands.*;

/**
 * MainBackEnd serves to create Expression Tree and execute commands as it reads the nodes
 * @author Jin An
 * @author Sarp Uner
 *
 */

public class MainBackEnd {

    private static final String[] possibleLanguages = { "English" };
    private static final int DEFAULTLANG = 0;
    private static final int TURTLECOMMAND = 0;
    private static final int TURTLEQUERIES = 1;
    private static final int MATHOP = 2;
    private static final int BOOLOP = 3;
    private static final int USERDEFINED = 4;
    private CommandInterface currentCommand;
    
    ResourceBundle myResources = ResourceBundle.getBundle("resources.languages/" + possibleLanguages[DEFAULTLANG]);

//    public static void main(String args[]){
//        MainBackEnd mb = new MainBackEnd();
//        System.out.println(mb.myResources.getObject("Sum").getClass().getName());
//        
//    }
    public MainBackEnd () {
        
    }

    public String[] setup (String input) {
        CommandDecoder cDecoder = new CommandDecoder();
        String[] commands = cDecoder.parseCommand(input);
        return commands;
    }
    
    public void setLanguage (ResourceBundle bundle){
        myResources = bundle;
    }
    
    private void buildExpressionTree(String[] commands){
        if(commands[0] == myResources.getString("Sum")){
            MainBackEnd mbe = new MainBackEnd();   
        }
            
    }
  
    

    public void executeCommand (String[] commands) {
        CommandFactory cFactory = new CommandFactory();
        while(commands.length > 0){
            if(isCommand(commands[0])){
                currentCommand = cFactory.makeInstruction(commands[0]);
            }
        
        } 
    }

    public static boolean isCommand (String input) {
        return input.matches("[a-zA-Z_]+(\\?)?");
    }

    private boolean isVariable (String input) {
        return input.matches(":[a-zA-Z_]+");
    }

    private boolean isConstant (String input) {
        return input.matches("-?[0-9]+\\.?[0-9]*");
    }

    private boolean isList (String input) {
        return input.matches("[ ]");
    }
}
