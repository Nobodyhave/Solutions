package leetcode;

/**
 * Created by Aleksandr on 10/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/integer-to-english-words/description/
 */
public class IntegerToEnglishWords {
    public String numberToWords(int num) {
        final String s = String.valueOf(num);
        final StringBuilder sb = new StringBuilder();

        if (s.length() == 10) {
            sb.append(printBillions(s));
        }
        if (s.length() >= 7) {
            sb.append(printMillions(s));
        }
        if (s.length() >= 4) {
            sb.append(printThousands(s));
        }
        sb.append(printNumber(s));

        return sb.toString().trim();
    }

    private String printOneDigit(String s) {
        switch (s.charAt(0)) {
            case '0':
                return " Zero";
            case '1':
                return " One";
            case '2':
                return " Two";
            case '3':
                return " Three";
            case '4':
                return " Four";
            case '5':
                return " Five";
            case '6':
                return " Six";
            case '7':
                return " Seven";
            case '8':
                return " Eight";
            case '9':
                return " Nine";
            default:
                throw new IllegalArgumentException();
        }
    }

    private String printTwoDigits(String s) {
        switch (s.charAt(0)) {
            case '0':
                return (s.charAt(1) != '0') ? printOneDigit(s.substring(1, 2)) : "";
            case '1':
                switch (s.charAt(1)) {
                    case '0':
                        return " Ten";
                    case '1':
                        return " Eleven";
                    case '2':
                        return " Twelve";
                    case '3':
                        return " Thirteen";
                    case '4':
                        return " Fourteen";
                    case '5':
                        return " Fifteen";
                    case '6':
                        return " Sixteen";
                    case '7':
                        return " Seventeen";
                    case '8':
                        return " Eighteen";
                    case '9':
                        return " Nineteen";
                    default:
                        throw new IllegalArgumentException();
                }
            case '2':
                return " Twenty" + ((s.charAt(1) != '0') ? printOneDigit(s.substring(1, 2)) : "");
            case '3':
                return " Thirty" + ((s.charAt(1) != '0') ? printOneDigit(s.substring(1, 2)) : "");
            case '4':
                return " Forty" + ((s.charAt(1) != '0') ? printOneDigit(s.substring(1, 2)) : "");
            case '5':
                return " Fifty" + ((s.charAt(1) != '0') ? printOneDigit(s.substring(1, 2)) : "");
            case '6':
                return " Sixty" + ((s.charAt(1) != '0') ? printOneDigit(s.substring(1, 2)) : "");
            case '7':
                return " Seventy" + ((s.charAt(1) != '0') ? printOneDigit(s.substring(1, 2)) : "");
            case '8':
                return " Eighty" + ((s.charAt(1) != '0') ? printOneDigit(s.substring(1, 2)) : "");
            case '9':
                return " Ninety" + ((s.charAt(1) != '0') ? printOneDigit(s.substring(1, 2)) : "");
            default:
                throw new IllegalArgumentException();
        }
    }

    private String printThreeDigits(String s) {
        return (s.charAt(0) != '0' ? printOneDigit(s.substring(0, 1)) + " Hundred" : "") + printTwoDigits(s.substring(1, 3));
    }

    private String printBillions(String s) {
        final String num = printNumber(s.substring(0, s.length() - 9));
        return num + (num.length() != 0 ? " Billion" : "");
    }

    private String printMillions(String s) {
        final String num = printNumber(s.substring(0, s.length() - 6));
        return num + (num.length() != 0 ? " Million" : "");
    }

    private String printThousands(String s) {
        final String num = printNumber(s.substring(0, s.length() - 3));
        return num + (num.length() != 0 ? " Thousand" : "");
    }

    private String printNumber(String s) {
        if (s.length() == 1) {
            return printOneDigit(s);
        } else if (s.length() == 2) {
            return printTwoDigits(s);
        } else if (s.length() == 3) {
            return printThreeDigits(s);
        } else {
            return printThreeDigits(s.substring(s.length() - 3, s.length()));
        }
    }
}
