import java.util.HashSet;

/* 
    2.7 Intersection - Given two (singly) linked lists, determine if the two lists intersect. Return the
    intersecting node. Intersection is defined based on reference, not by value. That is, if the kth node of the
    first linked list is the exact same node (by reference) as the jth node of the second linked list, they are intersecting
*/

public class Intersection {
    public static void main(String[] args){
        LinkedList<Integer> trueTestList1 = new LinkedList<Integer>();
        LinkedList<Integer> trueTestList2 = new LinkedList<Integer>();
        LinkedList<Integer> falseTestList1 = new LinkedList<Integer>();
        LinkedList<Integer> falseTestList2 = new LinkedList<Integer>();

        // One similar reference, should return the node
        LinkedListNode<Integer> intersectingNode = new LinkedListNode<Integer>(6);
        trueTestList1.add(3);
        trueTestList1.head.next = intersectingNode;
        trueTestList1.add(4);
        trueTestList1.add(12);
        trueTestList2.add(9);
        trueTestList2.add(8);
        trueTestList2.head.next.next = intersectingNode;
        trueTestList2.add(3);
        System.out.println("Expected True: "+getIntersection(trueTestList1, trueTestList2));

        // No references are the same, should return false
        falseTestList1.add(4);
        falseTestList1.add(5);
        falseTestList1.add(8);
        falseTestList1.add(7);
        falseTestList2.add(9);
        falseTestList2.add(8);
        falseTestList2.add(3);
        falseTestList2.add(12);
        System.out.println("Expected Null: "+getIntersection(falseTestList1, falseTestList2));
    }

    // O(n) time - iterating through each list once; can't do any better because all elements must be accessed
    // O(2n) space - Have to copy every Node from the first list into a hashSet
    // Simple solution: Use a HashSet to store every Node from the first list, then check for repeats in the second list
    public static LinkedListNode<Integer> getIntersection(LinkedList<Integer> firstList, LinkedList<Integer> secondList){
        if(firstList == null || secondList == null)
            return null;
        HashSet<LinkedListNode<Integer>> nodeSet = new HashSet<LinkedListNode<Integer>>();
        LinkedListNode<Integer> current = firstList.head;
        while(current!=null){
            nodeSet.add(current);
            current = current.next;
        }
        current = secondList.head;
        while(current!=null){
            if(nodeSet.contains(current))
                return current;
            current = current.next;
        }
        return null;
    }

}