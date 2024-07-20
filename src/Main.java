import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome! This is a numeral system converter. " +
                "You can convert decimal, hexadecimal and binary.");
        System.out.println("Choose your desired option bellow.");
        System.out.println("Decimal to Binary..........1");
        System.out.println("Decimal to Hexadecimal.....2");
        System.out.println("Binary to Hexadecimal......3");
        System.out.println("Binary to Decimal..........4");
        System.out.println("Hexadecimal to Binary......5");
        System.out.println("Hexadecimal to Decimal.....6");
        System.out.println("Exit.......................0");
        System.out.print("Insert your option: ");
        int option = sc.nextInt();

        do {
            switch (option) {
                case (0):
                    System.out.println("Finishing the program...");
                    return;
                case (1):
                    System.out.println(decimalToBinary());
                    return;
                case (2):
                    System.out.println(decimalToHex());
                    return;
                case (3):
                    return;
                case (4):
                    return;
                case (5):
                    return;
                case (6):
                    return;
                default:
                    System.out.println("Invalid value! Insert an option again: ");
                    option = sc.nextInt();
                    break;
            }
        } while (option != 0);
    }

    static String decimalToBinary() {
        System.out.print("Insert the decimal value: ");
        int decimal = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        if (decimal == 0 || decimal == 1) {
            sb.append(decimal);
            return "Resultado: " + sb.toString();
        }
        else {
            do {
                sb.insert(0, decimal%2);
                decimal = decimal/2;
            } while(decimal != 0);

            return "Resultado: " + sb.toString();
        }
    }

    static String decimalToHex() {
        System.out.print("Insert the decimal value: ");
        int decimal = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        /* IF decimal < 10 => the number stays the same
        * ELSE
        *     aux = decimal%16; ----> which gives us a number between 0 and 15
        *     IF aux < 10 => the number stays the same
        *     ELSE
        *         aux2 = aux - 10; ----> which gives a number between 0 and 5
        *
        *         Since we know the number 10 equals to "A" in Hex, now we just need to get the
        *         value of "A" in ASCII and sum it to aux2:
        *           It gives us a range of [65, 70], which represents A,B,C,D,E,F in ASCII, in this order.
        *         Then we convert the ASCII value into the Char it represents.
        * */

        if (decimal < 10) {
            sb.append(decimal);
            return "Result: " + sb.toString();
        }
        else {
            do {
                int aux = decimal%16;
                if (aux < 10) {
                    sb.insert(0, aux);
                }
                else {
                    int aux2 = aux - 10;
                    char ascii = (char) (65+aux2);
                    sb.insert(0, ascii);
                }
                decimal = decimal/16;
            } while(decimal != 0);
            return "Result: " + sb.toString();
        }
    }
}