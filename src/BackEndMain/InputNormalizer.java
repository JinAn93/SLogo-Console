package BackEndMain;

import java.util.Arrays;
import java.util.Collection;


/**
 * InputNormalizer serves to normalize input. Returns null if there is no input. It will consider
 * taking out comments (line starts with #), changing into lower case, and replacing consecutive
 * spaces into single space.
 * 
 * @author Jin An
 *
 */
public class InputNormalizer {

    private static final String SPACE = " ";

    public Collection<?> normalizeInput (String input) {
        if (input == null) {
            return null;
        }
        else {
            String NormalizedInput = commentOut(input).toLowerCase().trim().replaceAll(" +", " ");
            return Arrays.asList(NormalizedInput.split(" "));
        }
    }

    private String commentOut (String input) {
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
