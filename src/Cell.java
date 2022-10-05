public class Cell {

    public Color[] faces;

    public Cell(Color[] faces){
        this.faces = faces;
    }

    public void shiftF(){
        Color temp = faces[2];
        faces[2] = faces[1];
        faces[1] = faces[0];
        faces[0] = temp;
    }

    public void shiftB(){
        Color temp = faces[0];
        faces[0] = faces[1];
        faces[1] = faces[2];
        faces[2] = temp;
    }

    @Override
    public boolean equals(Object o){
        Cell co = (Cell) o;
        return faces[0] == co.faces[0] && faces[1] == co.faces[1] 
                && faces[2] == co.faces[2];
    }
}
