import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome! This is a numeral system converter. " +
                "You can convert decimal, hexadecimal and binary.");
        System.out.println("Choose your desired option bellow.");
        System.out.println("Decimal to Binary..........1");
        System.out.println("Decimal to Hexadecimal.....2");
        System.out.println("Binary to Hexadecimal......3");
        System.out.println("Hexadecimal to Binary......4");
        System.out.println("Exit.......................0");
        System.out.print("Insert your option: ");
        int option = sc.nextInt();

        do {
            switch (option) {
                case (0):
                    System.out.println("Finishing the program...");
                    break;
                case (1):
                    break;
                case (2):
                    break;
                case (3):
                    break;
                case (4):
                    break;
                default:
                    System.out.println("Invalid value! Insert an option again: ");
                    option = sc.nextInt();
                    break;
            }
        } while (option != 0);
    }
}