import java.util.LinkedList;
import java.util.List;

public class ResultFormatter {
    private final IntegerDivision integerDivision;

    public ResultFormatter(IntegerDivision integerDivision) {
        this.integerDivision = integerDivision;
    }

    void printResult(List<String> listToPrint) {
        List<String> result = new LinkedList<String>();

        int lengthDividend = listToPrint.get(0).length();
        int lengthSubtractedNumber = listToPrint.get(1).length();

        String row1 = "_" + integerDivision.getDividend() + '|' + integerDivision.getDivisor();
        String row2 = ' ' + listToPrint.get(1) + spaces(lengthDividend - lengthSubtractedNumber) +
                '|' + hyphens(String.valueOf(integerDivision.getDividend() / integerDivision.getDivisor()).length());
        String row3 = ' ' + hyphens(lengthSubtractedNumber) + spaces(lengthDividend - lengthSubtractedNumber) +
                '|' + (integerDivision.getDividend() / integerDivision.getDivisor());

        result.add(row1);
        result.add(row2);
        result.add(row3);

        String secondRowToNumber = ' ' + listToPrint.get(1);
        int lengthIndents = secondRowToNumber.length();

        for (int i = 2; i < listToPrint.size() - 1; ) {
            int lengthUpperNumber = listToPrint.get(i).length();
            int lengthLowerNumber = listToPrint.get(i + 1).length();

            String upperRow = spaces(lengthIndents - lengthUpperNumber) + '_' + listToPrint.get(i);
            lengthIndents = upperRow.length();
            String lowerRow = spaces(lengthIndents - lengthLowerNumber) + listToPrint.get(i + 1);
            lengthIndents = lowerRow.length();
            String dividingRow = spaces(lengthIndents - lengthLowerNumber) + hyphens(lengthLowerNumber);

            result.add(upperRow);
            result.add(lowerRow);
            result.add(dividingRow);

            i += 2;
        }

        int lengthRemainder = String.valueOf(integerDivision.getDividend() % integerDivision.getDivisor()).length() - 1;
        String endRow = spaces(lengthDividend - lengthRemainder) + (integerDivision.getDividend() % integerDivision.getDivisor());
        result.add(endRow);

        for (String s : result) {
            System.out.println(s);
        }
    }

    String spaces(int length) {
        String spaces = "";

        for (int i = 0; i < length; i++) {
            spaces = spaces.concat(" ");
        }

        return spaces;
    }

    String hyphens(int length) {
        String hyphens = "";

        for (int i = 0; i < length; i++) {
            hyphens = hyphens.concat("-");
        }

        return hyphens;
    }
}