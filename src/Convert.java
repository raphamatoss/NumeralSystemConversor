public class Convert {
    static String decimalToBinary(int decimal) {
        StringBuilder sb = new StringBuilder();

        if (decimal == 0 || decimal == 1) {
            sb.append(decimal);
            return sb.toString();
        }
        else {
            do {
                sb.insert(0, decimal%2);
                decimal = decimal/2;
            } while(decimal != 0);

            return sb.toString();
        }
    }

    static String decimalToHex(int decimal) {
        StringBuilder sb = new StringBuilder();

        /* IF decimal < 10 ===> the number stays the same
         * ELSE
         *     aux = decimal%16; ----> which gives us a number between 0 and 15
         *     IF aux < 10 ===> the number stays the same
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
            return sb.toString();
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
            return sb.toString();
        }
    }

    static String binaryToHex(String binary) { // missing implementation
        return binary;
    }

    static int binaryToDecimal(String binary) {
        int sum = 0;
        for (int i = 1; i <= binary.length(); i++) {
            int aux = Character.getNumericValue(binary.charAt(i-1));
            sum += (int) (aux * Math.pow(2, binary.length()-i));
        }
        return sum;
    }

    static String hexToBinary(String hex) {
        int decimal;
        String temporaryBinary, aux;
        StringBuilder sb = new StringBuilder();

        /* First we get into a loop in which each of the elements of the Hex string will be converted
        * to decimal, then we convert the decimal value into its binary, reusing the function
        * decimalToBinary(). It returns a String.
        * Since the hexadecimal to binary conversion is direct we need to group each binary correspondent
        * value into four bits, example:
        *       9F2 = 100111110010, but
        *       27E = 1001111110
        * that means that if we want to get the correct value of 9F2 we need to add "00" to "10",
        * otherwise we would get 27E in binary.
        * To avoid that, in case the return of the function "decimalToDecimal" returns a String with
        * a length of less than 4 we add 0's to the beginning of the string until it reaches length = 4
        * */

        for (int i = 0; i < hex.length(); i++) {
            decimal = hexToDecimal(String.valueOf(hex.charAt(i)));
            temporaryBinary = decimalToBinary(decimal);

            while(temporaryBinary.length() < 4) {
                aux = temporaryBinary;
                temporaryBinary = "0" + aux;
            }

            sb.append(temporaryBinary);
        }
        return sb.toString();
    }

    static int hexToDecimal(String hex) {
        int decimal;

        /* IF (hex.length < 1) ===> the conversion is automatic
        *  ELSE
        *     We go through all the indexes of the provided String containing the Hex value
        *     IF (the ASCII value of the char in the index i is within [48,57])
        *           then it's a number between 0 and 9, which means we can just get
        *           its ASCII value minus 48, and we'll get the number value in decimal
        *     ELSE (the ASCII value lies between [65,70])
        *           that means it's a number between A and F. We can subtract their ASCII
        *           values minus 55 to get it in decimal;
        *      In both statements we must multiply the corresponding value in decimal times
        *      16^(hex.length - i) and sum the result of all iterations;
        * */

        if (hex.length() == 1) {
            decimal = Character.getNumericValue(hex.charAt(0));
            return decimal;
        }
        else {
            int sum = 0;
            for (int i = 1; i <= hex.length(); i++) {
                int ascii = (int) hex.charAt(i-1);
                int baseSixteen = (int) Math.pow(16, hex.length()-i);

                if (ascii >= 48 && ascii <= 57) {
                    sum += ((ascii-48) * baseSixteen);
                }
                else {
                    sum += ((ascii-55) * baseSixteen);
                }
            }
            decimal = sum;
            return decimal;
        }
    }
}
