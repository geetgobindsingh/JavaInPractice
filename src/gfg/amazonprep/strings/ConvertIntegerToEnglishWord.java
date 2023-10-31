package gfg.amazonprep.strings;

public class ConvertIntegerToEnglishWord {
    public static void main(String[] args) {
        System.out.println(convertToWords(2105836616));
    }

    public static String convertToWords(int n) {
        if (n < 10) {
            return getUnderTen(n);
        }
        String result = "";
        int d = 0;
        int crore = 10000000;
        int lakh = 100000;
        int thousand = 1000;
        int hundred = 100;
        if (n >= crore) {
            d = n / crore;
            result = result + getUnderThousand(d) + " " + "crore ";
            n = n % crore;
        }
        if (n >= lakh) {
            d = n / lakh;
            result = result + getUnderHundred(d) + " " + "lakh ";
            n = n % lakh;
        }
        if (n >= thousand) {
            d = n / thousand;
            result = result + getUnderHundred(d) + " " + "thousand ";
            n = n % thousand;
        }
        if (n >= hundred) {
            d = n / hundred;
            result = result + getUnderHundred(d) + " " + "hundred ";
            n = n % hundred;
        }
        return result + ((n > 0) ? "and " + getUnderHundred(n) : "");
    }

    private static String getUnderThousand(int n) {
        if (n < 10) {
            return getUnderTen(n);
        }
        String result = "";
        int d = 0;
        int thousand = 1000;
        int hundred = 100;
        if (n >= thousand) {
            d = n / thousand;
            result = result + getUnderHundred(d) + " " + "thousand ";
            n = n % thousand;
        }
        if (n >= hundred) {
            d = n / hundred;
            result = result + getUnderHundred(d) + " " + "hundred ";
            n = n % hundred;
        }
        return result + ((n > 0) ? "and " + getUnderHundred(n) : "");
    }

    private static String getUnderHundred(int d) {
        int res = d / 10;
        String result = "";
        switch (res) {
            case 9: {
                result = result + "ninety" + ((d > 90) ? " " + getUnderTen(d % 10) : "");
                break;
            }
            case 8: {
                result = result + "eighty" + ((d > 80) ? " " + getUnderTen(d % 10) : "");
                break;
            }
            case 7: {
                result = result + "seventy" + ((d > 70) ? " " + getUnderTen(d % 10) : "");
                break;
            }
            case 6: {
                result = result + "sixety" + ((d > 60) ? " " + getUnderTen(d % 10) : "");
                break;
            }
            case 5: {
                result = result + "fifty" + ((d > 50) ? " " + getUnderTen(d % 10) : "");
                break;
            }
            case 4: {
                result = result + "forty" + ((d > 40) ? " " + getUnderTen(d % 10) : "");
                break;
            }
            case 3: {
                result = result + "thirty" + ((d > 30) ? " " + getUnderTen(d % 10) : "");
                break;
            }
            case 2: {
                result = result + "twenty" + ((d > 20) ? " " + getUnderTen(d % 10) : "");
                break;
            }
            case 1: {
                switch (d) {
                    case 10: {
                        result = result + "ten";
                        break;
                    }
                    case 11: {
                        result = result + "eleven";
                        break;
                    }
                    case 12: {
                        result = result + "twelve";
                        break;
                    }
                    case 13: {
                        result = result + "thirteen";
                        break;
                    }
                    case 14: {
                        result = result + "fourteen";
                        break;
                    }
                    case 15: {
                        result = result + "fifteen";
                        break;
                    }
                    case 16: {
                        result = result + "sixteen";
                        break;
                    }
                    case 17: {
                        result = result + "seventeen";
                        break;
                    }
                    case 18: {
                        result = result + "eighteen";
                        break;
                    }
                    case 19: {
                        result = result + "nineteen";
                        break;
                    }
                }
            }
            case 0: {
                result = result + getUnderTen(d);
            }
        }
        return result;
    }

    private static String getUnderTen(int d) {
        String result = "";
        switch (d) {
            case 9: {
                result = result + "nine";
                break;
            }
            case 8: {
                result = result + "eight";
                break;
            }
            case 7: {
                result = result + "seven";
                break;
            }
            case 6: {
                result = result + "six";
                break;
            }
            case 5: {
                result = result + "five";
                break;
            }
            case 4: {
                result = result + "four";
                break;
            }
            case 3: {
                result = result + "three";
                break;
            }
            case 2: {
                result = result + "two";
                break;
            }
            case 1: {
                result = result + "one";
                break;
            }
            case 0: {
                result = result + "zero";
                break;
            }
        }
        return result;
    }
}
