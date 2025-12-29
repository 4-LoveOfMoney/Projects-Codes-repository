import java.util.Scanner;

public class RandomPasswords {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Password length: ");
        int length = input.nextInt();

        String passSource =
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*";

        if (length > passSource.length()) {
            System.out.println("Password length too long.");
            input.close();
            return;
        }

        String password = generatePassword(passSource, length);
        System.out.println("Generated Password: " + password);

        input.close();
    }

    public static String generatePassword(String source, int length) {

        StringBuilder password = new StringBuilder();

        while (password.length() < length) {

            int index = (int)(Math.random() * source.length());
            char c = source.charAt(index);

            if (password.indexOf(String.valueOf(c)) == -1) {
                password.append(c);
            }
        }

        return password.toString();
    }
}
