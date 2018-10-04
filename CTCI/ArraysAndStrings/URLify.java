/*
    1.3 URLify - Write a maethod to replace all spaces in a string with %20.
    Given the original string with sufficient space at the end and the "true length" of the original string
    For Java, use a Character array to perform the operation in place.
*/

public class URLify{
    public static void main(String[] args){
        System.out.println(makeUrl("H ell o    ", 7));
        System.out.println(makeUrl("Begin     End          ", 13));
        System.out.println(makeUrl("Mr John Smith    ", 13));
    }

    public static String makeUrl(String input, int trueLength){
        char[] inputArray = input.toCharArray(); // Character array (input)
        int fillingEndIndex = inputArray.length-1; // one index to iterate backwards, filling the string
        int backwardsIndex = trueLength-1; // another index to iterate through the "true string"
        for(int i = backwardsIndex; i>=0; i--){
            if(inputArray[i]!=" ".charAt(0)){ // move real values to the end
                inputArray[fillingEndIndex] = inputArray[i];
                fillingEndIndex--;
            }
            else{ // when a space is encountered, place %20 at the end
                inputArray[fillingEndIndex] = "0".charAt(0);
                inputArray[fillingEndIndex-1] = "2".charAt(0);
                inputArray[fillingEndIndex-2] = "%".charAt(0);
                fillingEndIndex-=3;
            }
        }
        return String.valueOf(inputArray);
    }
}