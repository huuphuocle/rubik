import java.util.Iterator;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.HashMap;

public abstract class Traversal{
    protected Graph G;
    protected HashSet<Node> visited;
    protected HashMap<Node, Node> parent;

    protected Traversal(Graph G){
        this.G = G;
        visited = new HashSet<Node>();
        parent = new HashMap<Node, Node>();
    }

    public LinkedList<Node> route(Node v, Node w){
        System.out.println("Route from v to w : ");
        LinkedList<Node> trace = new LinkedList<Node>();
        Node u = w;
        trace.add(u);
        while(!u.equals(v)){
            System.out.print(u.getLabel() + " -> ");
            u = parent.get(u);
            trace.add(u);
        }
        System.out.println(u.getLabel());
        return trace;
    }

    public abstract boolean search(Node v, Node w);
}