package Commands;
import Main.MainBackEnd;

public abstract class MathOpCommand implements CommandInterface {
    
    public static final int ARGUMENT_LIST_SIZE = 3;

    private String myCommand;
    protected String[] myArguments = new String[ARGUMENT_LIST_SIZE];
    private CommandInterface child1;
    private CommandInterface child2;
   
 
    @Override
    public CommandInterface makeCommand (String command) {
        // TODO Auto-generated method stub
        myCommand = command;
        return null;
    }
    
    public int parse(String str, String[] listOfCommands){
        CommandFactory cm = new CommandFactory();
        try{
            return Integer.parseInt(str);
        }
        catch(NumberFormatException e){
            if(MainBackEnd.isCommand(str)){
                child1 = (CommandInterface) cm.makeInstruction(listOfCommands);
                return child1.executeCommand();
                
            }
            else{
                return 0;
            }
            
            
        }
        
    }
    

}
