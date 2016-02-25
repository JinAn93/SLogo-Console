package Commands;
import java.lang.Class;

public class CommandFactory {
    public CommandInterface makeInstruction (String commandType){
        if(commandType == null){
            return null;
        }
        
        try {
            return (CommandInterface) Class.forName(commandType).newInstance();
        }
        catch (InstantiationException e) {
            // TODO BAD CODE!!
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            // TODO BAD CODE!!
            e.printStackTrace();
        }       
        catch (ClassNotFoundException e) {
            // TODO BAD CODE!!
            e.printStackTrace();
        }
        return null;
        
        
        /*
        if(commandType.equalsIgnoreCase("TURTLE")){ //use resourcebundle
            return new TurtleCommand();
        }
        if(commandType.equalsIgnoreCase("TURTLECQUERIES")){
            return new TurtleQueriesCommand();
        }
        if(commandType.equalsIgnoreCase("MATHOP")){
            return new MathOpCommand();
        }
        if(commandType.equalsIgnoreCase("BOOLOP")){
            return new BoolOpCommand();
        }
        if(commandType.equalsIgnoreCase("USERDEFINED")){
            return new UserDefinedCommand();
        }
        return null;
    }
    */
    }
}

        