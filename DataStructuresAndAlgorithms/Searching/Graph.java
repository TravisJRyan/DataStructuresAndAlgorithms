import java.util.ArrayList;

public class Graph{

    ArrayList<Node> nodes;

    public Graph(){
        nodes = new ArrayList<Node>();
    }

    public ArrayList<Node> getNodes(){
        return nodes;
    }

    public void add(Node newNode){
        nodes.add(newNode);
    }
}