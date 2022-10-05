public class Node{
    protected int label;

    public Node(){
        label = 0;
    }
    
    public Node(int label){
        this.label = label;
    }

    public int getLabel(){
        return label;
    }

    @Override
    public String toString(){
        return "" + label;
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
