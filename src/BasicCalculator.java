public class BasicCalculator implements MathematicalOperations {

    @Override
    public double sum(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    @Override
    public double difference(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    @Override
    public double product(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    @Override
    public double quotient(double firstNumber, double secondNumber) {
        return secondNumber != 0 ? firstNumber / secondNumber : Double.NaN;
    }

    @Override
    public double remainder(double firstNumber, double secondNumber) {
        return secondNumber != 0 ? firstNumber % secondNumber : Double.NaN;
    }

    @Override
    public double executeOperation(double firstNumber, double secondNumber, String operator) {
        switch (operator) {
            case "+": return sum(firstNumber, secondNumber);
            case "-": return difference(firstNumber, secondNumber);
            case "*": return product(firstNumber, secondNumber);
            case "/": return quotient(firstNumber, secondNumber);
            case "%": return remainder(firstNumber, secondNumber);
            default: return Double.NaN;
        }
    }
}
