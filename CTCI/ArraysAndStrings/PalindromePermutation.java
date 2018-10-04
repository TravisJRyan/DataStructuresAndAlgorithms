import java.util.HashSet;

/*  
    1.4 Palindrome Permutation - Given a string, return whether or not it is a
    permutation of a palindrome (a word the same forward and backward). Does not need
    to be limited to just dictionary words.
*/

class PalindromePermutation {
    public static void main(String[] args){
        String trueTest1 = "ctoatac";
        String trueTest2 = "zrr2zad2a";
        String falseTest1 = "radarr";
        String falseTest2 = "notapalindromepermutation";
        System.out.println(isPalindromePermutation(trueTest1));
        System.out.println(isPalindromePermutation(trueTest2));
        System.out.println(isPalindromePermutation(falseTest1));
        System.out.println(isPalindromePermutation(falseTest2));
    }

    public static boolean isPalindromePermutation(String input){
        HashSet<Character> charsToFind = new HashSet<Character>();
        for(int i = 0; i < input.length(); i++){
            if(charsToFind.contains(input.charAt(i)))
                charsToFind.remove(input.charAt(i));
            else
                charsToFind.add(input.charAt(i));
        }
        if(charsToFind.size() == 0 || charsToFind.size() == 1)
            return true;
        return false;
    }


}