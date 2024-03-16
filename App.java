import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Corrected variable name

        System.out.println("Enter Card Number:");
        String cc = scanner.nextLine();

        if (isValid(cc)) {
            System.out.println("The Card is Valid.");
            int length = cc.length();
            if (length == 13 || length == 16) {
                identifyCardType(cc);
            } else {
                System.out.println("Invalid Card Length");
            }
        } else {
            System.out.println("The Card is Not Valid.");
        }
    }

    public static boolean isValid(String cc) {
        int sum = 0;
        for (int i = cc.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(cc.charAt(i)); 
            digit = (i % 2 == 1) ? digit * 2 : digit;

            if (digit > 9) {
                digit = digit / 10 + digit % 10;
            }
            sum += digit;
        }
        return sum % 10 == 0;
    }

    public static void identifyCardType(String cc) {
        String firstDigit = cc.substring(0, 1);
        String firstTwoDigits = cc.substring(0, 2);

        if (firstDigit.equals("4")) {
            System.out.println("The Card is Visa.");
        } else if (firstTwoDigits.startsWith("51") || firstTwoDigits.startsWith("52") ||
                firstTwoDigits.startsWith("53") || firstTwoDigits.startsWith("54") ||
                firstTwoDigits.startsWith("55")) {
            System.out.println("The Card is MasterCard.");
        } else {
            System.out.println("Card type identification not implemented yet.");
        }
    }
}
