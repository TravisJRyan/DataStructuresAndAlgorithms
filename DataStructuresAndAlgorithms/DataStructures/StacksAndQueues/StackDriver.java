public class StackDriver{
    public static void main(String[] args){
        Stack<String> myStack = new Stack<String>();
        myStack.push("Hello");
        myStack.push("Second thing!");
        System.out.println(myStack.pop());
        myStack.push("Third thing!");
        System.out.println(myStack.pop());
    }
}