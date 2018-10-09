/* 
    4.4 Check Balanced - Write a method to determine if a tree is balanced. For purposes of this question,
    a balanced tree can be defined by a tree where no two leaf nodes differ in height by more than one.
*/

public class CheckBalanced{
    public static void main(String[] args){
        BinarySearchTree<Integer> trueExampleTree = new BinarySearchTree<Integer>();
        trueExampleTree.add(50);
        trueExampleTree.add(25);
        trueExampleTree.add(75);
        trueExampleTree.add(12);
        trueExampleTree.add(37);
        trueExampleTree.add(63);
        trueExampleTree.add(87);
        trueExampleTree.add(95);
        BinarySearchTree<Integer> falseExampleTree = new BinarySearchTree<Integer>();
        falseExampleTree.add(1);
        falseExampleTree.add(2);
        falseExampleTree.add(0);
        falseExampleTree.add(3);
        falseExampleTree.add(4);
        falseExampleTree.add(5);
        falseExampleTree.add(6);

        System.out.println("Expecting True: "+isBalanced(trueExampleTree));
        System.out.println("Expecting False: "+isBalanced(falseExampleTree));
    }

    public static boolean isBalanced(BinarySearchTree<Integer> tree){
        return (maxDepth(tree.root) - minDepth(tree.root) <= 1);
    }

    public static int minDepth(BSTNode<Integer> root){
        if(root==null)
            return 0;
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    public static int maxDepth(BSTNode<Integer> root){
        if(root==null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}