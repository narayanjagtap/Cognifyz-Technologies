
import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Password Strength Checker");
        System.out.println("-------------------------");

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        int length = password.length();
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char ch : password.toCharArray()) {
            if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(ch)) {
                hasSpecialChar = true;
            }
        }

        int strength = 0;

        if (length >= 8) {
            strength++;
        }
        if (hasUppercase && hasLowercase) {
            strength++;
        }
        if (hasDigit) {
            strength++;
        }
        if (hasSpecialChar) {
            strength++;
        }

        System.out.print("Password strength: ");
        switch (strength) {
            case 0:
                System.out.println("Very Weak");
                break;
            case 1:
                System.out.println("Weak");
                break;
            case 2:
                System.out.println("Moderate");
                break;
            case 3:
                System.out.println("Strong");
                break;
            case 4:
                System.out.println("Very Strong");
                break;
            default:
                System.out.println("Unknown");
                break;
        }

    }
}
