package BackEndMain;

import java.util.*;
import NodeTypes.*;
import Turtle.*;
import Error_Checking.BracketException;
import Error_Checking.ErrorObject;
import Error_Checking.InstructionException;
import Error_Checking.ParameterException;
import Error_Checking.VariableException;
import Factory.*;


/**
 * Parser class serves to receive the collection of nodes, build expression tree, and return the
 * stack of node to be executed. It uses recursive tree to execute command when the parameter is not
 * operand (E.g. sum sum 10 20 30 -> sum 30 30 -> 60)
 * 
 * @author Jin An
 * @author Sarp Uner
 *
 */
public class Parser {
    private List<SingleTurtle> myAllTurtles;
    private ResourceBundle myLanguage;
    private FactoryProducer myFactoryProducer = new FactoryProducer();
    private AbstractFactory myFactory;
    private static final int INDEX_COLON = 1;

    private static final ResourceBundle myParameters = ResourceBundle
            .getBundle(StrConstant.ALLPARAMETERS);
    protected static final ResourceBundle mySyntaxes = ResourceBundle
            .getBundle(StrConstant.LANGUAGES);

    public Parser (List<SingleTurtle> turtle, ResourceBundle lang) {
        myAllTurtles = turtle;
        myLanguage = lang;
    }

    public Stack<Node> buildExpressionTree (Collection<?> ListOfNodes)
                                                                      throws ClassNotFoundException {
        Stack<Node> stack = new Stack<Node>();
        String[] nodes = ListOfNodes.toArray(new String[ListOfNodes.size()]);
        ArrayList<StringBuilder> ListOfContents = new ArrayList<StringBuilder>();
        for (int i = nodes.length - 1; i > -1; i--) {
            Node command = null;
            if (isCommand(nodes[i])) {
                if (isAddNewCommand(nodes, i - 1) || isUserCommand(nodes[i])) {
                    myFactory = myFactoryProducer.getFactory(StrConstant.USERCOMMAND, myLanguage);
                    command = myFactory.makeUserCommand(nodes[i]);
                }
                else {
                    try {
                        myFactory = myFactoryProducer.getFactory(StrConstant.COMMAND, myLanguage);
                        command =
                                myFactory.makeCommand(nodes[i], myAllTurtles, ListOfContents);
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
                            }
                            ((Command) command).setChildren(children);
                        }
                        catch (ParameterException e) {
                            new ErrorObject(StrConstant.PARAMETER_ERROR).displayError();
                            return null;
                        }
                    }
                    catch (InstructionException e) {
                        new ErrorObject(StrConstant.INSTRUCTION_ERROR).displayError();
                        return null;
                    }
                }
            }

            else if (isConstant(nodes[i])) {
                myFactory = myFactoryProducer.getFactory(StrConstant.OPERAND, myLanguage);
                command = myFactory.makeOperand(nodes[i]);
            }

            else if (isVariable(nodes[i])) {
                command = ExistVariable(nodes[i].substring(INDEX_COLON));
                if (command == null) {
                    try {
                        if (!isAddNewVariable(nodes, i - 1))
                            throw new VariableException();
                        myFactory = myFactoryProducer.getFactory(StrConstant.VARIABLE, myLanguage);
                        command =
                                myFactory.makeVar(nodes[i].substring(INDEX_COLON));
                    }
                    catch (VariableException e) {
                        new ErrorObject(StrConstant.VARIABLE_ERROR).displayError();
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
                        content.append(StrConstant.SPACE);
                    }
                    i = startListIndex;
                    ListOfContents.add(content);
                    continue;
                }
                catch (BracketException e) {
                    new ErrorObject(StrConstant.BRACKET_ERROR).displayError();
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
        else if (nextCommand.equals(StrConstant.MAKEUSERCOMMAND))
            return true;
        return false;
    }

    private boolean isAddNewVariable (String[] nodes, int index) {
        System.out.println("Here");
        if (index < 0)
            return false;
        String nextCommand = myFactory.searchCommand(nodes[index], myLanguage.getKeys());
        if (nextCommand.equals(StrConstant.MAKEVARIABLE))
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
        if (MainBackEnd.getUserCommands() == null)
            return false;
        for (UserCommand ucommand : MainBackEnd.getUserCommands()) {
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
