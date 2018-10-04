import java.util.HashMap;

public class CheckPermutation{
    public static void main(String[] args){
        String isPerm1 = "catdog7";
        String isPerm2 = "cgo7tad";
        String notPerm1 = "hello!";
        String notPerm2 = "hello!!";
        String anotherNotPerm1 = "atest";
        String anotherNotPerm2 = "atelst";
        String anotherIsPerm1 = "819x910";
        String anotherIsPerm2 = "1x80991";
        System.out.println(isPermuation(isPerm1, isPerm2));
        System.out.println(isPermuation(notPerm1, notPerm2));
        System.out.println(isPermuation(anotherNotPerm1, anotherNotPerm2));
        System.out.println(isPermuation(anotherIsPerm1, anotherIsPerm2));
    }

    public static boolean isPermuation(String firstInput, String secondInput){
        if(firstInput.length() != secondInput.length())
            return false;
        HashMap<Character, Integer> includedChars = new HashMap<Character, Integer>();
        for(int i = 0; i < firstInput.length(); i++){ // Populate hashMap with values from first input
            if(includedChars.containsKey(firstInput.charAt(i)))
                includedChars.put(firstInput.charAt(i), includedChars.get( firstInput.charAt(i) )+1);
            else
                includedChars.put(firstInput.charAt(i), 1);
        }
        for(int i = 0; i < secondInput.length(); i++){
            if(!includedChars.containsKey(secondInput.charAt(i)) || includedChars.get(secondInput.charAt(i)) < 1)
                return false;
            else
                includedChars.put(secondInput.charAt(i), includedChars.get(secondInput.charAt(i))-1);
        }
        return true;
    }

}