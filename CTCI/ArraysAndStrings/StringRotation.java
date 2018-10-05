/*
    1.9 String Rotation - Assume you have a method "isSubstring" which checks if one word is a substring of another.
    Given two Strings s1 and s2 and using only one call to "isSubstring", determine if s2 is a rotation of s1.
    Example: "waterbottle" is a rotation of "erbottlewat"
*/

public class StringRotation{
    public static void main(String[] args){
        System.out.println("Expecting True: "+isRotation("waterbottle", "erbottlewat")); // standard case test
        System.out.println("Expecting True: "+isRotation("gcatdo", "catdog")); // one letter rotation at end
        System.out.println("Expecting True: "+isRotation("nochange", "nochange")); // test for a full rotation (no change)
        System.out.println("Expecting False: "+isRotation("notarotation", "notrotation")); // different lengths
        System.out.println("Expecting False: "+isRotation("applesauce", "applesaucz")); // different final letter
        System.out.println("Expecting False: "+isRotation("This is a test.", "Is this a test.")); // permutation, not a rotation
    }

    // Double the first string so that it contains the secondString (if rotation) and return isSubstring
    public static boolean isRotation(String firstString, String secondString){
        int firstStringLength = firstString.length();
        if(firstStringLength==secondString.length() && firstStringLength!=0){
            String doubleString = firstString+firstString;
            return isSubstring(secondString, doubleString);
        }
        return false;
    }

    public static boolean isSubstring(String smallerString, String largerString){
        return largerString.contains(smallerString);
    }


}