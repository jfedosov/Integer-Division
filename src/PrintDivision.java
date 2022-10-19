import java.util.List;

public class PrintDivision {
    private void printDivision(int dividend, int divisor) {
        IntegerDivision integerDivision = new IntegerDivision(dividend, divisor);
        ResultFormatter resultFormatter = new ResultFormatter(integerDivision);

        requirePositiveNumber(dividend);
        requirePositiveNumber(divisor);
        requireDividendBiggerThanDivisor(dividend, divisor);

        List<Integer> separatedDigits = integerDivision.getSeparateDividend(dividend);

        List<String> listToPrint = integerDivision.getPrepareListToPrint(separatedDigits);

        resultFormatter.printResult(listToPrint);
    }

    private void requirePositiveNumber(int input) {
        if (input < 1) {
            throw new IllegalArgumentException("Input number must be more than 0");
        }
    }

    private void requireDividendBiggerThanDivisor(int dividend, int divisor) {
        if (dividend < divisor) {
            throw new IllegalArgumentException("Dividend must be bigger than divisor");
        }
    }

    public void getPrintDivision(int dividend, int divisor){
        this.printDivision(dividend, divisor);
    }
}
