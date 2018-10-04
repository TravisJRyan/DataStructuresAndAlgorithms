import java.util.HashSet;

public class IsUniqueChars {
    public static void main(String[] args) {
        String[] testStrings = { "dog", "notallunique", "uniqe", "cat", "hiiiii", "" };
        for (String testString : testStrings) {
            System.out.println(testString + " : " + isUnique(testString));
            System.out.println(testString + " : " + isUniqueWithoutSet(testString));
        }
    }

    // Use a HashSet to store seen characters
    public static boolean isUnique(String input) {
        HashSet<Character> charsSeen = new HashSet<Character>();
        for (int i = 0; i < input.length(); i++) {
            if (charsSeen.contains(input.charAt(i)))
                return false;
            else
                charsSeen.add(input.charAt(i));
        }
        return true;
    }

    // Use int "checker" as a bitVector to flag which chars have been seen
    public static boolean isUniqueWithoutSet(String input) {
        int checker = 0;
        for (int i = 0; i < input.length(); i++) {
            int val = input.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0)
                return false;
            checker |= (1 << val);
        }
        return true;
    }
}