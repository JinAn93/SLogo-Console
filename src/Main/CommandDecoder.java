package Main;

import java.util.Arrays;
import java.util.Collection;

/**
 * CommandDecoder serves to parse the input and check whether there exist any error.
 * 
 * @author Jin An
 *
 */
public class CommandDecoder {
    
    private static final String SPACE = " ";
    public Collection<?> parseCommand (String input) {
        if (input == null) {
            // throw nullpointer exception error
            return null;
        }
        else {
            String commentFreeInput = commentOut(input);
            commentFreeInput.toLowerCase();
            System.out.println("Decoding Results : " + commentFreeInput);
            String[] commands = commentFreeInput.split(" ");
            return Arrays.asList(commands);
        }
    }
    
    private String commentOut (String input){
        String[] CommandbyLine = input.split("\n");
        String commentFreeInput = new String();
        for (String line : CommandbyLine) {
            if (!line.matches(Parser.mySyntaxes.getString("Comment"))) {
                commentFreeInput += line;
            }
            commentFreeInput += SPACE;
        }
        return commentFreeInput;
    }
}
