public class BinarySearchTreeDriver{
    public static void main(String[] args){
        BinarySearchTree newBst = new BinarySearchTree<Integer>();
        newBst.add(12);
        newBst.add(8);
        newBst.add(23);
        newBst.add(30);
        newBst.add(7);
        newBst.add(6);
        newBst.add(5);
        newBst.add(1);
        newBst.add(42);
        newBst.add(98);
        newBst.add(64);
        newBst.add(39);
        newBst.add(75);
        newBst.inOrder();
        System.out.println();
        newBst.preOrder();
        System.out.println();
        newBst.postOrder();
    }
}