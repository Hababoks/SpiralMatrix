public class StringCompressor {
    public static String compressString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        char prevChar = s.charAt(0);
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == prevChar) {
                count++;
            } else {
                sb.append(prevChar);
                if (count > 1) {
                    sb.append(count);
                }
                prevChar = currentChar;
                count = 1;
            }
        }

        sb.append(prevChar);
        if (count > 1) {
            sb.append(count);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "AAABBBCCCDDEG";
        String compressed = compressString(input);
        System.out.println("Input: " + input);
        System.out.println("Compressed: " + compressed);
    }
}
