
import java.util.Scanner;
import java.util.Random;

public class RandomPasswordGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Random Password Generator");
        System.out.println("-------------------------");

        // Prompt user for password length
        System.out.print("Enter the desired length of the password: ");
        int length = scanner.nextInt();

        // Prompt user for password composition
        System.out.print("Include numbers? (yes/no): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include lowercase letters? (yes/no): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include special characters? (yes/no): ");
        boolean includeSpecial = scanner.next().equalsIgnoreCase("yes");

        // Define character sets
        String numbers = "0123456789";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialCharacters = "!@#$%^&*()-_=+";

        StringBuilder passwordBuilder = new StringBuilder();

        if (includeNumbers) {
            passwordBuilder.append(numbers);
        }
        if (includeLowercase) {
            passwordBuilder.append(lowercaseLetters);
        }
        if (includeUppercase) {
            passwordBuilder.append(uppercaseLetters);
        }
        if (includeSpecial) {
            passwordBuilder.append(specialCharacters);
        }

        String allPossibleCharacters = passwordBuilder.toString();

        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allPossibleCharacters.length());
            password.append(allPossibleCharacters.charAt(randomIndex));
        }

        System.out.println("Generated Password is : " + password.toString());

    }
}
