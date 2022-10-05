import java.util.LinkedList;
import java.util.HashSet;
import java.util.HashMap;

public class RubikGraph extends Graph{

    @Override
    public LinkedList<Node> getNeighbors(Node v){
        LinkedList<Node> neighbors = new LinkedList<Node>();
        for(int i = 0; i < 6; ++i){
            neighbors.add(((Rubik)v).clone());
        }
        ((Rubik) neighbors.get(0)).moveD();
        ((Rubik) neighbors.get(1)).moveD2();
        ((Rubik) neighbors.get(2)).moveB();
        ((Rubik) neighbors.get(3)).moveB2();
        ((Rubik) neighbors.get(4)).moveR();
        ((Rubik) neighbors.get(5)).moveR2();
        return neighbors;
    }
}
