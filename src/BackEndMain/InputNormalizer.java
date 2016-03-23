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
    private static final String NEW_LINE = "\n";
    private static final String MULTIPLE_SPACE = " +";
    private static final String COMMENT = "Comment";

    public Collection<?> normalizeInput (String input) {
        if (input == null) {
            return null;
        }
        else {
            String NormalizedInput =
                    commentOut(input).toLowerCase().trim().replaceAll(MULTIPLE_SPACE, SPACE);
            return Arrays.asList(NormalizedInput.split(SPACE));
        }
    }

    private String commentOut (String input) {
        String[] CommandbyLine = input.split(NEW_LINE);
        String commentFreeInput = new String();
        for (String line : CommandbyLine) {
            if (!line.matches(Parser.mySyntaxes.getString(COMMENT))) {
                commentFreeInput += line;
            }
            commentFreeInput += SPACE;
        }
        return commentFreeInput;
    }
}
