import java.util.Iterator;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.HashMap;

public class BFS extends Traversal{
    private LinkedList<Node> processing_queue;

    public BFS(Graph G){
        super(G);
        processing_queue = new LinkedList<Node>();
    }

    @Override
    public boolean search(Node v, Node w){
        parent.clear();
        processing_queue.add(v);
        LinkedList<Node> list_neighbors;
        Iterator<Node> it;

        while(processing_queue.size() != 0){
            Node u = processing_queue.poll();
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
                    processing_queue.add(p);
                    parent.put(p, u);
                }
            }
        }
        visited.clear();
        return false;
    }
}