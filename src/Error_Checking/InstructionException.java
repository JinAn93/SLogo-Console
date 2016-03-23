package Error_Checking;

/**
 * Serves to catch exception when wrong command name is inputed
 *
 * @author Jin An
 *
 */
public class InstructionException extends Exception {

    // for serialization
    private static final long serialVersionUID = 1L;

    public InstructionException () {
        super();
    }
}
