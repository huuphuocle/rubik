public class Node{
    private int label;

    public Node(int label){
        this.label = label;
    }

    public int getLabel(){
        return label;
    }

    @Override
    public int hashCode(){
        return label;
    }

    @Override
    public boolean equals(Object o){
        return label == ((Node) o).label;
    }
}
