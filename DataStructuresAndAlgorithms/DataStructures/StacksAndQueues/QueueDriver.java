public class QueueDriver{
    public static void main(String[] args){
        Queue<String> myQueue = new Queue<String>();
        myQueue.add("Hello");
        myQueue.add("Second element");
        myQueue.add("Third element");
        System.out.println("expecting hello: "+myQueue.remove());
        System.out.println("expecting second element: "+myQueue.peek());
    }
}