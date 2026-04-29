public class NumberBaseConverter {

    public static int convertToDecimal(String numericString, int sourceBase) {
        return Integer.parseInt(numericString, sourceBase);
    }

    public static String convertFromDecimal(int decimalNumber, int targetBase) {
        if (targetBase == 2) {
            return Integer.toBinaryString(decimalNumber);
        } else if (targetBase == 8) {
            return Integer.toOctalString(decimalNumber);
        } else if (targetBase == 16) {
            return Integer.toHexString(decimalNumber).toUpperCase();
        } else {
            return Integer.toString(decimalNumber, targetBase);
        }
    }
}