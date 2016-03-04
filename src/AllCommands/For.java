package AllCommands;

import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;
import Commands.ControlStructuredCommand;
import Commands.Node;
import Commands.Variable;
import Main.CommandDecoder;
import Main.Parser;
import Main.Turtle;


public class For extends ControlStructuredCommand {

    private static final int INDEX_VARIABLE = 0;
    private static final int INDEX_START = 1;
    private static final int INDEX_END = 2;
    private static final int INDEX_INCREMENT = 3;


    public For (Turtle turtle,
                List<StringBuilder> ListOfContents,
                ResourceBundle lang,
                List<Variable> variables) {
        System.out.println("For was Created");
        myTurtle = turtle;
        myContent = ListOfContents.get(COMMAND_INDEX).toString();
        myControlContent = ListOfContents.get(CONTROL_INDEX).toString();
        myLanguage = lang;
        myVariableList = variables;
    }

    @Override
    public String executeCommand () {
        if (myContent == null)
            return ZERO;
        return executeLoop(createIndexVariable());
    }

    private int createIndexVariable () {
        Variable indexVar = new Variable();
        String[] controlData = myControlContent.split(SPACE);
        int startPoint = Integer.parseInt(controlData[INDEX_START]);
        int endPoint = Integer.parseInt(controlData[INDEX_END]);
        int increment = Integer.parseInt(controlData[INDEX_INCREMENT]);
        int numRepeat = countRepeat(startPoint, endPoint, increment);
        System.out.println("Start point is : " + startPoint + " EndPoint is " + endPoint);
        indexVar.setName(controlData[INDEX_VARIABLE]);
        indexVar.setValue(controlData[INDEX_START]);
        indexVar.setValue(Integer.toString(startPoint + increment * (numRepeat-1)));
        
        myVariableList.add(indexVar);
        System.out.println(controlData);
        return numRepeat;
    }

    private int countRepeat (int startPoint, int endPoint, int increment){
        if ((endPoint-startPoint+1) % increment == 0)
            return ((endPoint-startPoint+1) / increment);
        else
            return ((endPoint-startPoint+1) / increment)+1;
    }
    
    private String executeLoop (int limit) {
        StringBuilder newCommand = new StringBuilder();
        for (int i = 0; i < limit; i++) {
            newCommand.append(myContent);
        }
        newCommand.deleteCharAt(newCommand.length() - 1);
        CommandDecoder cdecoder = new CommandDecoder();
        Parser parser = new Parser(myTurtle, myLanguage, myVariableList);
        Stack<Node> result =
                parser.buildExpressionTree(cdecoder.parseCommand((newCommand.toString())));
        List<String> ret = parser.stringizer(result);

        return ret.get(ret.size() - 1);
    }
}
