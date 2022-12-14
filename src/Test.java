import java.util.LinkedList;

public class Test{

    public static void testRubik(){
        Rubik R = Rubik.finalState();
        System.out.println("Final state:");
        System.out.println(R);
        System.out.println("Neighbors of the final state:");
        RubikGraph RG = RubikGraph.getGraph();
        LinkedList<Node> neighbors = RG.getNeighbors(new Node(R));
        for(int i = 0; i < 6; ++i){
            System.out.println(neighbors.get(i).rubik);
        }

        System.out.println("A sequence of moves:");
        R.moveD();
        System.out.println(R);
        R.moveB();
        System.out.println(R);
        R.moveR();
        System.out.println(R);
        R.moveF();
        System.out.println(R);
        R.moveU();
        System.out.println(R);
        R.moveL();
        System.out.println(R);
    }

    public static Rubik createState(){
        Rubik R = Rubik.finalState();
        R.moveD();
        R.moveB();
        // R.moveR();
        // R.moveF();
        // R.moveU();
        // R.moveL();
        return R;
    }

    public static void main(String[] args){
        // testRubik();
        Rubik R = createState(), S = Rubik.finalState();
        Node v = new Node(R), w = new Node(S);
        RubikGraph RG = RubikGraph.getGraph();
        System.out.println(Node.counter);
        // RG.search(v, w);
        // LinkedList<Node> route = RG.route(v, w);
        // RubikGraph.printRoute(route);
        RG.bfs(w);
    }
}
