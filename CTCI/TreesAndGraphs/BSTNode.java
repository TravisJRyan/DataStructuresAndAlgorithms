public class BSTNode<T extends Comparable>{

    T value;
    BSTNode left;
    BSTNode right;

    public BSTNode(T value){
        this.value = value;
    }

    public BSTNode getLeft(){
        return left;
    }

    public BSTNode getRight(){
        return right;
    }

    public T getValue(){
        return value;
    }

    public void setLeft(BSTNode newLeft){
        left = newLeft;
    }

    public void setRight(BSTNode newRight){
        right = newRight;
    }
}