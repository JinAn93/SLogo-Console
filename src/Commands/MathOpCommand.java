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
    
    public int parse(String[] listOfCommands){
        CommandFactory cm = new CommandFactory();
        String input = listOfCommands[0];
        try{
            return Integer.parseInt(input);
        }
        catch(NumberFormatException e){
            if(MainBackEnd.isCommand(input)){
                child1 = (CommandInterface) cm.makeInstruction(listOfCommands);
                return child1.executeCommand(listOfCommands);
                
            }
            else{
                return 0;
            }
            
            
        }
        
    }
    

}
