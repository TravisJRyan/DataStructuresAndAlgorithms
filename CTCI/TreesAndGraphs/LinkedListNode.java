public class LinkedListNode<T>{
    public T value;
    public LinkedListNode<T> next;

    public LinkedListNode(T value){
        this.value = value;
    }

    public LinkedListNode<T> getNext(){
        return next;
    }

    public void setNext(LinkedListNode<T> next){
        this.next = next;
    }

    public void setValue(T value){
        this.value = value;
    }

    public T getValue(){
        return value;
    }

    public boolean hasNext(){
        return next!=null;
    }

}