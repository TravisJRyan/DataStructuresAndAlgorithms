/* 
    2.4 Partition - Write code to partition a linked list around a value x such that all nodes less than x come
    before all nodes greater than or equal to X. If X is contained within the list, the values of x only need
    to be after the elements less than x. The partition element x can appear anywhere in the "right partition". It
    does not need to appear between the left and right partitions.

    Example:    Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition=5]
                Output: 3 -> 1 -> 2-> 10 -> 5 -> 5 -> 8
*/

public class Partition{
    public static void main(String[] args){
        LinkedList<Integer> testList = new LinkedList<Integer>();
        testList.add(3);
        testList.add(5);
        testList.add(8);
        testList.add(5);
        testList.add(10);
        testList.add(2);
        testList.add(1);
        partition(testList, 5).printList();
    }

    //  O(N) time - all elements accessed once, and then smaller elements accessed once again
    //  O(2N) space - smaller and greater lists double the space
    //  Solution: Greater 2 new lists: smaller and greater elements and then merge them
    public static LinkedList<Integer> partition(LinkedList<Integer> list, int partitionElement){
        if(list.head==null)
            return null;
        LinkedListNode<Integer> iterator = list.head;
        LinkedList<Integer> smaller = new LinkedList<Integer>();
        LinkedList<Integer> greater = new LinkedList<Integer>();
        LinkedListNode<Integer> smallerLastNode; 
        while(iterator!=null){
            if(iterator.getValue()>=partitionElement){
                greater.add(iterator.getValue());
            } else{
                smaller.add(iterator.getValue());
            }
            iterator = iterator.next;
        }
        // Join smaller and greater lists
        if(smaller.head!=null){
            LinkedListNode<Integer> current = smaller.head;
            while(current.next!=null)
                current = current.next;
            current.next = greater.head;
        }
        return smaller;
    }

}