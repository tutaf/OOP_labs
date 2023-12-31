package lab2.operations;

import lab2.Utils;
import lab2.entities.University;

public interface Operation {

    /**
     * The number of required arguments for the operation.
     */
    boolean matchesRequiredArgsNumber(int argNumber);

    /**
     * Executes the operation with given arguments and university.
     * This function is private and is wrapped by the `safeExecute` method.
     *
     * @param args The arguments for the operation.
     * @param university The university instance to operate on.
     * @return True if the operation is successful, otherwise false.
     */
    boolean execute(String[] args, University university);

    /**
     * A safe wrapper around the execute function.
     * This function is available for external calls and ensures error handling.
     *
     * @param args The arguments for the operation.
     * @param university The university instance to operate on.
     * @return True if the operation is successful and argument number matches, otherwise false.
     */
    default boolean safeExecute(String[] args, University university) {
        if (!matchesRequiredArgsNumber(args.length)) {
            Utils.showInvalidArgumentNumberError();
            return false; // Argument number mismatch
        }

        try {
            return execute(args, university);
        } catch (Exception e) {
            Utils.showErrorMessage("Something went wrong. Use h for help.");
            return false; // Return false on any error
        }
    }
}
