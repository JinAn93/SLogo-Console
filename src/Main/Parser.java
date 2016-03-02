package Main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;
import Commands.Command;
import Commands.CommandFactory;
import Commands.Node;
import Commands.Variable;


public class Parser {
    private static final int COLON = 1;
    private static final ResourceBundle myParameters = ResourceBundle
            .getBundle("resources.ParameterList/AllParameters");
    protected static final ResourceBundle mySyntaxes = ResourceBundle
            .getBundle("resources.languages/Syntax");

    private Turtle myTurtle;
    private ResourceBundle myLanguage;
    private List<Variable> myVariableList;

    public Parser (Turtle turtle, ResourceBundle lang, List<Variable> variables) {
        myTurtle = turtle;
        myLanguage = lang;
        myVariableList = variables;
    }

    public Stack<Node> buildExpressionTree (Collection<?> ListOfCommands) {
        Stack<Node> stack = new Stack<Node>();
        CommandFactory cf = new CommandFactory(myLanguage);
        String[] commands = ListOfCommands.toArray(new String[ListOfCommands.size()]);
        StringBuilder content = new StringBuilder();
        for (int i = commands.length - 1; i > -1; i--) {
            System.out.println(commands[i]);
            Node command = null;
            if (isCommand(commands[i])) {
                command =
                        cf.makeInstruction(commands[i], myTurtle, content.toString(),myVariableList);

                int paramNum = getParamNum(commands[i]);
                Node[] children = new Node[paramNum];
                for (int c = 0; c < paramNum; c++) {
                    children[c] = stack.pop();
                }
                ((Command) command).setChildren(children);
                
            }
            else if (isConstant(commands[i])) {
                command = cf.makeOperand(commands[i]);
            }

            else if (isVariable(commands[i])) {
                command = cf.makeVariable(commands[i].substring(COLON));
            }

            else if (isListEnd(commands[i])) {
                int endListIndex = i;
                int startListIndex = searchListStart(commands, i);
                for (int j = startListIndex + 1; j < endListIndex; j++) {
                    content.append(commands[j]);
                    content.append(" ");
                }
                i = startListIndex;
                System.out.println(content);
                continue;
            }
            stack.push(command);
        }
        return stack;
    }

    private int searchListStart (String[] commands, int startIndex) {
        int bracketStatus = 0;
        for (int i = startIndex; i > -1; i--) {
            if (isListStart(commands[i])) {
                bracketStatus -= 1;
            }
            if (isListEnd(commands[i])) {
                bracketStatus += 1;
            }
            if (bracketStatus == 0) {
                return i;
            }
        }
        return 0; // no bracket, throw error
    }

    private int getParamNum (String command) {
        Enumeration<String> keys = myLanguage.getKeys();
        while (keys.hasMoreElements()) {
            String whichCommand = (keys.nextElement());
            if (command.matches(myLanguage.getString(whichCommand))) {
                return Integer.parseInt(myParameters.getString(whichCommand));
            }
        }
        return 0;
    }

    public List<String> stringizer (Stack<Node> input) {
        List<String> ret = new ArrayList<String>();
        while (!input.isEmpty()){
            ret.add(input.pop().getValue());
        }
        return ret;
    }
    
    private boolean isCommand (String input) {
        return input.matches(mySyntaxes.getString("Command"));
    }

    private boolean isVariable (String input) {
        return input.matches(mySyntaxes.getString("Variable"));
    }

    private boolean isConstant (String input) {
        return input.matches(mySyntaxes.getString("Constant"));
    }

    private boolean isListStart (String input) {
        return input.matches(mySyntaxes.getString("ListStart"));
    }

    private boolean isListEnd (String input) {
        return input.matches(mySyntaxes.getString("ListEnd"));
    }

    private boolean isGroupStart (String input) {
        return input.matches(mySyntaxes.getString("GroupStart"));
    }

    private boolean isGroupEnd (String input) {
        return input.matches(mySyntaxes.getString("GroupEnd"));
    }
    
    
}
