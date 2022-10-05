import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph{
    private HashSet<Node> vertices;
    private HashMap<Node, LinkedList<Node>> adjacency;

    public Graph(){
        vertices = new HashSet<Node>();
        adjacency = new HashMap<Node, LinkedList<Node>>();
    }

    public LinkedList<Node> getNeighbors(Node v){
        return adjacency.get(v);
    }

    public void addNode(Node v){
        vertices.add(v);
        adjacency.putIfAbsent(v, new LinkedList<Node>());
    }

    public void addEdge(Node v, Node w){
        LinkedList<Node> list = adjacency.get(v);
        list.add(w);
        list = adjacency.get(w);
        list.add(v);
    }

    public void printGraph(){
        Iterator<Node> it_edges;
        for(Node v : vertices){
            System.out.print(v.getLabel() + " : ");
            it_edges = getNeighbors(v).iterator();
            while(it_edges.hasNext())
                System.out.print(it_edges.next().getLabel() + " ");

            System.out.println();
        }
    }
}