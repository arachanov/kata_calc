import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static char oper;
    public static void main(String[] args) throws Throwable {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean isRoman = true;
        int kol = 0;
        input = input.replace(" ", "");
        for (int i=0; i<input.length()-1;i++) {
            switch (input.charAt(i)) {
                case ('+'): oper = '+';
                    kol++;
                    break;
                case ('-'): oper = '-';
                    kol++;
                    break;
                case ('/'): oper = '/';
                    kol++;
                    break;
                case ('*'): oper = '*';
                    kol++;
                    break;
            }
        }
        String[] words = input.split("\\+|-|/|\\*");
        if (words.length > 1) {
            if (kol == 1 ) {

                try {
                    Pattern pattern = Pattern.compile("^(IX|IV|V?I{0,3})$");
                    Pattern pattern1 = Pattern.compile("[1-9]");
                    input = "";
                    for (String word : words) {
                        Matcher matcher = pattern.matcher(word);
                        if (matcher.find()) {
                            input = input + convertToArab(word);
                        }
                    }
                    if (input.length() == 0) {
                        isRoman = false;
                        for (String word : words) {
                            Matcher matcher = pattern1.matcher(word);
                            if ((matcher.find()) & (word.length() == 1)) {
                                input = input + word;
                            }
                        }
                    }
                    if (isRoman) {
                        System.out.println(convertToRome(calc(input)));
                    } else System.out.println(calc(input));
                } catch (Throwable throwable) {
                    System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
                }
            } else System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else System.out.println("throws Exception //т.к. строка не является математической операцией");

    }
    public static String calc(String input) {

        int a = Character.getNumericValue(input.charAt(0));
        int b = Character.getNumericValue(input.charAt(1));

        switch (oper) {
            case ('+') : return String.valueOf(add(a, b));
            case ('-') : return String.valueOf(subtract(a, b));
            case ('*') : return String.valueOf(multiple(a, b));
            case ('/') : return String.valueOf(div(a, b));
        }
        return input ;
    }
    static String convertToArab(String value){
        switch (value) {
            case ("I") : return "1";
            case ("II") : return "2";
            case ("III") : return "3";
            case ("IV") : return "4";
            case ("V") : return "5";
            case ("VI") : return "6";
            case ("VII") : return "7";
            case ("VIII") : return "8";
            case ("IX") : return "9";
        }
        return "fail";
    }
    static String convertToRome(String value){
        String res = "";
        if (value.length() > 1) {
            switch (value.charAt(0)) {
                case ('-') : return "throws Exception //т.к. в римской системе нет отрицательных чисел";
                case ('1') : res = "X";
                break;
                case ('2') : res = "XX";
                break;
                case ('3') : res = "XXX";
                break;
                case ('4') : res = "XL";
                break;
                case ('5') : res = "L";
                break;
                case ('6') : res = "LX";
                break;
                case ('7') : res = "LXX";
                break;
                case ('8') : res = "LXXX";
                break;
                case ('9') : res = "XC";
                break;
            }
            switch (value.charAt(1)) {
                case ('0') : break;
                case ('1') : res = res + "I";
                break;
                case ('2') : res = res + "II";
                break;
                case ('3') : res = res + "III";
                break;
                case ('4') : res = res + "IV";
                break;
                case ('5') : res = res + "V";
                break;
                case ('6') : res = res + "VI";
                break;
                case ('7') : res = res + "VII";
                break;
                case ('8') : res = res + "VIII";
                break;
                case ('9') : res = res + "IX";
                break;
            }

        } else  switch (value.charAt(0)) {
            case ('0') : break;
            case ('1') : res = res + "I";
            break;
            case ('2') : res = res + "II";
            break;
            case ('3') : res = res + "III";
            break;
            case ('4') : res = res + "IV";
            break;
            case ('5') : res = res + "V";
            break;
            case ('6') : res = res + "VI";
            break;
            case ('7') : res = res + "VII";
            break;
            case ('8') : res = res + "VIII";
            break;
            case ('9') : res = res + "IX";
            break;
        }
        return res;
    }
    static int add(int first, int second) {
        return (first + second);
    }

    static int subtract(int first, int second) {
        return first - second;
    }

    static int div(int first, int second) {

        return first / second;
    }
    static int multiple(int first, int second) {

        return first * second;
    }
}