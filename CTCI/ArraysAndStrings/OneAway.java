/*
    1.5 One Away - Return a boolean based on whether or not a String is
    one away from another String. Valid edits are inserting a character,
    removing a character, or replacing a character
*/

public class OneAway {
    public static void main(String[] args){
        System.out.println("True :"+oneAway("cat","ct"));
        System.out.println("True :"+oneAway("cat","cabt"));
        System.out.println("True :"+oneAway("cat","czt"));
        System.out.println("False :"+oneAway("cat","c"));
        System.out.println("False :"+oneAway("this string is more than one away","this stzzng is more than one away"));
        System.out.println("False :"+oneAway("falseTest","fazseTesz"));
    }

    public static boolean oneAway(String firstInput, String secondInput){
        if(Math.abs(firstInput.length()-secondInput.length())>1)
            return false;
        return true;
    }
}