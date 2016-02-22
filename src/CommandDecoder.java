
/**
 * CommandDecoder serves to parse the input and check whether there exist any error.
 * 
 * @author Jin An
 *
 */
public class CommandDecoder {
    public boolean checkError (String input) {
        return false;
    }

    public String[] parseCommand (String input) {
        String[] CommandbyLine = input.split("\n");
        String commentFreeInput = new String();
        for (String line : CommandbyLine) {
            if (!line.matches("^#.*")) {
                commentFreeInput += line;
            }
        }
        String[] commands = commentFreeInput.split(" ");
        return commands;
    }
}
