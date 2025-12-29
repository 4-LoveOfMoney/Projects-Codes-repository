import java.util.Scanner;

public class TranslatePhoneNumber2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean doContinue;

        do {
            System.out.print("Please enter a phone number with letters: ");
            String phoneword = input.next();

            String translatedNumber =
                    translateLettersToNumbers(phoneword);

            System.out.println("Here is your translated phone number: "
                    + translatedNumber);

            System.out.print(
                "Do you want to translate another Phone Number? (yes/no) "
            );
            String answer = input.next();

            doContinue = answer.equalsIgnoreCase("yes");

        } while (doContinue);

        System.out.println("Thanks for using my phone number translator!");
        input.close();
    }

    private static String translateLettersToNumbers(String phoneWithLetters) {

        StringBuilder result = new StringBuilder();

        for (char character : phoneWithLetters.toCharArray()) {

            if (Character.isLetter(character)) {
                result.append(getNumberFromLetter(character));
            } else {
                result.append(character);
            }
        }

        return result.toString();
    }

    private static char getNumberFromLetter(char letter) {

        switch (Character.toUpperCase(letter)) {
            case 'A': case 'B': case 'C': return '2';
            case 'D': case 'E': case 'F': return '3';
            case 'G': case 'H': case 'I': return '4';
            case 'J': case 'K': case 'L': return '5';
            case 'M': case 'N': case 'O': return '6';
            case 'P': case 'Q': case 'R': case 'S': return '7';
            case 'T': case 'U': case 'V': return '8';
            case 'W': case 'X': case 'Y': case 'Z': return '9';
            default: return letter;
        }
    }
}
