//public class Division {
//
//    private StringBuilder result;
//    private StringBuilder quotient;
//    private StringBuilder reminder;
//    private Integer reminderNumber;
//    private Integer multiplyResult;
//
//    private void init() {
//
//        this.result = new StringBuilder();
//        this.quotient = new StringBuilder();
//        this.reminder = new StringBuilder();
//
//    }
//
//    public String createLongDivision(int dividend, int divisor) {
//
//        init();
//        dividend = Math.abs(dividend);
//        divisor = Math.abs(divisor);
//        boolean firstStep = true;
//
//        if (divisor == 0) {
//            throw new IllegalArgumentException("Divisor can't be 0");
//        }
//
//        String[] digits = String.valueOf(dividend).split("");
//        Integer mod;
//
//        for (int i = 0; i < digits.length; i++) {
//
//            reminder.append(digits[i]);
//            reminderNumber = Integer.parseInt(reminder.toString());
//            mod = reminderNumber % divisor;
//            multiplyResult = reminderNumber / divisor * divisor;
//
//            if (reminderNumber >= divisor || dividend < divisor && firstStep) {
//
//                String lastReminder = String.format("%" + (i + 2) + "s", "_" + Integer.toString(reminderNumber));
//                result.append(lastReminder).append("\n");
//
//                String multiply = String.format("%" + (i + 2) + "d", multiplyResult);
//                result.append(multiply).append("\n");
//
//                Integer tab = lastReminder.length() - calculateDigit(multiplyResult);
//                result.append(createDivisor(multiplyResult, tab)).append("\n");
//
//                quotient.append(reminderNumber / divisor);
//
//                reminder.replace(0, reminder.length(), Integer.toString(mod));
//                reminderNumber = Integer.parseInt(reminder.toString());
//
//                firstStep = false;
//
//            }
//
//            if (i != digits.length - 1){
//                continue;
//            }
//
//            if (reminderNumber == 0) {
//                String[] lines = result.toString().split("\\n");
//                Integer lastLine = lines[lines.length-1].length();
//                result.append(String.format("%" + lastLine + "s", Integer.toString(reminderNumber))).append("\n");
//
//            } else if (dividend > divisor) {
//                result.append(String.format("%" + (i + 2) + "s", Integer.toString(reminderNumber))).append("\n");
//            }
//
//        }
//
//        modifyResultView(dividend, divisor);
//        return result.toString();
//
//    }
//
//    private String createDivisor (Integer multiplyResult, Integer tab) {
//        return assemblyString(tab, ' ') + assemblyString(calculateDigit(multiplyResult), '-');
//    }
//
//    private int calculateDigit(int i) {
//        return (int) Math.log10(i) + 1;
//    }
//
//    private String assemblyString(int numberOfSymbols, char symbol) {
//
//        StringBuilder string = new StringBuilder();
//
//        for (int i = 0; i < numberOfSymbols; i++) {
//            string.append(symbol);
//        }
//
//        return string.toString();
//
//    }
//
//    private int[] readThreeLines() {
//
//        int[] index = new int[3];
//
//        for (int i = 0, j = 0; i < result.length(); i++) {
//
//            if (result.charAt(i) == '\n') {
//                index[j] = i;
//                j++;
//            }
//
//            if (j == 3) {
//                break;
//            }
//
//        }
//        return index;
//
//    }
//
//    private void modifyResultView(Integer dividend, Integer divisor) {
//
//        int[] index = readThreeLines();
//
//        int tab = calculateDigit(dividend) + 1 - index[0];
//
//        if (reminderNumber == 0) {
//            reminder = reminder.deleteCharAt(reminder.length()-1);
//            quotient.append(reminder);
//
//        } else if (multiplyResult == 0 && dividend > divisor) {
//            quotient.append(0);
//        }
//
//        result.insert(index[2], assemblyString(tab, ' ') + "│" + quotient.toString());
//
//        if (dividend < divisor) {
//            result.replace(index[2], 100, assemblyString(dividend.toString().length()+1, ' ') + "│" + quotient.toString()).append("\n");
//        }
//
//        result.insert(index[1], assemblyString(tab, ' ') + "│" + assemblyString(quotient.length(), '-'));
//        result.insert(index[0], "│" + divisor);
//        result.replace(1, index[0], dividend.toString());
//
//    }
//
//    public static void main(String[] args) {
//
//        Division division = new Division();
//
//        System.out.println(division.createLongDivision(78459, 4));
//        System.out.println(division.createLongDivision(1000, 3));
//        System.out.println(division.createLongDivision(7, 12));
//
//    }
//}