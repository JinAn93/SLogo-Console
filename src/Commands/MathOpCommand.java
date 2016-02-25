package Commands;
import Main.MainBackEnd;

public abstract class MathOpCommand implements CommandInterface {
    
    public static final int ARGUMENT_LIST_SIZE = 3;

    private String myCommand;
    protected String[] myArguments = new String[ARGUMENT_LIST_SIZE];
    private MathOpCommand child1;
    private MathOpCommand child2;
   
 
    @Override
    public CommandInterface makeCommand (String command) {
        // TODO Auto-generated method stub
        myCommand = command;
        return null;
    }
    
    public int parse(String str, listOfCommands[] str){
        try{
            return Integer.parseInt(str);
        }
        catch(NumberFormatException e){
            if(MainBackEnd.isCommand(str)){
                child1 = new Command(str);
                return child1.executeCommand();
                
            }
            
            
        }
        
    }
    

}
