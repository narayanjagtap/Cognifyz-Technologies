import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        System.out.println("Palindrome Checker");
        System.out.println("---------------------");

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a random word : ");
        String Name = scan.nextLine();

        String Name1 = "";

        for(int i=Name.length()-1; i>=0; i--){
            Name1 = Name1 + Name.charAt(i);
        }

        if(Name.equals(Name1)){
            System.out.println("Given String is Palindrome");
        }
        else{
            System.out.println("Given String is NOT Palindrome");
        }
    }
}