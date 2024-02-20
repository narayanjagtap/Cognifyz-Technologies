import java.io.*;

public class FileEncryptionDecryption {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("File Encryption/Decryption Program");
            System.out.println("-----------------------------------");
            System.out.print("Enter 'E' for encryption or 'D' for decryption: ");
            char choice = reader.readLine().charAt(0);

            System.out.print("Enter the path of the input file: ");
            String inputFilePath = reader.readLine();
            File inputFile = new File(inputFilePath);

            if (!inputFile.exists()) {
                System.out.println("File not found.");
                return;
            }

            System.out.print("Enter the path of the output file: ");
            String outputFilePath = reader.readLine();
            File outputFile = new File(outputFilePath);

            if (choice == 'E' || choice == 'e') {
                encryptFile(inputFile, outputFile);
                System.out.println("Encryption successful.");
            } else if (choice == 'D' || choice == 'd') {
                decryptFile(inputFile, outputFile);
                System.out.println("Decryption successful.");
            } else {
                System.out.println("Invalid choice. Please enter 'E' for encryption or 'D' for decryption.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void encryptFile(File inputFile, File outputFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

        int shift = 3; // Caesar cipher shift
        int character;
        while ((character = reader.read()) != -1) {
            char encryptedCharacter = (char) (character + shift);
            writer.write(encryptedCharacter);
        }

        reader.close();
        writer.close();
    }

    private static void decryptFile(File inputFile, File outputFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

        int shift = 3; // Caesar cipher shift
        int character;
        while ((character = reader.read()) != -1) {
            char decryptedCharacter = (char) (character - shift);
            writer.write(decryptedCharacter);
        }

        reader.close();
        writer.close();
    }
}
