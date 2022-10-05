import java.util.Iterator;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Stack;

public class DFS extends Traversal{
    
    private Stack<Node> processing_stack;

    public DFS(Graph G){
        super(G);
        processing_stack = new Stack<Node>();
    }

    @Override
    public boolean search(Node v, Node w){
        parent.clear();
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
}
