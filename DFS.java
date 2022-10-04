import java.util.Iterator;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Stack;

public class DFS{
    private Graph G;
    private HashSet<Node> visited;
    private Stack<Node> processing_stack;
    private HashMap<Node, Node> parent;

    public DFS(Graph G){
        this.G = G;
        visited = new HashSet<Node>();
        processing_stack = new Stack<Node>();
        parent = new HashMap<Node, Node>();
    }

    public boolean searchDFS(Node v, Node w){
        LinkedList<Node> list_neighbors;
        Iterator<Node> it;

        processing_stack.push(v);
        parent.put(v, null);

        while(!processing_stack.empty()){
            Node u = processing_stack.pop();
            visited.add(u);
            if(u.equals(w)){
                visited.clear();
                return true;
            }
            list_neighbors = G.getNeighbors(u);
            it = list_neighbors.iterator();
            while(it.hasNext()){
                Node p = it.next();
                if(!visited.contains(p)){
                    parent.put(p, u);
                    processing_stack.push(p);
                }

            }
        }
        visited.clear();
        return false;
    }

    public LinkedList<Node> route(Node v, Node w){
        System.out.println("Route from v to w : ");
        LinkedList<Node> trace = new LinkedList<Node>();
        Node u = w;
        trace.add(u);
        do{
            u = parent.get(u);
            trace.add(u);
        }while(!u.equals(v));
        return trace;
    }
}
