package utils;

public class InputValidator {

    private InputValidator() {}

    public static boolean isValidName(String name) {
        return name != null
            && !name.isEmpty()
            && name.matches("[a-zA-Z ]{2,50}");
    }

    public static boolean isValidAge(String input) {
        try {
            int age = Integer.parseInt(input);
            return age >= 5 && age <= 100;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidEmail(String email) {
        return email != null
            && email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    public static double parseDouble(String input) {
        try {
            double val = Double.parseDouble(input.trim());
            return val < 0 ? 0 : (val > 24 ? 24 : val);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, using 0.");
            return 0.0;
        }
    }
}
