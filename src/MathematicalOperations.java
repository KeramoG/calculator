public interface MathematicalOperations {
    double sum(double firstNumber, double secondNumber);
    double difference(double firstNumber, double secondNumber);
    double product(double firstNumber, double secondNumber);
    double quotient(double firstNumber, double secondNumber);
    double remainder(double firstNumber, double secondNumber);
    double executeOperation(double firstNumber, double secondNumber, String operator);
}
