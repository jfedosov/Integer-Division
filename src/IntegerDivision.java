import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class IntegerDivision {
    private final int dividend;
    private final int divisor;
    public IntegerDivision(int dividend, int divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
    }

    private List<String> prepareListToPrint(List<Integer> separatedDigits) {
        List<String> listToPrint = new LinkedList<>();

        int beginIndex = 0;
        int endIndex = 0;
        int partOfDividend = 0;

        while (beginIndex <= endIndex && endIndex < separatedDigits.size()) {
            if (beginIndex == endIndex) {
                partOfDividend = separatedDigits.get(beginIndex);
            } else {
                partOfDividend = Integer.parseInt(partOfDividend + "" + separatedDigits.get(endIndex));
            }

            if (partOfDividend < divisor) {
                endIndex++;
            } else {
                listToPrint.add(String.valueOf(partOfDividend));
                listToPrint.add(String.valueOf(partOfDividend - (partOfDividend % divisor)));
                if (partOfDividend % divisor > 0) {
                    separatedDigits.set(endIndex, partOfDividend % divisor);
                } else {
                    endIndex++;
                }
                beginIndex = endIndex;
            }
        }

        listToPrint.set(0, String.valueOf(dividend));

        return listToPrint;
    }

    private List<Integer> separateDividend(int input) {
        List<Integer> separatedDigits = new LinkedList<>();

        while (input > 0) {
            separatedDigits.add(input % 10);
            input /= 10;
        }

        Collections.reverse(separatedDigits);

        return separatedDigits;
    }

    public int getDividend() {
        return this.dividend;
    }

    public int getDivisor() {
        return this.divisor;
    }

    public List<String> getPrepareListToPrint(List<Integer> separatedDigits){
        return this.prepareListToPrint(separatedDigits);
    }

    public List<Integer> getSeparateDividend(int input){
        return this.separateDividend(input);
    }
}
