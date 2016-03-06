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
import Error_Checking.ErrorObject;
import Error_Checking.InstructionException;
import Error_Checking.ParameterException;


public class Parser {
    private static final int COLON = 1;
    private static final ResourceBundle myParameters = ResourceBundle
            .getBundle("resources.ParameterList/AllParameters");
    protected static final ResourceBundle mySyntaxes = ResourceBundle
            .getBundle("resources.languages/Syntax");

    private static final String INSTRUCTION_ERROR = "WRONG COMMAND.";
    private static final String PARAMETER_ERROR = "WRONG PARAMETER.";
    private Turtle myTurtle;
    private ResourceBundle myLanguage;
    private List<Variable> myVariableList;

    public Parser (Turtle turtle, ResourceBundle lang, List<Variable> variables) {
        myTurtle = turtle;
        myLanguage = lang;
        myVariableList = variables;
    }

    public Stack<Node> buildExpressionTree (Collection<?> ListOfNodes)
                                                                      throws ClassNotFoundException {
        Stack<Node> stack = new Stack<Node>();
        CommandFactory cf = new CommandFactory(myLanguage);
        String[] nodes = ListOfNodes.toArray(new String[ListOfNodes.size()]);
        ArrayList<StringBuilder> ListOfContents = new ArrayList<StringBuilder>();
        for (int i = nodes.length - 1; i > -1; i--) {
            System.out.println("We are at " + nodes[i] + " Node");
            Node command = null;
            if (isCommand(nodes[i])) {
                try {
                    command =
                            cf.makeInstruction(nodes[i], myTurtle, ListOfContents, myVariableList);
                    if (command == null) {
                        throw new InstructionException();
                    }
                    int paramNum = getParamNum(nodes[i]);
                    Node[] children = new Node[paramNum];
                    try {
                        if (paramNum > stack.size()) {
                            throw new ParameterException();
                        }
                        for (int c = 0; c < paramNum; c++) {
                            children[c] = stack.pop();
                            System.out.println((c + 1) + " child is " + children[c].getValue());
                        }
                        ((Command) command).setChildren(children);
                    }
                    catch (ParameterException e) {
                        new ErrorObject(PARAMETER_ERROR).displayError();
                        return null;
                    }
                }
                catch (InstructionException e) {
                    new ErrorObject(INSTRUCTION_ERROR).displayError();
                    return null;
                }
            }
            else if (isConstant(nodes[i])) {
                command = cf.makeOperand(nodes[i]);
            }

            else if (isVariable(nodes[i])) {
                command = cf.makeVariable(nodes[i].substring(COLON));
            }

            else if (isListEnd(nodes[i])) {
                StringBuilder content = new StringBuilder();
                int endListIndex = i;
                int startListIndex = searchListStart(nodes, i);
                for (int j = startListIndex + 1; j < endListIndex; j++) {
                    content.append(nodes[j]);
                    content.append(" ");
                }
                i = startListIndex;
                ListOfContents.add(content);
                System.out.println("In the List : " + content); // prints what's in the list
                continue;
            }
            stack.push(command);
        }
        System.out.println("Reached the end of stack");
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
        while (!input.isEmpty()) {
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
