/*
    1.5 One Away - Return a boolean based on whether or not a String is
    one away from another String. Valid edits are inserting a character,
    removing a character, or replacing a character
*/

public class OneAway {
    public static void main(String[] args){
        System.out.println("True :"+oneAway("cat","ct")); // one removal
        System.out.println("True :"+oneAway("cat","cabt")); // one addition
        System.out.println("True :"+oneAway("cat","czt")); // one replace
        System.out.println("True :"+oneAway("cat","catz")); // one addition at end
        System.out.println("True :"+oneAway("catcatcatcatcat","catcatcatcatcatz")); // one addition at end of long string
        System.out.println("False :"+oneAway("cat","c")); // differing lengths by 2
        System.out.println("False :"+oneAway("this string is more than one away","this stzzng is more than one away")); // 2 consecutive replaces
        System.out.println("False :"+oneAway("falseTest","fazseTesz"));// same length, 2 different replaces
        System.out.println("False :"+oneAway("falseTest","falseTest")); // not any differences
    }

    // O(n) time - one loop through length of strings with constant work inside
    // O(n) space - No new strings are created
    // Iterate through both strings, flag any "oneOff" discrepencies, and keep iterating accordingly
    public static boolean oneAway(String firstInput, String secondInput){
        if(Math.abs(firstInput.length()-secondInput.length())>1)
            return false;
        int secondInputIndex = 0;
        boolean oneOff = false;
        for(int i = 0; i < firstInput.length(); i++){
            if(firstInput.charAt(i) != secondInput.charAt(secondInputIndex)){
                if(oneOff)
                    return false;
                if(firstInput.length()>secondInput.length())
                    i++;
                else if(secondInput.length() > firstInput.length())
                    secondInputIndex++;
                oneOff = true;
            }
            secondInputIndex++;
        }

        // Final check for final index which loop can miss
        if(firstInput.charAt(firstInput.length()-1)!=secondInput.charAt(secondInput.length()-1)){
            if(oneOff)
                return false;
            else
                oneOff = true;
        }
        return oneOff;
    }
}