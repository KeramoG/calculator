public class InputValidator {

    public static boolean isMenuSelectionValid(String userChoice) {
        return userChoice != null && userChoice.matches("[123]");
    }

    public static boolean isNumberBaseValid(String baseInput) {
        return baseInput != null && baseInput.matches("2|8|10|16");
    }

    public static boolean isNumericValueValid(String numericInput, int base) {
        if (numericInput == null || numericInput.isEmpty()) return false;

        String upperCaseInput = numericInput.toUpperCase();

        switch (base) {
            case 2:
                return upperCaseInput.matches("[01]+(\\.[01]+)?");
            case 8:
                return upperCaseInput.matches("[0-7]+(\\.[0-7]+)?");
            case 10:
                return upperCaseInput.matches("^\\d+\\.?\\d*$|^\\.\\d+$");
            case 16:
                return upperCaseInput.matches("[0-9A-F]+(\\.[0-9A-F]+)?");
            default:
                return false;
        }
    }

    public static boolean isArithmeticOperatorValid(String operatorInput) {
        return operatorInput != null && operatorInput.matches("[+\\-*/%]");
    }
}
