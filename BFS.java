import java.util.Iterator;
import java.util.LinkedList;
import java.util.HashSet;

public class BFS{
    private Graph G;
    private HashSet<Node> visited;
    private LinkedList<Node> processing_queue;

    public BFS(Graph G){
        this.G = G;
        visited = new HashSet<Node>();
        processing_queue = new LinkedList<Node>();
    }

    public boolean searchBFS(Node v, Node w){
        processing_queue.add(v);
        LinkedList<Node> list_neighbors;
        Iterator<Node> it;

        while(processing_queue.size() != 0){
            Node u = processing_queue.poll();
            if(u.equals(w)){
                visited.clear();
                return true;
            }
            list_neighbors = G.getNeighbors(u);
            it = list_neighbors.iterator();
            while(it.hasNext()){
                u = it.next();
                if(!visited.contains(u)){
                    visited.add(u);
                    processing_queue.add(u);
                }

            }
        }
        visited.clear();
        return false;
    }
}