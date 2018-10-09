import java.util.ArrayList;
import java.util.LinkedList;

/* 
    4.3 List of Depths - Given a binary tree, design an algorithm which creates a linked list of all the
    nodes at each depth (e.g. if you have a tree with depth D, you'll have D linked lists)
*/

public class ListOfDepths{
    public static void main(String[] args){
        BinarySearchTree<Integer> testTree = new BinarySearchTree<Integer>();
        testTree.add(5);
        testTree.add(4);
        testTree.add(12);
        testTree.add(19);
        testTree.add(42);
        testTree.add(45);
        testTree.add(8);
        testTree.add(0);
        testTree.add(120);
        testTree.add(39);
        ArrayList<LinkedList<BSTNode<Integer>>> lists = getListOfDepths(testTree);
        for(LinkedList<BSTNode<Integer>> list : lists){
            for(BSTNode<Integer> node : list){
                System.out.print(node.value+" ");
            }
            System.out.println();
        }
    }

    // O(N) time and space - must access all elements and copy them all for returning
    // A variation on breadth first search - visit each depth in order from top to bottom
    public static ArrayList<LinkedList<BSTNode<Integer>>> getListOfDepths(BinarySearchTree<Integer> tree){
        BSTNode<Integer> root = tree.root;
        ArrayList<LinkedList<BSTNode<Integer>>> result = new ArrayList<LinkedList<BSTNode<Integer>>>();
        LinkedList<BSTNode<Integer>> current = new LinkedList<BSTNode<Integer>>(); // first depth
        if(root != null)
            current.add(root); // if it exists, add the root to the top depth
        while(current.size() > 0){ // while there exists something in the current depth
            result.add(current); // add the previous depth's list
            LinkedList<BSTNode<Integer>> parents = current; // use the old list as parents
            current = new LinkedList<BSTNode<Integer>>(); // create a new list for the current depth
            for(BSTNode<Integer> parent: parents){ // add all nodes from the parents to the current depth
                if(parent.left!=null)
                    current.add(parent.left);
                if(parent.right!=null)
                    current.add(parent.right);
            }
        }
        return result; // found an empty depth, return the resulting list of lists
    }
}