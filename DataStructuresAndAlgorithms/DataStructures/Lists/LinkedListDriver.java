public class LinkedListDriver{
    public static void main(String[] args){
        LinkedList<String> stringList = new LinkedList<String>();
        stringList.add("Hello!");
        stringList.add("Goodbye!");
        System.out.println(stringList.getSize());
        stringList.remove("Hello!");
        System.out.println(stringList.getSize());
        stringList.printList();
    }
}