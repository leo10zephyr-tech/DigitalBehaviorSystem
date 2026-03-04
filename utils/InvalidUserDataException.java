package utils;

/**
 * CUSTOM EXCEPTION — extends RuntimeException
 * Instead of generic errors, we throw meaningful domain errors
 * This is exactly how companies like Google/Amazon write Java
 */
public class InvalidUserDataException extends RuntimeException {

    private String fieldName;
    private String invalidValue;

    public InvalidUserDataException(String fieldName, String invalidValue) {
        super("Invalid data for field '" + fieldName
              + "' with value: '" + invalidValue + "'");
        this.fieldName    = fieldName;
        this.invalidValue = invalidValue;
    }

    public String getFieldName()    { return fieldName; }
    public String getInvalidValue() { return invalidValue; }

    @Override
    public String toString() {
        return "InvalidUserDataException["
             + "field=" + fieldName
             + ", value=" + invalidValue + "]";
    }
}
