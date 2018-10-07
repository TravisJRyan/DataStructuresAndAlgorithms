/* 
    2.5 Sum Lists - You have two numbers represented by linked lists where each node contains a single digit.
    The digits are stored in reverse order such that the 1's digit is at the head of the list. Write a function that
    adds the two numbers and returns the sum as a linked list.

    Follow Up: Suppose digits are in forward order. Repeat the same problem.
*/

public class SumLists{
    public static void main(String[] args){
        LinkedList<Integer> firstNumberTest = new LinkedList<Integer>();
        LinkedList<Integer> secondNumberTest = new LinkedList<Integer>();
        // First number: 617
        firstNumberTest.add(7);
        firstNumberTest.add(1);
        firstNumberTest.add(6);
        // Second number: 295
        secondNumberTest.add(5);
        secondNumberTest.add(9);
        secondNumberTest.add(2);
        
        sumReverse(firstNumberTest, secondNumberTest).printList(); // Expected Result: 2 -> 1 -> 9 (912)
        sumForward(firstNumberTest, secondNumberTest).printList(); // Expected Result: 1 -> 3 -> 0 -> 8 (1308)
    }

    // Time - O(N) where N is the length of the integer in digits. For small enough integers, essentially O(1)
    // Space - O(3N) where N is average int length. Very small space in typical case.
    public static LinkedList<Integer> sumReverse(LinkedList<Integer> firstList, LinkedList<Integer> secondList){
        int firstInt = getNumberFromReverseList(firstList);
        int secondInt = getNumberFromReverseList(secondList);
        int sum = firstInt + secondInt;
        return getReverseListFromNumber(sum);
    }

    // Aux method that gets an integer from digits in reversed linked list
    public static int getNumberFromReverseList(LinkedList<Integer> list){
        LinkedListNode<Integer> current = list.head;
        int multiplyFactor = 1;
        int sum = 0;
        while(current!=null){
            sum += multiplyFactor*current.getValue();
            multiplyFactor*=10;
            current = current.next;
        }
        return sum;
    }

    // Aux method that generates a linked list in reverse order for a number
    public static LinkedList<Integer> getReverseListFromNumber(int input){
        LinkedList<Integer> output = new LinkedList<Integer>();
        while(input!=0){
            output.add(input%10);
            input /= 10;
        }
        return output;
    }

    /* ========================
        The same problem but now assuming that the integers in the lists are presented in forward order
        Solution uses string conversion for easy parsing of int values sequentially
        O(N) time - iterate through each int (as a string) several times
        O(4N) space - only additional space is the StringBuilder and then Strings of the values. Very small because only integers are represented
    */
    public static LinkedList<Integer> sumForward(LinkedList<Integer> firstList, LinkedList<Integer> secondList){
        int firstInt = getNumberFromForwardList(firstList);
        int secondInt = getNumberFromForwardList(secondList);
        int sum = firstInt + secondInt;
        return getForwardListFromNumber(sum);
    }

    public static int getNumberFromForwardList(LinkedList<Integer> input){
        StringBuilder intString = new StringBuilder();
        LinkedListNode<Integer> current = input.head;
        while(current!=null){
            intString.append(current.value);
            current = current.next;
        }
        return Integer.parseInt(intString.toString());
    }

    public static LinkedList<Integer> getForwardListFromNumber(int number){
        LinkedList<Integer> result = new LinkedList<Integer>();
        String numberAsString = Integer.toString(number);
        for(int i = 0; i < numberAsString.length(); i++){
            result.add(Integer.parseInt(String.valueOf(numberAsString.charAt(i))));
        }
        return result;
    }
}