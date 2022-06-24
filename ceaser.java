import java.util.Scanner;

public class ceaser {

    // declear the alphabet from a to z
    static String alpha = "abcdefghijklmnopqrstuvwxyz";

    // use encoding method:

    // we always have to use two parameter for encoding and decoding which is  text
    // and key
    public static String encoding(String ptext, int key) {
        ptext = ptext.toLowerCase(); // all the alphabet will be in lower case

        String ctext = ""; // this is a cipher text that gonna be store

        for (int i = 0; i < ptext.length(); i++) { // using condition

            int charIndex = alpha.indexOf(ptext.charAt(i));

            int newIndex = (charIndex + key) % 26;

            char cipherChar = alpha.charAt(newIndex);

            ctext = ctext + cipherChar;

        }

        return ctext;

    }

    public static String decoding(String ctext, int key) {
        ctext = ctext.toLowerCase();
        String ptext = "";
        for (int i = 0; i < ctext.length(); i++) {
            int charIndex = alpha.indexOf(ctext.charAt(i));
            int newIndex = (charIndex - key) % 26;

            if (newIndex < 0) {
                newIndex = alpha.length() + newIndex;
            }
            char plainChar = alpha.charAt(newIndex);
            ptext = ptext + plainChar;

        }

        return ptext;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("ENTER  PLAIN >>");
        String plain = sc.nextLine();

        System.out.println("PLEASE ENTER KEY >>");
        int key = sc.nextInt();

        String cipherText = encoding(plain, key);
        System.out.println("THE CIPHER TEXT OF   " + plain + " is " + cipherText);

        String plainText = decoding(cipherText, key);

        System.out.println("THE DECODE MESSAGE OF   " + cipherText + " is " + plain);

    }

}
