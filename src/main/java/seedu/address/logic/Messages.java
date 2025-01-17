package seedu.address.logic;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.parser.Prefix;
import seedu.address.model.person.Person;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_NOT_FOUND_INDEX = "Error: Invalid Index";

    public static final String MESSAGE_MISSING_INDEX = "Error: Missing Index";

    public static final String MESSAGE_IMPOSSIBLE_INDEX = "Error: The parameter is not of the type positive integer";

    public static final String MESSAGE_PREAMBLE_DETECTED = "Error: Preamble Detected";

    public static final String MESSAGE_MISSING_FIELDS_FOR_ADD_COMMAND =
            "Error: Some of the required fields are missing. "
            + "\n"
            + "Please include the following: ";

    public static final String MESSAGE_MISSING_FIELDS_POLICY_FOR_ADD_COMMAND =
            "Please include either all or none of the policy variables. "
            + "\n"
            + "You are missing the following: ";
    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_PERSON_DISPLAYED_INDEX = "The person index provided is invalid";
    public static final String MESSAGE_PERSONS_LISTED_OVERVIEW = "%1$d persons listed!";
    public static final String MESSAGE_DUPLICATE_FIELDS =
                "Multiple values specified for the following single-valued field(s): ";

    /**
     * Returns an error message indicating the duplicate prefixes.
     */
    public static String getErrorMessageForDuplicatePrefixes(Prefix... duplicatePrefixes) {
        assert duplicatePrefixes.length > 0;

        Set<String> duplicateFields =
                Stream.of(duplicatePrefixes).map(Prefix::toString).collect(Collectors.toSet());

        return MESSAGE_DUPLICATE_FIELDS + String.join(" ", duplicateFields);
    }

    /**
     * Formats the {@code person} for display to the user.
     */
    public static String format(Person person) {
        final StringBuilder builder = new StringBuilder();
        builder.append(person.getName())
                .append("; Phone: ")
                .append(person.getPhone())
                .append("; Email: ")
                .append(person.getEmail())
                .append("; Address: ")
                .append(person.getAddress())
                .append("; NRIC: ")
                .append(person.getNric())
                .append("; Licence Plate: ")
                .append(person.getLicencePlate())
                .append("\nPolicy Details (Policy Number, Policy Issue Date and Policy Expiry Date): ")
                .append(person.getPolicy().toDisplay(false))
                .append("\nTags: ");
        person.getTags().forEach(builder::append);
        return builder.toString();
    }

}
