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

    public static void main(String[] args){
        Node v1 = new Node(1), v2 = new Node(2), v3 = new Node(3);
        Node v4 = new Node(4), v5 = new Node(5);
        Graph G = new Graph();
        G.addNode(v1);
        G.addNode(v2);
        G.addNode(v3);
        G.addNode(v4);
        G.addNode(v5);
        G.addEdge(v1,v2);
        G.addEdge(v1,v3);
        G.addEdge(v3,v4);
        G.printGraph();
        
        DFS dfs = new DFS(G);
        System.out.println(dfs.search(v2, v4));
        LinkedList<Node> r = dfs.route(v2,v4);
        System.out.println(dfs.search(v1, v2));
        r = dfs.route(v1,v2);
        System.out.println(dfs.search(v1, v5));
        // r = search.route(v1,v5);
        
        BFS bfs = new BFS(G);
        System.out.println(bfs.search(v2, v4));
        r = bfs.route(v2,v4);
        System.out.println(bfs.search(v2, v3));
        r = bfs.route(v2,v3);
        System.out.println(bfs.search(v1, v5));
        // r = search2.route(v1,v5);

        Rubik R = Rubik.finalState();
        R.print();
        R.moveD();
        R.print();
        R.moveD2();
        R.print();
    }
}