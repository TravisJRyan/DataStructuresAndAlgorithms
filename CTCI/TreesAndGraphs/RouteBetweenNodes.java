/* 
    4.1 Route Between Nodes - Given a directed graph, design an algorithm to find out whether there is a route between
    two nodes.
*/

import java.util.Stack;

public class RouteBetweenNodes{

    public static void main(String[] args){
        Node node1 = new Node(4);
        Node node2 = new Node(12);
        Node node3 = new Node(42);
        Node node4 = new Node(103);
        Node node5 = new Node(43);
        Node node6 = new Node(59);
        Node node7 = new Node(18);
        Node node8 = new Node(0);
        Node node9 = new Node(81);
        node1.addAdjacent(node2);
        node1.addAdjacent(node3);
        node3.addAdjacent(node4);
        node4.addAdjacent(node6);
        node5.addAdjacent(node3);
        node2.addAdjacent(node5);
        node7.addAdjacent(node1);
        node8.addAdjacent(node5);
        Graph testGraph = new Graph();
        testGraph.add(node1);
        testGraph.add(node2);
        testGraph.add(node3);
        testGraph.add(node4);
        testGraph.add(node5);
        testGraph.add(node6);
        testGraph.add(node7);
        testGraph.add(node8);
        testGraph.add(node9);
        System.out.println("Expect True: "+pathExists(testGraph, node1, node8));
        System.out.println("Expect False: "+pathExists(testGraph, node1, node9));
    }

    // Breadth First Search Solution
    // O(B^d) space and time (B is branching factor, D is depth)
    public static boolean pathExists(Graph graph, Node start, Node end){
        for(Node unvisited : graph.getNodes()) // mark all nodes as unvisited
            unvisited.state = Node.State.Unvisited;
        Stack<Node> nodeStack = new Stack<Node>(); // use a stack to keep track of nodes to visit
        start.state = Node.State.Visiting;
        nodeStack.push(start); // start by visiting start node
        while(!nodeStack.isEmpty()){ // while the stack isn't empty, continue checking
            Node current = nodeStack.pop(); // get node from top of stack
            for(Node adjacent: current.getAdjacent()){ // for all its adjacent nodes
                if(adjacent.state == Node.State.Unvisited){ // if unvisited
                    if(adjacent == end) // check for solution, return true is necessary
                        return true;
                    adjacent.state = Node.State.Visiting; // check the adjacent state as visiting
                    nodeStack.add(adjacent); // add it to stack for searching
                }
            }
            current.state = Node.State.Visited; // mark visited node as Visited
        }
        return false; // no path was found
    }
}