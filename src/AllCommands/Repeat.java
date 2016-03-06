package AllCommands;

import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;
import Commands.ControlStructuredCommand;
import Commands.Node;
import Commands.Variable;
import Main.*;


public class Repeat extends ControlStructuredCommand {

    public Repeat (Turtle turtle,
                   List<StringBuilder> ListOfContents,
                   ResourceBundle lang,
                   List<Variable> variables) {
        System.out.println("Repeat was created");
        myTurtle = turtle;
        myContent = ListOfContents.get(0).toString();
        myLanguage = lang;
        myVariableList = variables;
    }

    @Override
    public String executeCommand () {
        if (myContent == null)
            return ZERO;
        int repNumber = Integer.parseInt(myChildren[FIRSTCHILD].getValue());
        StringBuilder newCommand = new StringBuilder();
        for (int i = 0; i < repNumber; i++) {
            newCommand.append(myContent);
        }
        newCommand.deleteCharAt(newCommand.length() - 1);
        System.out.println("The copied Strings are : \n" + newCommand.toString() + "\n");
        InputNormalizer iNormalizer = new InputNormalizer();
        Parser parser = new Parser(myTurtle, myLanguage, myVariableList);
        Stack<Node> result =
                parser.buildExpressionTree(iNormalizer.parseCommand((newCommand.toString())));
        List<String> ret = parser.stringizer(result);
        System.out.println("Repeat Stack is done! Repeat will return : " + ret.get(ret.size() - 1));
        return ret.get(ret.size() - 1);
    }
}
