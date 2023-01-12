import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        System.out.println(calc(input));
    }

    public static String calc(String input) throws Exception {
        String array[];
        array = input.split(" ");

        if (array.length < 3) {
            throw new Exception("строка не является математической операцией");
        }

        int a = -1;
        int b = -1;
        boolean aArab = false;
        boolean bArab = false;

        try {
            a = Integer.parseInt(array[0]);
        } catch (NumberFormatException e) {
            a = rimNumber(array[0]);
            aArab = true;
            if (a == 0) {
                throw new Exception("Нет такого числа");
            }
        }
        try {
            b = Integer.parseInt(array[2]);
        } catch (NumberFormatException e) {
            b = rimNumber(array[2]);
            bArab = true;
            if (b == 0) {
                throw new Exception("Нет такого числа");
            }
        }

        if (aArab == false && bArab == false) {
            try {
                Integer.parseInt(array[0]);
                Integer.parseInt(array[2]);
            } catch (NumberFormatException e) {
                throw new Exception(" программа работает только с целыми числами");
            }
        }

        if (aArab != bArab) {
            throw new Exception(" используются одновременно разные системы счисления");
        }

        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new Exception(" числа выходят за допустимую границу");
        }

        if (aArab && bArab && (a < b)) {
            throw new Exception("в римской системе нет отрицательных чисел");
        }

        if (array.length > 3) {
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        int result = operation(a, b, array[1]);

        if (aArab){
            return transformRim(result);
        } else{
            return String.valueOf(result);
        }
    }

    public static Integer rimNumber(String number) {
        switch (number) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
        }
        return 0;
    }

    public static String transformRim(int number){
        if (number <= 10){
            return rimUnits(number);
        } else {
            return rimDozens(number / 10) + rimUnits(number % 10);
        }
    }

    public static String rimUnits(int number) {
        switch (number) {
            case 0:
                return "";
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
            case 10:
                return "X";
        }
        return "";
    }

    public static String rimDozens(int number) {
        switch (number) {
            case 1:
                return "X";
            case 2:
                return "XX";
            case 3:
                return "XXX";
            case 4:
                return "XL";
            case 5:
                return "L";
            case 6:
                return "LX";
            case 7:
                return "LXX";
            case 8:
                return "LXXX";
            case 9:
                return "XC";
            case 10:
                return "C";
        }
        return "";
    }

    public static Integer operation(int a, int b, String number) {
        switch (number) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
        }
        return 0;
    }
}