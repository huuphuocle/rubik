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
        LinkedList<Node> trace = new LinkedList<Node>();
        Node u = w;
        trace.add(u);
        while(!u.equals(v)){
            u = parent.get(u);
            trace.add(u);
        }
        return trace;
    }

    public HashMap<Node, Node> getParent(){
        return parent;
    }

    public static void printRoute(LinkedList<Node> trace){
        System.out.println("Route : ");
        Iterator<Node> it = trace.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " -> ");
        }
    }

    public abstract boolean search(Node v, Node w);
}