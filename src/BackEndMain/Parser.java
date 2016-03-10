package BackEndMain;

import java.util.*;
import NodeTypes.*;
import Turtle.*;
import Error_Checking.BracketException;
import Error_Checking.ErrorObject;
import Error_Checking.InstructionException;
import Error_Checking.ParameterException;
import Error_Checking.VariableException;


public class Parser {
    private static final ResourceBundle myParameters = ResourceBundle
            .getBundle("resources.ParameterList/AllParameters");
    protected static final ResourceBundle mySyntaxes = ResourceBundle
            .getBundle("languagefiles/Syntax");

    private static final int INDEX_COLON = 1;
    private static final String INSTRUCTION_ERROR = "WRONG COMMAND.";
    private static final String PARAMETER_ERROR = "WRONG PARAMETER.";
    private static final String VARIABLE_ERROR = "WRONG VARIABLE.";
    private static final String BRACKET_ERROR = "WRONG BRACKET.";
    private List<SingleTurtle> myAllTurtles;
    private ResourceBundle myLanguage;
    private List<Variable> myVariableList;
    private List<UserCommand> myUserCommandList;
    private CommandFactory myFactory;

    public Parser (List<SingleTurtle> turtle,
                   ResourceBundle lang,
                   List<Variable> variables,
                   List<UserCommand> commands) {
        myAllTurtles = turtle;
        myLanguage = lang;
        myVariableList = variables;
        myUserCommandList = commands;
    }

    public Stack<Node> buildExpressionTree (Collection<?> ListOfNodes)
                                                                      throws ClassNotFoundException {
        Stack<Node> stack = new Stack<Node>();
        myFactory = new CommandFactory(myLanguage);

        String[] nodes = ListOfNodes.toArray(new String[ListOfNodes.size()]);
        ArrayList<StringBuilder> ListOfContents = new ArrayList<StringBuilder>();
        for (int i = nodes.length - 1; i > -1; i--) {
            System.out.println("We are at " + nodes[i] + " Node");
            Node command = null;

            if (isCommand(nodes[i])) {
                if (isAddNewCommand(nodes, i - 1) || isUserCommand(nodes[i])) {
                    System.out.println("Is there?");
                    command = myFactory.makeCommand(nodes[i], MainBackEnd.getUserCommands());
                }
                else {
                    System.out.println("Here");
                    try {
                        command =
                                myFactory.makeInstr(nodes[i], myAllTurtles, ListOfContents,
                                                    MainBackEnd.getVariables(),
                                                    MainBackEnd.getUserCommands());
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
            }

            else if (isConstant(nodes[i])) {
                command = myFactory.makeOperand(nodes[i]);
            }

            else if (isVariable(nodes[i])) {
                command = ExistVariable(nodes[i].substring(INDEX_COLON));
                if (command == null) {
                    try {
                        if (!isAddNewVariable(nodes, i - 1, myFactory))
                            throw new VariableException();
                        command =
                                myFactory.makeVar(nodes[i].substring(INDEX_COLON), myVariableList);
                    }
                    catch (VariableException e) {
                        new ErrorObject(VARIABLE_ERROR).displayError();
                    }
                }
            }

            else if (isListEnd(nodes[i])) {
                StringBuilder content = new StringBuilder();
                int endListIndex = i;
                try {
                    int startListIndex = searchListStart(nodes, i);
                    if (startListIndex == -1)
                        throw new BracketException();

                    for (int j = startListIndex + 1; j < endListIndex; j++) {
                        content.append(nodes[j]);
                        content.append(" ");
                    }
                    i = startListIndex;
                    ListOfContents.add(content);
                    System.out.println("In the List : " + content); // prints what's in the list
                    continue;
                }
                catch (BracketException e) {
                    new ErrorObject(BRACKET_ERROR).displayError();
                }
            }
            stack.push(command);
        }
        System.out.println("Reached the end of stack");
        return stack;
    }

    private Variable ExistVariable (String variableName) {
        if (MainBackEnd.getVariables().size() == 0)
            return null;
        for (Variable var : MainBackEnd.getVariables()) {
            if (var.getName().equals(variableName))
                return var;
        }
        return null;
    }

    private boolean isAddNewCommand (String[] nodes, int index) {
        if (index < 0)
            return false;
        String nextCommand = myFactory.searchCommand(nodes[index], myLanguage.getKeys());
        if (nextCommand == null)
            return false;
        else if (nextCommand.equals("MakeUserInstruction"))
            return true;
        return false;
    }

    private boolean isAddNewVariable (String[] nodes, int index, CommandFactory cf) {
        System.out.println("Here");
        if (index < 0)
            return false;
        String nextCommand = cf.searchCommand(nodes[index], myLanguage.getKeys());
        if (nextCommand.equals("MakeVariable"))
            return true;
        return false;
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
        return 0;
    }

    private int getParamNum (String command) {
        Enumeration<String> keys = myLanguage.getKeys();
        while (keys.hasMoreElements()) {
            String whichCommand = (keys.nextElement());
            if (command.matches(myLanguage.getString(whichCommand))) {
                return Integer.parseInt(myParameters.getString(whichCommand));
            }
        }
        return -1;
    }

    public List<String> stringizer (Stack<Node> input) {
        List<String> ret = new ArrayList<String>();
        while (!input.isEmpty()) {
            ret.add(input.pop().getValue());
        }
        return ret;
    }

    private boolean isUserCommand (String input) {
        if (myUserCommandList == null)
            return false;
        for (UserCommand ucommand : myUserCommandList) {
            if (ucommand.getUserCommandName().equals(input))
                return true;
        }
        return false;
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
