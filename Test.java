import java.util.LinkedList;

public class Test{

    public static void basicTest(){
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
        
        BFS bfs = new BFS(G);
        System.out.println(bfs.search(v2, v4));
        r = bfs.route(v2,v4);
        System.out.println(bfs.search(v2, v3));
        r = bfs.route(v2,v3);
        System.out.println(bfs.search(v1, v5));
    }

    public static void main(String[] args){
        
        Rubik R = Rubik.finalState(), S = Rubik.finalState();
        R.print();
        R.moveD();
        R.print();
        R.moveD2();
        R.print();

        RubikGraph RG = new RubikGraph();
        BFS bfs2 = new BFS(RG);
        System.out.println(bfs2.search(R, S));
    }
}
