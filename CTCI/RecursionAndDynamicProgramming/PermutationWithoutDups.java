/*
    8.7 - Write a method to compute all permutations of a string of unique characters.
*/

import java.util.ArrayList;

public class PermutationWithoutDups{
    public static void main(String[] args){
        ArrayList<String> perms1 = getPermutations("abcdefg");
        for(String permutation: perms1)
            System.out.println(permutation);
        
        System.out.println("\n================\n");
        ArrayList<String> perms2 = getPermutations("abc");
        for(String permutation: perms2)
            System.out.println(permutation);
        
    }

    // aux function to set up recursive calls
    public static ArrayList<String> getPermutations(String input){
        ArrayList<String> permutations = new ArrayList<String>();
        getPermutations("", input, permutations);
        return permutations;
    }

    // Build on the current built string until it is a complete permutation
    // Insert the new character at each stack depth at every possible place it could be added
    // Repeat until all permutations printed
    // O(n^2 * n!) - n! for each permutation being called and n^2 for the string building for each permutation
    public static void getPermutations(String current, String remainder, ArrayList<String> finalArray){
        //System.out.println(current);
        if(remainder.length()==0){
            finalArray.add(current);
            return;
        }
        for(int i = 0; i < remainder.length(); i++){
            String before = remainder.substring(0,i);
            String after = remainder.substring(i+1, remainder.length());
            char newChar = remainder.charAt(i);
            getPermutations(current+newChar, before+after, finalArray);
        }
    }

}