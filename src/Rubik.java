public class Rubik {

    public enum Color{
        RED, GREEN, BLUE, WHITE, YELLOW, ORANGE
    }

    static class Cell {

        private Color[] faces;

        public Cell(Color[] faces){
            this.faces = faces;
        }

        private void shiftF(){
            Color temp = faces[2];
            faces[2] = faces[1];
            faces[1] = faces[0];
            faces[0] = temp;
        }

        private void shiftB(){
            Color temp = faces[0];
            faces[0] = faces[1];
            faces[1] = faces[2];
            faces[2] = temp;
        }

        @Override
        public int hashCode(){
            return faces[0].ordinal() + faces[1].ordinal() + faces[2].ordinal();
        }

        @Override
        public boolean equals(Object o){
            Cell co = (Cell) o;
            return faces[0] == co.faces[0] && faces[1] == co.faces[1]
                    && faces[2] == co.faces[2];
        }
    }


    private Cell[] state;

    public Rubik(){
        Cell[] state = new Cell[8];
    }

    public Rubik(Cell[] state){
        this.state = state;
    }

    public Rubik copy(){
        Cell[] cells = new Cell[8];
        for(int i = 0; i < 8; ++i){
            cells[i] = new Cell(new Color[]{state[i].faces[0],
                                        state[i].faces[1],state[i].faces[2]});
        }
        return new Rubik(cells);
    }

    public static Rubik finalState(){
        Cell[] cells = new Cell[8];
        cells[0] = new Cell(new Color[]{Color.WHITE, Color.BLUE, Color.RED});
        cells[1] = new Cell(new Color[]{Color.WHITE, Color.ORANGE, Color.BLUE});
        cells[2] = new Cell(new Color[]{Color.WHITE, Color.GREEN, Color.ORANGE});
        cells[3] = new Cell(new Color[]{Color.WHITE, Color.RED, Color.GREEN});
        cells[4] = new Cell(new Color[]{Color.YELLOW, Color.RED, Color.BLUE});
        cells[5] = new Cell(new Color[]{Color.YELLOW, Color.BLUE, Color.ORANGE});
        cells[6] = new Cell(new Color[]{Color.YELLOW, Color.ORANGE, Color.GREEN});
        cells[7] = new Cell(new Color[]{Color.YELLOW, Color.GREEN, Color.RED});

        return new Rubik(cells);
    }

    public void moveD(){
        Cell temp = state[7];
        state[7] = state[6];
        state[6] = state[5];
        state[5] = state[4];
        state[4] = temp;
    }

    public void moveU(){
        Cell temp = state[7];
        state[7] = state[4];
        state[4] = state[5];
        state[5] = state[6];
        state[6] = temp;
    }

    public void moveB(){
        Cell temp = state[3];
        state[3] = state[2];
        state[2] = state[6];
        state[6] = state[7];
        state[7] = temp;
        state[3].shiftF();
        state[2].shiftB();
        state[6].shiftF();
        state[7].shiftB();
    }

    public void moveF(){
        moveB();moveB();moveB();
        // Cell temp = state[3];
        // state[3] = state[7];
        // state[7] = state[6];
        // state[6] = state[2];
        // state[2] = temp;
    }

    public void moveR(){
        Cell temp = state[1];
        state[1] = state[5];
        state[5] = state[6];
        state[6] = state[2];
        state[2] = temp;
        state[1].shiftB();
        state[5].shiftF();
        state[6].shiftB();
        state[2].shiftF();
    }

    public void moveL(){
        moveR();moveR();moveR();
        // Cell temp = state[1];
        // state[1] = state[2];
        // state[2] = state[6];
        // state[6] = state[5];
        // state[5] = temp;
    }

    @Override
    public boolean equals(Object o){
        Rubik ro = (Rubik) o;
        for(int i = 0; i < 8; ++i){
            if(!state[i].equals(ro.state[i])) return false;
        }
        return true;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("===================================\n");

        s.append("U : " + state[0].faces[0] + ", " + state[3].faces[0]
            + ", " + state[2].faces[0] + ", " + state[1].faces[0] + "\n");

        s.append("D : " + state[4].faces[0] + ", " + state[5].faces[0]
            + ", " + state[6].faces[0] + ", " + state[7].faces[0] + "\n");

        s.append("R : " + state[1].faces[1] + ", " + state[2].faces[2]
            + ", " + state[6].faces[1] + ", " + state[5].faces[2] + "\n");

        s.append("L : " + state[3].faces[1] + ", " + state[0].faces[2]
            + ", " + state[4].faces[1] + ", " + state[7].faces[2] + "\n");

        s.append("F : " + state[0].faces[1] + ", " + state[1].faces[2]
            + ", " + state[5].faces[1] + ", " + state[4].faces[2] + "\n");

        s.append("B : " + state[2].faces[1] + ", " + state[3].faces[2]
            + ", " + state[7].faces[1] + ", " + state[6].faces[2] + "\n");

        s.append("===================================");
        return s.toString();
    }

    @Override
    public int hashCode(){
        return state[0].faces[0].ordinal() + state[1].faces[0].ordinal()
                + state[2].faces[0].ordinal() + state[3].faces[0].ordinal();
    }
}
