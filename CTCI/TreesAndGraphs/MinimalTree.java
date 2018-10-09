/* 
    4.2 Minimal Tree - Given a sorted (increasing order) array with unique integer elements, write an algorithm to create
    a binary search tree with minimal height.
*/

public class MinimalTree{
    public static void main(String[] args){
        int[] testArrayOddLength = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int[] testArrayEvenLength = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        int[] testArrayOneElement = {1};
        getMinTree(testArrayOddLength).inOrder();
        System.out.println("\n");
        getMinTree(testArrayEvenLength).inOrder();
        System.out.println("\n");
        getMinTree(testArrayOneElement).inOrder();
    }

    // O(nlogn) time and space - logn binary search for all N elements
    // O(n) space - all elements must be copied once into the tree
    // Recursive function similar to binary search - finds middle elements of subarrays and inserts, 
    // then doing the same for left/right subarrays
    public static BinarySearchTree<Integer> getMinTree(int[] input){
        BinarySearchTree tree = new BinarySearchTree<Integer>();
        tree.root = getMinTreeAux(input, 0, input.length-1);
        return tree;
    }

    public static BSTNode getMinTreeAux(int[] input, int start, int end){
        if(end<start)
            return null;
        int middleIndex = (start+end)/2;
        BSTNode<Integer> node = new BSTNode<Integer>(input[middleIndex]);
        node.left = getMinTreeAux(input, start, middleIndex - 1);
        node.right = getMinTreeAux(input, middleIndex + 1, end);
        return node;
    }
}