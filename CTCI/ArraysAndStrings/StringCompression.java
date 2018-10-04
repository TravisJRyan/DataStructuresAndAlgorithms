/*
    1.6 String Compression - Implement a method to perform basic string compression using counts
    of repeated characters. For example, aabcccccaaa would become a2b1c5a3. If the compressed
    string would not become smaller than the original string, return the original string. Assume the
    string has only upper and lower case letters (a-z).
*/

public class StringCompression {
    public static void main(String[] args){
        System.out.println("Expected a2b1c5a3: "+compressString("aabcccccaaa")); // given example (standard case)
        System.out.println("Expected aaazjhlk: "+compressString("aaazjhlk")); // return original string example
        System.out.println("Expected a12: "+compressString("aaaaaaaaaaaa")); // 2 digit compression result
        System.out.println("Expected : "+compressString("")); // empty string
    }

    // O(n) time - a single loop with constant work for the length of the string
    // O(2n) space - a StringBuilder that gradually adds characters 
        // (average case the StringBuilder space will be less than the original string, but we can say roughly O(2n) still )
    // Use a StringBuilder to slowly build the new string, and compare length to determine what to return
    public static String compressString(String input){
        StringBuilder resultStringBuilder = new StringBuilder();
        int currentCharCount = 1;
        for(int i = 1; i < input.length(); i++){
            if(input.charAt(i)==input.charAt(i-1))
                currentCharCount++;
            else{
                resultStringBuilder.append(input.charAt(i-1));
                resultStringBuilder.append(currentCharCount);
                currentCharCount = 1;
            }
        }
        if(input.length()>0){
            resultStringBuilder.append(input.charAt(input.length()-1));
            resultStringBuilder.append(currentCharCount);
        }
        String finalResult = resultStringBuilder.toString();
        if(input.length()<=finalResult.length())
            return input;
        return finalResult;
    }
}