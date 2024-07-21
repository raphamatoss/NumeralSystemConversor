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


        int decimal;
        String binary;
        do {
            switch (option) {
                case (0):
                    System.out.println("Finishing the program...");
                    return;
                case (1):
                    System.out.print("Insert the decimal value: ");
                    decimal = sc.nextInt();
                    System.out.println("Result: " + Convert.decimalToBinary(decimal));
                    return;
                case (2):
                    System.out.print("Insert the decimal value: ");
                    decimal = sc.nextInt();
                    System.out.println("Result: " + Convert.decimalToHex(decimal));
                    return;
                case (3):
                    System.out.print("Insert the binary value: ");
                    binary = sc.next();
                    System.out.println("Result: " + Convert.binaryToHex(binary));
                    return;
                case (4):
                    System.out.print("Insert the binary value: ");
                    binary = sc.next();
                    System.out.println("Result: " + Convert.binaryToDecimal(binary));
                    return;
                case (5):
                    return;
                case (6):
                    return;
                default:
                    System.out.print("Invalid value! Insert an option again: ");
                    option = sc.nextInt();
                    break;
            }
        } while (option != 0);
    }
}