package Commands;

public class CommandFactory {
    public Command makeInstruction (String commandType){
        if(commandType == null){
            return null;
        }
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
}
