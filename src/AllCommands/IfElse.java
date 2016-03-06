package AllCommands;

import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;
import Commands.ControlStructuredCommand;
import Commands.Node;
import Commands.Variable;
import Main.*;


public class IfElse extends ControlStructuredCommand {

    private String myTrueCommand, myFalseCommand;
    private static final int TRUECOMMAND = 0;
    private static final int FALSECOMMAND = 1;

    public IfElse (Turtle turtle,
                   List<StringBuilder> ListOfContents,
                   ResourceBundle lang,
                   List<Variable> variables) {
        System.out.println("If was Created");
        myTurtle = turtle;
        myTrueCommand = ListOfContents.get(TRUECOMMAND).toString();
        myFalseCommand = ListOfContents.get(FALSECOMMAND).toString();
        myLanguage = lang;
        myVariableList = variables;
    }

    @Override
    public String executeCommand () {
        InputNormalizer iNormalizer = new InputNormalizer();
        Parser parser = new Parser(myTurtle, myLanguage, myVariableList);
        boolean ifOrElse = (Integer.parseInt(myChildren[0].getValue()) == 0);
        if ((ifOrElse && myTrueCommand == null) || !(ifOrElse) && myFalseCommand == null)
            return ZERO;
        Stack<Node> result =
                parser.buildExpressionTree(iNormalizer.parseCommand((ifOrElse ? myTrueCommand
                                                                             : myFalseCommand)
                        .toString()));
        List<String> ret = parser.stringizer(result);
        return ret.get(ret.size() - 1);
    }
}
