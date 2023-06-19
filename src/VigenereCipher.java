import java.util.HashMap;
import java.util.Scanner;

public class VigenereCipher {

    public static void main(String[] args) {
        //declarations
        HashMap<Character, Integer> cipherTable = new HashMap<Character, Integer>();
        String key = "";
        int keyIndex = 0;
        String plaintext = "";
        String ciphertext = "";
        String ciphertextDecryption = "";
        Scanner input = new Scanner(System.in);

        //get user input
        System.out.print("Enter the key: ");
        key = input.nextLine();
        System.out.print("\n");

        System.out.print("Enter the plaintext: ");
        plaintext = input.nextLine();
        System.out.print("\n");

        input.close();

        for (int i = 0; i < key.length(); i++) {

            if (key.charAt(i) == ' ' || !Character.isAlphabetic(key.charAt(i))) {
                System.out.println("Key must only be English letters.");
                System.out.print("Exiting");
                System.exit(0);
            }

        }

        for (int i = 0; i < plaintext.length(); i++) {

            if (plaintext.charAt(i) == ' ') {
                continue;
            }
            else if (!Character.isAlphabetic(plaintext.charAt(i))) {
                System.out.println("Plaintext cannot have numbers or symbols");
                System.out.print("Exiting");
                System.exit(0);
            }

        }

        key = key.toUpperCase();
        plaintext = plaintext.toUpperCase();

        //calculations
        //adding letters and numbers to cipher table
        cipherTable.put('A', 0);
        cipherTable.put('B', 1);
        cipherTable.put('C', 2);
        cipherTable.put('D', 3);
        cipherTable.put('E', 4);
        cipherTable.put('F', 5);
        cipherTable.put('G', 6);
        cipherTable.put('H', 7);
        cipherTable.put('I', 8);
        cipherTable.put('J', 9);
        cipherTable.put('K', 10);
        cipherTable.put('L', 11);
        cipherTable.put('M', 12);
        cipherTable.put('N', 13);
        cipherTable.put('O', 14);
        cipherTable.put('P', 15);
        cipherTable.put('Q', 16);
        cipherTable.put('R', 17);
        cipherTable.put('S', 18);
        cipherTable.put('T', 19);
        cipherTable.put('U', 20);
        cipherTable.put('V', 21);
        cipherTable.put('W', 22);
        cipherTable.put('X', 23);
        cipherTable.put('Y', 24);
        cipherTable.put('Z', 25);

        //plaintext words put together
        String plaintextWords[] = plaintext.split(" ");
        plaintext = "";

        for (int i = 0; i < plaintextWords.length; i++) {
            plaintext = plaintext + plaintextWords[i];
        }

        //Vigenere Cipher encryption
        for (int i = 0; i < plaintext.length(); i++) {
            int cipherTableVal = 0;

            //calculates cipher table value
            cipherTableVal = (cipherTable.get(plaintext.charAt(i)) + cipherTable.get(key.charAt(keyIndex))) % 26;

            //ciphertext of Vigenere Cipher
            for (Character cipherTableKey : cipherTable.keySet()) {

                if (cipherTable.get(cipherTableKey) == cipherTableVal) {
                    ciphertext = ciphertext + cipherTableKey;
                    break;
                }

            }

            keyIndex++;

            if (keyIndex == key.length()) {
                keyIndex = 0;
            }
        }

        keyIndex = 0;

        //Vigenere Cipher decryption
        for (int i = 0; i < ciphertext.length(); i++) {
            int cipherTableVal = 0;

            //calculates cipher table value
            cipherTableVal = (26 + cipherTable.get(ciphertext.charAt(i)) - cipherTable.get(key.charAt(keyIndex))) % 26;

            //ciphertext decryption of Vigenere Cipher
            for (Character cipherTableKey : cipherTable.keySet()) {

                if (cipherTable.get(cipherTableKey) == cipherTableVal) {
                    ciphertextDecryption = ciphertextDecryption + cipherTableKey;
                    break;
                }

            }

            keyIndex++;

            if (keyIndex == key.length()) {
                keyIndex = 0;
            }
        }

        //output
        System.out.println("ciphertext: " + ciphertext);
        System.out.print("ciphertext decryption: " + ciphertextDecryption);
    }
}
