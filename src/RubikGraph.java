import java.util.LinkedList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;

public class RubikGraph{

    private static RubikGraph graph;

    private HashSet<Node> vertices;
    private HashMap<Node, LinkedList<Node>> adjacency;

    protected HashSet<Node> visited;
    protected HashMap<Node, Node> parent;
    private LinkedList<Node> processing_queue;

    private RubikGraph(){
        vertices = new HashSet<Node>();
        adjacency = new HashMap<Node, LinkedList<Node>>();
        visited = new HashSet<Node>();
        parent = new HashMap<Node, Node>();
        processing_queue = new LinkedList<Node>();
    }

    public static RubikGraph getGraph(){
        if(graph == null){
            graph = new RubikGraph();
        }
        return graph;
    }

    public void clear(){
        visited.clear();
        parent.clear();
        processing_queue.clear();
    }

    public HashSet<Node> getVertices(){
        // try{
        //     return (HashSet<Node>) vertices.clone();
        // } catch (Exception e){
        //     System.out.println("Graph's getVertices fails.");
        //     return null;
        // }
        return vertices;
    }

    public HashMap<Node, Node> getParent(){
        return parent;
    }

    public void addNode(Node v, LinkedList<Node> edges){
        if(!vertices.contains(v)){
            vertices.add(v);
            adjacency.put(v, edges);
        }else{}
    }

    public void addEdge(Node v, Node w){
        LinkedList<Node> list = adjacency.get(v);
        list.add(w);
        list = adjacency.get(w);
        list.add(v);
    }

    public LinkedList<Node> getNeighbors(Node v){
        Rubik ro = v.getRubik();
        LinkedList<Node> neighbors = new LinkedList<Node>();

        Rubik r = ro.copy(); r.moveD();
        neighbors.add(new Node(r, Node.Move.D));

        r = ro.copy(); r.moveU();
        neighbors.add(new Node(r, Node.Move.U));

        r = ro.copy(); r.moveB();
        neighbors.add(new Node(r, Node.Move.B));

        r = ro.copy(); r.moveF();
        neighbors.add(new Node(r, Node.Move.F));

        r = ro.copy(); r.moveR();
        neighbors.add(new Node(r, Node.Move.R));

        r = ro.copy(); r.moveL();
        neighbors.add(new Node(r, Node.Move.L));

        return neighbors;
    }

    public void bfs(Node v){
        clear();

        processing_queue.add(v);
        v.setDist(0);
        LinkedList<Node> list_neighbors;
        Iterator<Node> it;
        int dist;

        while(processing_queue.size() != 0){
            Node u = processing_queue.poll();
            visited.add(u);
            dist = u.getDist()+1;

            list_neighbors = getNeighbors(u);
            it = list_neighbors.iterator();
            while(it.hasNext()){
                Node p = it.next();
                if(!visited.contains(p)){
                    p.setDist(dist);
                    processing_queue.add(p);
                    parent.put(p, u);
                }
            }
        }
    }

    public boolean search(Node v, Node w){
        clear();

        processing_queue.add(v);
        v.setDist(0);
        LinkedList<Node> list_neighbors;
        Iterator<Node> it;
        int dist;

        while(processing_queue.size() != 0){
            Node u = processing_queue.poll();
            visited.add(u);
            dist = u.getDist()+1;
            list_neighbors = getNeighbors(u);
            addNode(v, list_neighbors);

            it = list_neighbors.iterator();
            while(it.hasNext()){
                Node p = it.next();
                if(!visited.contains(p)){
                    p.setDist(dist);
                    parent.put(p, u);
                    if(w.equals(p)){
                        w.setLabel(p.getLabel());
                        visited.add(p);
                        return true;
                    }
                    processing_queue.add(p);
                }
            }
        }
        return false;
    }

    public LinkedList<Node> route(Node v, Node w){
        LinkedList<Node> trace = new LinkedList<Node>();
        Node u = w;
        trace.addFirst(u);
        while(!u.equals(v)){
            u = parent.get(u);
            trace.addFirst(u);
        }
        return trace;
    }

    public static void printRoute(LinkedList<Node> trace){
        System.out.print("Route : ");
        Iterator<Node> it = trace.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " -> ");
        }
        System.out.println();
    }
}
