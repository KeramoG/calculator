import java.util.Scanner;

public class CalculatorApplication {
    private static Scanner userInputScanner = new Scanner(System.in);
    private static NumberStorage numberMemory = new NumberStorage();

    public static void main(String[] args) {

        while (true) {
            displayMainMenu();
            int selectedOption = getUserMenuChoice();

            if (selectedOption == 1) {
                inputNewNumber();
            } else if (selectedOption == 2) {
                performArithmeticOperation();
            } else if (selectedOption == 3) {
                break;
            }
        }

        userInputScanner.close();
        System.out.println("Программа завершена.");
    }

    private static void displayMainMenu() {
        System.out.println("\n--- ГЛАВНОЕ МЕНЮ ---");
        System.out.println("1. Запомнить новое число");
        System.out.println("2. Выполнить операцию с текущим числом");
        System.out.println("3. Выход из программы");
        System.out.print("Ваш выбор: ");
    }

    private static int getUserMenuChoice() {
        while (true) {
            String rawInput = userInputScanner.nextLine().trim();
            if (rawInput.isEmpty()) {
                rawInput = userInputScanner.nextLine().trim();
            }

            if (InputValidator.isMenuSelectionValid(rawInput)) {
                return Integer.parseInt(rawInput);
            } else {
                System.out.print("Неверный ввод.");
            }
        }
    }

    private static int readNumberBase(String promptMessage) {
        while (true) {
            System.out.print(promptMessage);
            String baseInput = userInputScanner.nextLine().trim();

            if (InputValidator.isNumberBaseValid(baseInput)) {
                return Integer.parseInt(baseInput);
            } else {
                System.out.println("Ошибка! Допустимые системы: 2, 8, 10 или 16.");
            }
        }
    }

    private static String readNumericValue(String promptMessage, int base) {
        while (true) {
            System.out.print(promptMessage);
            String numericInput = userInputScanner.nextLine().trim();

            if (InputValidator.isNumericValueValid(numericInput, base)) {
                return numericInput;
            } else {
                System.out.println("Ошибка." + base);
            }
        }
    }

    private static String readMathematicalOperator() {
        while (true) {
            System.out.print("Операция (+, -, *, /, %): ");
            String operatorInput = userInputScanner.nextLine().trim();

            if (InputValidator.isArithmeticOperatorValid(operatorInput)) {
                return operatorInput;
            } else {
                System.out.println("Ошибка.");
            }
        }
    }

    private static void inputNewNumber() {
        int selectedBase = readNumberBase("Укажите систему счисления (2/8/10/16): ");
        String numericString = readNumericValue("Введите число: ", selectedBase);

        double parsedValue = NumberStorage.parseFromString(numericString, selectedBase);
        numberMemory.storeValue(parsedValue);
        numberMemory.showCurrentState();
    }

    private static void performArithmeticOperation() {
        System.out.println("Текущее значение: " + numberMemory.getCurrentValue());
        numberMemory.displayFormattedNumber(numberMemory.getCurrentValue(), "Текущее значение");

        int secondNumberBase = readNumberBase("Система счисления для второго числа (2/8/10/16): ");
        String secondNumberString = readNumericValue("Введите второе число: ", secondNumberBase);

        double secondNumber = NumberStorage.parseFromString(secondNumberString, secondNumberBase);
        numberMemory.displayFormattedNumber(secondNumber, "Второе число");

        String operationSymbol = readMathematicalOperator();
        MathematicalOperations calculator = new BasicCalculator();

        double operationResult = calculator.executeOperation(
                numberMemory.getCurrentValue(),
                secondNumber,
                operationSymbol
        );

        if (Double.isNaN(operationResult)) {
            System.out.println("Ошибка.");
            return;
        }

        numberMemory.storeValue(operationResult);
        String resultInTargetBase = NumberStorage.convertToString(operationResult, secondNumberBase);
        System.out.println("Результат операции (в " + secondNumberBase + "-чной системе): " + resultInTargetBase);
        numberMemory.showCurrentState();
    }
}