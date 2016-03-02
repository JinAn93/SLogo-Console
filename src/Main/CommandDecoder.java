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
    public Collection<?> parseCommand (String input) {
        if (input == null) {
            // throw nullpointer exception error
            return null;
        }
        else {
            String[] CommandbyLine = input.split("\n");
            String commentFreeInput = new String();
            for (String line : CommandbyLine) {
                if (!line.matches(Parser.mySyntaxes.getString("Comment"))) {
                    commentFreeInput += line;
                }
                commentFreeInput += " ";
            }
            commentFreeInput.toLowerCase();
            String[] commands = commentFreeInput.split(" ");
            return Arrays.asList(commands);
        }
    }
}
