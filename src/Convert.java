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

    static int hexToDecimal(String hex) { // missing implementation
        return 1;
    }
}
