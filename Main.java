import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Это Калькулятор");
        System.out.println("Введите метематическое выражение");
        String input = userInput();
        if (checkInputString(input)) {
            String output = calc(input);
            System.out.println(output);
        }
    }

    public static String userInput() {
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.nextLine();
        sc.close();
        return inputStr;
    }

    public static Boolean checkInputString(String input) {
        // проверить строку на пустоту
        int val1, val2;
        if (input.isEmpty()) {
            System.out.println("Строка пустая");
            return false;
        }
        String[] inputList = input.split(" ");
        // проверка длины списка введеных значений
        if (inputList.length == 4) {
            System.out.println("throws Exception");
            return false;
        } else if (inputList.length > 4) {
            System.out.println("throws Exception //т.к. формат математической операции не " + 
                        "удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            return false;
        } else if (inputList.length < 3) {
            System.out.println("throws Exception //т.к. строка не является математической операцией");
            return false;
        }
        try {
            val1 = Integer.parseInt(inputList[0]);
        } catch (NumberFormatException e) {
            System.out.println("Первый операнд не является целым числом");
            return false;
        }
        try {
            val2 = Integer.parseInt(inputList[2]);
        } catch (NumberFormatException e) {
            System.out.println("Второй операнд не является целым числом");
            return false;
        }
        return true;
    }

    public static String calc(String input){
        int result = 0;
        String[] inputList = input.split(" ");
        int val1 = Integer.parseInt(inputList[0]);
        int val2 = Integer.parseInt(inputList[2]);
        String operator = inputList[1];

        switch (operator) {
            case "+" -> result = val1 + val2;
            case "-" -> result = val1 - val2;
            case "*" -> result = val1 * val2;
            case "/" -> {
                if (val2 == 0) {
                    System.out.println("На 0 делить нельзя!");
                    return "";
                } else result = val1 / val2;
            }
            default -> {
                System.out.println("throws Exception");
                return "";
        }
        return String.valueOf(result);
    }
}
