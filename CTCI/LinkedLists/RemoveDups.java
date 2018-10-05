/* 
    2.1 Remove Dups - Write code to remove duplicates from an unsorted linked list. How would you solve
    this problem if a temporary buffer is not allowed?
*/

import java.util.HashSet;

public class RemoveDups{
    public static void main(String[] args){
        // Standard case test
        LinkedList<Integer> testList = new LinkedList<Integer>();
        testList.add(9);
        testList.add(2);
        testList.add(5);
        testList.add(12);
        testList.add(3);
        testList.add(19);
        testList.add(7);
        testList.add(2);
        testList.add(24);
        testList.add(24);
        testList.add(4);
        testList.add(5);
        testList.add(18);
        removeDuplicates(testList);
        testList.printList();
    }

    // Use a HashSet to store seen list elements, delete elements when unseen
    // O(n) time - must visit all elements once
    // O(n+1) space - only new space is the iterator node
    public static void removeDuplicates(LinkedList<Integer> listInput){
        if(listInput.head == null)
            return;
        HashSet<Integer> seenInts = new HashSet<Integer>();
        LinkedListNode<Integer> current = listInput.head;
        seenInts.add(current.getValue());
        while(current.next!=null){
            if(seenInts.contains(current.next.getValue()))
                current.next = current.next.next;
            else{
                seenInts.add(current.getNext().getValue());
                current = current.next;
            }
        }
    }
}