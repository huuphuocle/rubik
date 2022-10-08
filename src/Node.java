public class Node{
    public static int counter = 0;

    public enum Move {
        O, D, U, B, F, R, L
    }

    protected Rubik rubik;
    protected int dist;
    private Move edgeLabel; // store the move to arrive to current state

    public Node(Rubik r){
        dist = 0;
        edgeLabel = Move.O;
        rubik = r;
        ++counter;
    }

    public Node(Rubik r, Move label){
        dist = 0;
        edgeLabel = label;
        rubik = r;
        ++counter;
    }

    public Rubik getRubik(){
        return rubik;
    }

    public Move getLabel(){
        return edgeLabel;
    }

    public void setLabel(Move label){
        edgeLabel = label;
    }

    public int getDist(){
        return dist;
    }

    public void setDist(int d){
        dist = d;
    }


    @Override
    public String toString(){
        return "(" + edgeLabel +")" + rubik.toString();
    }

    @Override
    public int hashCode(){
        return rubik.hashCode();
    }

    @Override
    public boolean equals(Object o){
        return rubik.equals(((Node) o).rubik);
    }
}
